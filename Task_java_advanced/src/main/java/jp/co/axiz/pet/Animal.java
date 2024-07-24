package jp.co.axiz.pet;

/** * Abstract class representing an animal */
public abstract class Animal implements Pet {
	private String name;
	private int age;
	private int height;
	private int weight;
	private String type;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int _age) {
		age = _age;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int _height) {
		height = _height;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int _weight) {
		weight = _weight;
	}

	/**
	 * Determine if the animal is overweight
	 */
	public abstract boolean isFat();

	/**
	 * Get the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set type
	 */
	public void setType(String _type) {
		type = _type;
	}
}