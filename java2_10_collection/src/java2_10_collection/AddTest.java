package java2_10_collection;

import java.util.ArrayList;

public class AddTest {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(10);
		array.add(20);
		array.add(30);
		for (int num : array) {
			System.out.println(num);
		}
	}
}
