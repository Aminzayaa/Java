package jp.co.axiz.pet;

/**
 * Class representing a cat
 */
public class Cat extends Animal {

	private String favoriteItem;

	public Cat() {

	}

	public Cat(String _name, int _age, int _height, int _weight, String _type, String _walkingPlace) {
		setName(_name);
		setAge(_age);
		setHeight(_height);
		setWeight(_weight);
		setType(_type);
		setFavoriteItem(_walkingPlace);
	}

	/**
	 * Get favorite playground equipment
	 */
	public String getFavoriteItem() {
		return favoriteItem;
	}

	/**
	 * Set favorite playground equipment
	 */
	public void setFavoriteItem(String _favoriteItem) {
		favoriteItem = _favoriteItem;
	}

	@Override
	public boolean isFat() {
		if (getWeight() > 5) {
			return true;
		}
		return false;
	}
}