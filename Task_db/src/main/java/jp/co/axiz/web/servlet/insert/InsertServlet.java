package jp.co.axiz.web.servlet.insert;

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

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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

        // 入力値をEntityにセット
        UserInfo userInfo = new UserInfo(null, loginId, userName, tel, pass, roleId);

        // セッション情報を取得
        HttpSession session = request.getSession();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

        // 選択したroleIdに対応するroleNameをセット
        userInfo.setRoleName(ParamUtil.getRoleNameByRoleId(roleId, sessionInfo.getRoleList()));

        // 入力情報をセッションへ保存
        sessionInfo.setRegisterUser(userInfo);

        // 入力値チェック
        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {
            request.setAttribute("idErrMsg", "IDは必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(userName)) {
            request.setAttribute("nameErrMsg", "名前は必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(tel)) {
            request.setAttribute("telErrMsg", "TELは必須です");
            hasError = true;
        }

        if (ParamUtil.isNullOrEmpty(pass)) {
            request.setAttribute("passErrMsg", "PASSは必須です");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("insert.jsp").forward(request, response);
            return;
        }

        // ID重複チェック
        UserInfoService userInfoService = new UserInfoService();

        if (userInfoService.existsUserByLoginId(loginId)) {
            // login_idが重複していた場合
            request.setAttribute("errMsg", "IDが重複しています");
            request.getRequestDispatcher("insert.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
    }
}