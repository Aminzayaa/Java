package java2_07_exception;

public class ThrowTest {
	public static void main(String[] args) {
		try {
			throwEx();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("will end");
		}
		public static void throwEx() throws Exception {
			throw new Exception();
		}
}
