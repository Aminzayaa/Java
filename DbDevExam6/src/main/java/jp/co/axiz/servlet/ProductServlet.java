package jp.co.axiz.servlet;


import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jp.co.axiz.entity.Product;
import jp.co.axiz.service.ProductService;
import jp.co.axiz.util.ParamUtil;

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

        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // 入力値取得
        String productName = request.getParameter("productName");
        Integer price = ParamUtil.checkAndParseInt(request.getParameter("price"));

        // サービスインスタンス化
        ProductService ps = new ProductService();

        // 検索対象のデータを用意
        Product pdSelect = new Product(null, productName, price);

        // データを取得
        List<Product> productList = ps.find(pdSelect);

        if (productList.isEmpty()) {
            // データがない場合
            request.setAttribute("msg", "対象のデータはありません");
            request.getRequestDispatcher("/top.jsp").forward(request, response);
        } else {
            // データがある場合
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
        }

    }
}