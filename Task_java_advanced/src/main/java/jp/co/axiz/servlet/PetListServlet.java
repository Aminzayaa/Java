package jp.co.axiz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import jp.co.axiz.pet.Animal;
import jp.co.axiz.pet.Pet;
import jp.co.axiz.pet.Reptile;
import jp.co.axiz.util.PetUtil;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/petListServlet")
public class PetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetListServlet() {
		super();
//// Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//// Get the pressed button
		String btn = request.getParameter("btn");

//// Get the pet list from the session
		HttpSession session = request.getSession();
		PetSessionInfo info = (PetSessionInfo) session.getAttribute("info");

// Get pet information corresponding to the pressed button

		Pet selectedPet = info.getPetList().get(btn);

// Set common information to the request scope

		request.setAttribute("name", selectedPet.getName());

		request.setAttribute("age", selectedPet.getAge());

		request.setAttribute("height", selectedPet.getHeight());

		request.setAttribute("weight", selectedPet.getWeight());

		request.setAttribute("optionTitle", PetUtil.getOptionTitleStr(selectedPet));

		request.setAttribute("option", PetUtil.getOptionStr(selectedPet));

// Save selected pet information to the session

		info.setSelectedPet(selectedPet);

		if (PetUtil.isAnimal(selectedPet)) {

// Set animal-specific information to the request scope

			Animal selectedAnimal = (Animal) selectedPet;

			request.setAttribute("isAnimal", true);

			request.setAttribute("type", selectedAnimal.getType());

			request.setAttribute("isFat", selectedAnimal.isFat());

		} else if (PetUtil.isReptile(selectedPet)) {

// Set reptile-specific information to the request scope

			Reptile selectedReptile = (Reptile) selectedPet;

			request.setAttribute("isReptile", true);

			request.setAttribute("isDangerous", selectedReptile.isDangerous());

		}

		request.getRequestDispatcher("/petInfo.jsp").forward(request, response);

	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		doGet(request, response);
	}
}