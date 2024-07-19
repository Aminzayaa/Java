package jp.co.axiz.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.OtherApp;
import jp.co.axiz.app.GameApp;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAppServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String appType = request.getParameter("appType");

        String result;

        if (name == null || name.isEmpty()) {
            result = "null";
        } else {
            App app = null;
            switch (appType) {
                case "card":
                    app = new CardGameApp(" playing cards");
                    break;
                case "darts":
                    app = new DartsGameApp(" darts");
                    break;
                case "clock":
                    app = new ClockApp();
                    break;
                case "other":
                    app = new OtherApp();
                    break;
                default:
                    app = null;
                    break;
            }

            if (app != null) {
                try {
                    result = app.start(name);
                } catch (Exception ex) {
                    result = "Failed to run the app.";
                }
            } else {
                result = "Failed to run the app.";
            }
        }

        request.setAttribute("result", result);

        request.getRequestDispatcher("appStart.jsp").forward(request, response);
    }
}
