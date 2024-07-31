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


@WebServlet("/insertConfirm")
public class InsertConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmServlet() {
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

        // 登録用データを取得
        UserInfo userInfo = sessionInfo.getRegisterUser();

        if (!userInfo.getPassword().equals(rePass)) {
            // 再入力パスワードが一致しない場合
            request.setAttribute("errMsg", "前画面で入力したパスワードと一致しません");
            request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
            return;
        }

        // 登録処理
        UserInfoService userInfoService = new UserInfoService();
        userInfoService.insert(userInfo);

        // 登録用データをセッションから破棄
        sessionInfo.setRegisterUser(null);

        request.getRequestDispatcher("insertResult.jsp").forward(request, response);
    }
}