package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entity.User;
import service.UserService;
import util.ParamUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// ログインID、パスワードを取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// 入力値のチェック
		if (ParamUtil.isNullOrEmpty(id) || ParamUtil.isNullOrEmpty(pass)) {
			// メッセージ設定
			request.setAttribute("msg", "ログインできませんでした。");

			// 次画面指定
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		// ログインチェック
		UserService userService = new UserService();
		User user = userService.authentication(id, pass);

		// 表示メッセージの受け渡し
		if (user != null) {
			List<User> list = userService.find();
			request.setAttribute("userList", list);

			// 次画面指定
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} else {
			// メッセージ設定
			request.setAttribute("msg", "ログインできませんでした。");

			// 次画面指定
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}