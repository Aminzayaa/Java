package java2_10_collection;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "200");
		map.put("orange", "100");
		map.put("peach", "300");
		String s = "apple";
		if (map.containsKey(s)) {
		System.out.println("apple price : " + map.get(s));
		} else {
		System.out.println("The specified key does not exist");
		}
	}

}
