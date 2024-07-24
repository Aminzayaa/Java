package jp.co.axiz.pet;

/** * Class representing lizard */
public class Lizard extends Reptile {
	public Lizard() {
	}

	public Lizard(String _name, int _age, int _height, int _weight) {
		setName(_name);
		setAge(_age);
		setHeight(_height);
		setWeight(_weight);
	}

	@Override
	public boolean isDangerous() {
		return true;
	}
}