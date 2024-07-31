package java2_10_collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("Alice");
		array.add("Bob");
		array.add("Chris");
		array.add("Michael");
		for (Iterator<String> it = array.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
}