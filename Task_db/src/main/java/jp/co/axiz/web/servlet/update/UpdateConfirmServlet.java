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


@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmServlet() {
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
        String rePass = request.getParameter("rePass");

        // セッション情報取得
        HttpSession session = request.getSession();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

        // 変更後データを取得
        UserInfo updateUser = sessionInfo.getUpdateUser();

        if (!updateUser.getPassword().equals(rePass)) {
            // 再入力パスワードが一致しない場合
            request.setAttribute("errMsg", "前画面で入力したパスワードと一致しません");
            request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
            return;
        }

        // 更新処理
        UserInfoService userInfoService = new UserInfoService();
        userInfoService.update(updateUser);

        // 更新前/後データをセッションから破棄
        sessionInfo.setPrevUpdateUser(null);
        sessionInfo.setUpdateUser(null);

        request.getRequestDispatcher("updateResult.jsp").forward(request, response);
    }
}