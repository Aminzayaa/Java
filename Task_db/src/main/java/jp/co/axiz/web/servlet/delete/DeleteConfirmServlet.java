package jp.co.axiz.web.servlet.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.util.ParamUtil;
@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteConfirmServlet() {
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
        String userId = request.getParameter("userId");

        // 削除処理
        UserInfoService userInfoService = new UserInfoService();
        userInfoService.delete(ParamUtil.checkAndParseInt(userId));

        request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
    }
}