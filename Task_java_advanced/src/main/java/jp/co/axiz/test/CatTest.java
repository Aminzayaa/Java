
package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.pet.Cat;

/**
 * Test case for Cat class
 */
public class CatTest {

	Cat cat = new Cat("Tama", 3, 76, 4, "American Shorthair", "Cat Toy");

	@Test
	public void nameTest() {
		String result = cat.getName();
		String expected = "Tama";

		assertEquals(expected, result);

	}

	@Test
	public void ageTest() {
		int result = cat.getAge();
		int expected = 3;

		assertEquals(expected, result);

	}

	@Test
	public void heightTest() {
		int result = (int) cat.getHeight();

		int expected = (int) 76;

		assertEquals(expected, result);

	}

	@Test
	public void weightTest() {

		int result = (int) cat.getWeight();

		int expected = (int) 4;

		assertEquals(expected, result);

	}

	@Test
	public void typeTest() {

		String result = cat.getType();

		String expected = "American Shorthair";

		assertEquals(expected, result);

	}

	@Test
	public void favoriteItemTest() {

		String result = cat.getFavoriteItem();

		String expected = "Cat teaser";

		assertEquals(expected, result);

	}

	@Test
	public void isFatTest1() {

		Cat cat1 = new Cat("Tama", 3, 76, 5, "American Shorthair", "Cat teaser");

		boolean result = cat1.isFat();
		boolean expected = false;
		assertEquals(expected, result);
	}

	@Test
	public void isFatTest2() {
		Cat cat2 = new Cat("Tama", 3, 76, 6, "American Shorthair", "Cat Toy");
		boolean result = cat2.isFat();
		boolean expected = true;
		assertEquals(expected, result);
	}
}