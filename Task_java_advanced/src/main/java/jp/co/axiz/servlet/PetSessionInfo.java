package jp.co.axiz.servlet;

import java.util.HashMap;
import jp.co.axiz.pet.Cat;
import jp.co.axiz.pet.Dog;
import jp.co.axiz.pet.Lizard;
import jp.co.axiz.pet.Pet;

/**
 * Class for storing a list of pet information in a HashMap
 */
public class PetSessionInfo {
	private HashMap<String, Pet> petList;
	private Pet selectedPet;

	public PetSessionInfo() {
		petList = new HashMap<String, Pet>();
		Dog dog = new Dog("Pochi", 5, 55, 20, "Shiba Inu", "Yoyogi Park");
		Cat cat = new Cat("Tama", 3, 40, 4, "American Shorthair", "Cat Toy");
		Lizard lizard = new Lizard("Taro", 36, 25, 1);
		petList.put("dog", dog);
		petList.put("cat", cat);
		petList.put("lizard", lizard);
	}

	/**
	 * List of pet information
	 */
	public void setPetList(HashMap<String, Pet> _petList) {
		petList = _petList;
	}

	/**
	 * List of pet information settings
	 */
	public HashMap<String, Pet> getPetList() {
		return petList;
	}

	/**
	 * Selected pet
	 */
	public void setSelectedPet(Pet _selectedPet) {
		selectedPet = _selectedPet;
	}

	/**
	 * Selected pet settings
	 */
	public Pet getSelectedPet() {
		return selectedPet;
	}
}