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
@WebServlet("/petInfoServlet")
public class PetInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetInfoServlet() {
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
        request.setCharacterEncoding("UTF-8");

        // 入力値を取得
        String nameStr = request.getParameter("name");
        String weightStr = request.getParameter("weight");

        // セッションからペット一覧を取得
        HttpSession session = request.getSession();
        PetSessionInfo info = (PetSessionInfo) session.getAttribute("info");

        // 選択中のペット情報を取得
        Pet selectedPet = info.getSelectedPet();

        if (!PetUtil.isNullOrEmpty(nameStr)) {
            selectedPet.setName(nameStr);
        }

        if (PetUtil.isAnimal(selectedPet)) {
            Integer weight = PetUtil.checkAndParseInt(weightStr);

            if (weight != null) {
                selectedPet.setWeight(weight);
            }
        }

        // 完了メッセージ
        request.setAttribute("infoUpdatedMsg", "Pet information has been changed");

        // 次ページのボタン表示用に、ペットの名前をリクエストスコープに保存
        HashMap<String, Pet> petList = info.getPetList();
        session.setAttribute("dogName", petList.get("dog").getName());
        session.setAttribute("catName", petList.get("cat").getName());
        session.setAttribute("lizardName", petList.get("lizard").getName());

        request.getRequestDispatcher("/petList.jsp").forward(request, response);
    }
}