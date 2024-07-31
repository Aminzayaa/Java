package jp.co.axiz.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.util.ParamUtil;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
        String pass = request.getParameter("pass");

        // 入力値チェック
        boolean hasError = false;

        // ID入力値チェック
        if (ParamUtil.isNullOrEmpty(loginId)) {
            // 未入力エラー
            request.setAttribute("idErrMsg", "IDは必須です");
            hasError = true;
        }

        // PASS入力値チェック
        if (ParamUtil.isNullOrEmpty(pass)) {
            // 未入力エラー
            request.setAttribute("passErrMsg", "PASSは必須です");
            hasError = true;
        }

        // 入力エラーがある場合はログイン画面に戻る
        if (hasError) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 認証処理
        UserInfoService userInfoService = new UserInfoService();
        UserInfo user = userInfoService.authentication(loginId, pass);

        if (user != null) {
            // Role一覧取得
            RoleService roleService = new RoleService();
            List<Role> roleList = roleService.findAll();

            // ログイン情報、Role一覧をセッションに保存
            HttpSession session = request.getSession();

            SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
            sessionInfo.setLoginUser(user);
            sessionInfo.setRoleList(roleList);

            session.setAttribute("sessionInfo", sessionInfo);

            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            // 認証失敗
            request.setAttribute("errMsg", "IDまたはPASSが間違っています");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}