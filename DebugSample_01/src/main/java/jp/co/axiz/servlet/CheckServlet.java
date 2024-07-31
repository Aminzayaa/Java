package jp.co.axiz.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/check")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// 入力値の取得
	    String id = request.getParameter("id");
	    String password = request.getParameter("paassword");

	    // パスワードのチェック
	    boolean canLogin = Utility.authentication(password);

	    // 表示メッセージの受け渡し
	    if (canLogin) {

	    	// パスワードが正しい場合（入力値が"axizuser"であった場合、"ok"をリクエストスコープへセット）
			request.setAttribute("passwordMatch", "ok");

	    } else {

	    	// パスワードが正しくない場合（入力値が"axizuser"でなかった場合、"ng"をリクエストスコープへセット）
			request.setAttribute("passwordMatch", "ng");

	    }

	    // リクエストスコープへセット
	    request.setAttribute("id", id);

	    request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
