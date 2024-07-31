package jp.co.axiz.web.servlet.select;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;

/**
 * 検索画面用Servlet
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // 入力値取得
        String userName = request.getParameter("userName");
        String tel = request.getParameter("tel");

        // 検索条件をEntityにセット
        UserInfo cond = new UserInfo(null, null, userName, tel, null, null);

        // 検索処理
        UserInfoService userInfoService = new UserInfoService();
        List<UserInfo> list = userInfoService.find(cond);

        if (list.isEmpty()) {
            // 検索結果が無い場合
            request.setAttribute("errMsg", "入力されたデータはありませんでした");
            request.getRequestDispatcher("select.jsp").forward(request, response);
        } else {
            // 検索結果がある場合
            request.setAttribute("userList", list);
            request.getRequestDispatcher("selectResult.jsp").forward(request, response);
        }
    }
}