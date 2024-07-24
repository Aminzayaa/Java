package jp.co.axiz.servlet;

import java.util.HashMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import jp.co.axiz.pet.Pet;
import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/startServlet")
public class StartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // パスワードボックスの入力値を取得
        request.setCharacterEncoding("UTF-8");
        String pass = request.getParameter("pass");

        // 認証チェック結果を表すフラグ
        boolean isLoginSuccess = false;

        // 認証チェックNGだった時のエラーメッセージ
        String errorMsg = "";

        Integer passNum = PetUtil.checkAndParseInt(pass);

        if (passNum != null) {
            // 数値に変換できた場合

            if (passNum == 1234) {
                // 値が正しい場合
                isLoginSuccess = true;
            } else {
                // 値が異なる場合
                errorMsg = "*The PIN number is incorrect.";
            }
        } else {
            // 数値に変換できなかった場合
            errorMsg = "*Please enter numbers for your PIN.";
        }

        if (!isLoginSuccess) {
            // ログイン失敗時は、元の画面に戻る
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        // ペット一覧をセッションに保存
        HttpSession session = request.getSession();

        PetSessionInfo info = new PetSessionInfo();
        session.setAttribute("info", info);

        // 次ページのボタン表示用に、ペットの名前をリクエストスコープに保存
        HashMap<String, Pet> petList = info.getPetList();
        session.setAttribute("dogName", petList.get("dog").getName());
        session.setAttribute("catName", petList.get("cat").getName());
        session.setAttribute("lizardName", petList.get("lizard").getName());

        request.getRequestDispatcher("/petList.jsp").forward(request, response);
    }

}