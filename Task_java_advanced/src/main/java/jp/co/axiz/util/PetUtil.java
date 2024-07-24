package jp.co.axiz.util;

import jp.co.axiz.pet.Animal;
import jp.co.axiz.pet.Cat;
import jp.co.axiz.pet.Dog;
import jp.co.axiz.pet.Pet;
import jp.co.axiz.pet.Reptile;

/**
 * Class that compiles utility methods
 */
public class PetUtil {

	/**
	 * Determines whether the string specified in the argument is null or an empty
	 * string
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines whether the string specified in the argument can be converted to a
	 * number
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException ex) {
			return false;
		}

		return true;
	}

	/**
	 * Converts the string specified in the argument to a number and returns it.
	 * Returns null if conversion is not possible.
	 */
	public static Integer checkAndParseInt(String str) {
		if (isNumber(str)) {
			return Integer.parseInt(str);
		} else {
			return null;
		}
	}

	/**
	 * Get the title of the last item in petInfo.jsp
	 * 
	 * @param str
	 * @return
	 */
	public static String getOptionTitleStr(Pet pet) {
		if (isDog(pet)) {
			return "Walking place";
		} else if (isCat(pet)) {
			return "Favorite playground";
		} else {
			return "-";
		}
	}

	/**
	 * Get the value of the last item in petInfo.jsp
	 * 
	 * @param str
	 * @return
	 */
	public static String getOptionStr(Pet pet) {
		if (isDog(pet)) {
			return ((Dog) pet).getWalkingPlace();
		} else if (isCat(pet)) {
			return ((Cat) pet).getFavoriteItem();
		} else {
			return "-";
		}
	}

	/**
	 * Determine if the type of the object received as an argument is Dog.
	 * 
	 * @param pet
	 * @return
	 */
	public static boolean isDog(Pet pet) {
		if (pet instanceof Dog) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determine if the type of the object received as an argument is Cat.
	 * 
	 * @param pet
	 * @return
	 */
	public static boolean isCat(Pet pet) {
		if (pet instanceof Cat) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determine if the type of the object received as an argument is Animal.
	 * 
	 * @param pet
	 * @return
	 */
	public static boolean isAnimal(Pet pet) {
		if (pet instanceof Animal) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines whether the object type received as an argument is Reptile.
	 * 
	 * @param pet
	 * @return
	 */
	public static boolean isReptile(Pet pet) {
		if (pet instanceof Reptile) {
			return true;
		} else {
			return false;
		}
	}
}