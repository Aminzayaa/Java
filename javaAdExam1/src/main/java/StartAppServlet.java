

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import app.GameApp;

/**
 * Servlet implementation class StartAppServlet
 */
public class StartAppServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartAppServlet() {
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
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name"); // утгыг авч хувьсагчид оноодог
        String result = "Not executed"; // ямар ч үйлдэл хийгээгүй болон амжилтгүй үед гарна

        if (name != null && !name.isEmpty()) { // нөхцлийг шалгаж бна
            GameApp gameApp = new GameApp(); // GameApp Object үүсгэж бна
            gameApp.setItem("something"); 
            result = gameApp.start(name);
        }
        
        request.setAttribute("result", result);
        request.getRequestDispatcher("/appStart.jsp").forward(request, response);
    }

}