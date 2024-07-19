

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String english = request.getParameter("english");
        String result;

        if (english == null || english.isEmpty()) {
            result = "Please enter an English word.";
        } else {
            String japanese = Dictionary.search(english);
            if (japanese != null) {
                result = "English: " + english + ", Japanese: " + japanese;
            } else {
                result = "Not found";
            }
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("dictionary.jsp").forward(request, response);
    }
}

