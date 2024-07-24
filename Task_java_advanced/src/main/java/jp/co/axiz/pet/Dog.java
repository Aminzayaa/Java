package jp.co.axiz.pet;

/**
 * Class representing a dog
 */
public class Dog extends Animal {

	private String walkingPlace;

	public Dog() {

	}

	public Dog(String _name, int _age, int _height, int _weight, String _type, String _walkingPlace) {
		setName(_name);
		setAge(_age);
		setHeight(_height);
		setWeight(_weight);
		setType(_type);
		setWalkingPlace(_walkingPlace);
	}

	/**
	 * Get walking location
	 */
	public String getWalkingPlace() {
		return walkingPlace;
	}

	/**
	 * Set walking location
	 */
	public void setWalkingPlace(String _walkingPlace) {
		walkingPlace = _walkingPlace;
	}

	@Override
	public boolean isFat() {
		if (getWeight() > 15) {
			return true;
		}
		return false;
	}
}