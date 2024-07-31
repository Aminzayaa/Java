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

        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // 入力値取得
        String productName = request.getParameter("productName");
        Integer price = ParamUtil.checkAndParseInt(request.getParameter("price"));

        // 押下されたボタンに応じて処理を分岐するため
        String command = request.getParameter("command");

        // サービスをインスタンス化
        ProductService ps = new ProductService();

        switch (command) {
        case "select":

            // 検索対象のデータを用意
            Product pdSelect = new Product(null, productName, price);

            // データを取得
            List<Product> productList = ps.find(pdSelect);

            if (productList.isEmpty()) {
                // データがない場合
                request.setAttribute("msg", "対象のデータはありません");
                request.getRequestDispatcher("/top.jsp").forward(request, response);

                return;
            } else {
                // データがある場合
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/searchResult.jsp").forward(request, response);

                return;
            }

        case "insert":
            // 未入力項目かあるかの判定用
            boolean isErr = false;

            // product_name未入力時
            if (ParamUtil.isNullOrEmpty(productName)) {
                request.setAttribute("nameErrMsg", "product_nameは必須です");
                isErr = true;
            }

            // price未入力時
            if (price == null) {
                request.setAttribute("priceErrMsg", "priceは必須です");
                isErr = true;
            }

            // 未入力項目がある場合
            if(isErr) {
                request.getRequestDispatcher("/top.jsp").forward(request, response);
                return;
            }

            // 登録するデータを用意
            Product pdInsert = new Product(null, productName, price);

            // 登録
            ps.insert(pdInsert);

            // 結果画面へ
            request.getRequestDispatcher("/insertResult.jsp").forward(request, response);

            return;
        }
    }
}