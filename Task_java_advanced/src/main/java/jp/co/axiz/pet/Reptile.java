package jp.co.axiz.pet;

/** * Abstract class representing a reptile */
public abstract class Reptile implements Pet {
	private String name;
	private int age;
	private int height;
	private int weight;

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
	 * Determine if the reptile is dangerous
	 */
	public abstract boolean isDangerous();
}