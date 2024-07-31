package sample;

public class Sample {
	public static int dividing(int i, int j) {
		int result = 0;
		try {
			result = i / j;
		} catch (ArithmeticException e) {
		}
		return result;
	}
}