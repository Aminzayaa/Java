package jp.co.axiz.web.servlet.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.servlet.SessionInfo;
import jp.co.axiz.web.util.ParamUtil;

/**
 * 削除画面用Servlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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

        // セッション情報取得
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(request.getSession());
        UserInfo loginUser = sessionInfo.getLoginUser();

        // 入力値チェック
        boolean hasError = false;

        if (ParamUtil.isNullOrEmpty(loginId)) {
            // ID未入力の場合
            request.setAttribute("idErrMsg", "IDは必須です");
            hasError = true;
        } else if (loginId.equals(loginUser.getLoginId())) {
            request.setAttribute("errMsg", "ログインユーザは削除できません");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("delete.jsp").forward(request, response);
            return;
        }

        // ユーザ情報取得
        UserInfoService userInfoService = new UserInfoService();
        UserInfo userInfo = userInfoService.findByLoginId(loginId);

        if (userInfo == null) {
            // 該当するデータが存在しない場合
            request.setAttribute("errMsg", "入力されたデータは存在しません");
            request.getRequestDispatcher("delete.jsp").forward(request, response);
            return;
        }

        request.setAttribute("deleteUser", userInfo);
        request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
    }
}