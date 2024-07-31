package java2_07_exception;

public class TryCatchFinallyTest {
	public static void main(String[] args) {
		int[] myarray = new int[3]; // array of length 3
		System.out.println("substitute");
		try {
			myarray[100] = 0;// Enter the value in box number 100 (box not prepared)
			myarray[1] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException");
		} finally {
			System.out.println("--End of exception handling--");
		}
		System.out.println("I substituted");
		}
}
