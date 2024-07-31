package a;

public class Capsule {
	private int num;
	public int getNum() {
	return this.num;
	}
	public void setNum(int num) {
		if ((num < 0) || (100 < num)) {
			throw new IllegalArgumentException();
			}
	this.num = num;
	}

}
