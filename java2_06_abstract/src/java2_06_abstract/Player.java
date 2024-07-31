package java2_06_abstract;

public abstract class Player { // abstract class
	public abstract void play(); // abstract method
		public void repeat(int n) {
			for (int i = 0; i < n; i++) {
				play();
		}
	}
}