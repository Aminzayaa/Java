package jp.co.axiz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jp.co.axiz.entity.Product;
import jp.co.axiz.service.ProductService;
import jp.co.axiz.util.ParamUtil;

@SuppressWarnings("serial")
@WebServlet({ "/ProductServlet" })
public class ProductServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        Integer productId = ParamUtil.checkAndParseInt(request.getParameter("productId"));

        if (productId == null) {
            request.setAttribute("msg", "product_idを入力してください");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
            return;
        }
        ProductService ps = new ProductService();

        Product product = ps.findByProductId(productId);

        if (product == null) {
            request.setAttribute("msg", "対象のデータはありません");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        } else {
            request.setAttribute("product", product);
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
        }

    }
}