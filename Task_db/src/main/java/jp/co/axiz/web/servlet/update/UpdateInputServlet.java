package jp.co.axiz.web.servlet.update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.servlet.SessionInfo;
import jp.co.axiz.web.util.ParamUtil;


@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        // 入力値取得
        String loginId = request.getParameter("loginId");
        String userName = request.getParameter("userName");
        String tel = request.getParameter("tel");
        String pass = request.getParameter("pass");
        String roleIdStr = request.getParameter("roleId");

        Integer roleId = ParamUtil.checkAndParseInt(roleIdStr);

        // セッション情報取得
        HttpSession session = request.getSession();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

        // 変更後データを入力値で更新する
        UserInfo updateUser = sessionInfo.getUpdateUser();

        updateUser.setRoleId(roleId);

        // 選択したroleIdに対応するroleNameをセット
        updateUser.setRoleName(ParamUtil.getRoleNameByRoleId(roleId, sessionInfo.getRoleList()));

        // 入力値チェック
        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {
            request.setAttribute("idErrMsg", "IDは必須です");
            hasError = true;
        } else {
            updateUser.setLoginId(loginId);
        }

        if (ParamUtil.isNullOrEmpty(userName)) {
            request.setAttribute("nameErrMsg", "名前は必須です");
            hasError = true;
        } else {
            updateUser.setUserName(userName);
        }

        if (ParamUtil.isNullOrEmpty(tel)) {
            request.setAttribute("telErrMsg", "TELは必須です");
            hasError = true;
        } else {
            updateUser.setTelephone(tel);
        }

        if (ParamUtil.isNullOrEmpty(pass)) {
            request.setAttribute("passErrMsg", "PASSは必須です");
            hasError = true;
        } else {
            updateUser.setPassword(pass);
        }

        if (hasError) {
            request.getRequestDispatcher("updateInput.jsp").forward(request, response);
            return;
        }

        // 変更前データを取得
        UserInfo prevUser = sessionInfo.getPrevUpdateUser();

        if (prevUser.equals(updateUser)) {
            // 入力値を変更していない場合
            request.setAttribute("errMsg", "1項目以上変更してください");
            request.getRequestDispatcher("updateInput.jsp").forward(request, response);
            return;
        }

        // ID重複チェック
        UserInfoService userInfoService = new UserInfoService();

        if (userInfoService.existsUserByLoginIdExcludingUserId(loginId, updateUser.getUserId())) {
            // login_idが重複していた場合
            request.setAttribute("errMsg", "IDが重複しています");
            request.getRequestDispatcher("updateInput.jsp").forward(request, response);
            return;
        }

        if (prevUser.getPassword().equals(updateUser.getPassword())) {
            // パスワードを変更していない場合
            // (更新内容確認画面で初期値としてセットするため、リクエストスコープに保存)
            request.setAttribute("rePass", updateUser.getPassword());
        }

        request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
    }
}