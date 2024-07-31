package java2_07_exception;

public class TryCatchTest {
	public static void main(String[] args) {
		int[] array = { 0 };
		try {
		System.out.println(1 / array[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("ArrayIndexOutOfBoundsException");
		} catch (RuntimeException e) {
			System.out.println("RuntimeException");
		}
	}
}
