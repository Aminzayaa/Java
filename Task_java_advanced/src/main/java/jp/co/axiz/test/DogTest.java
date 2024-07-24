package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.pet.Dog;

/**
 * Test case for Dog class
 */
public class DogTest {

	Dog dog = new Dog("Pochi", 5, 100, 20, "Shiba Inu", "Yoyogi Park");

	@Test
	public void nameTest() {
		String result = dog.getName();
		String expected = "Pochi";

		assertEquals(expected, result);

	}

	@Test
	public void ageTest() {
		int result = dog.getAge();
		int expected = 5;

		assertEquals(expected, result);

	}

	@Test
	public void heightTest() {
		int result = (int) dog.getHeight();
		int expected = (int) 100;
		assertEquals(expected, result);
	}

	@Test
	public void weightTest() {
		int result = (int) dog.getWeight();
		int expected = (int) 20;
		assertEquals(expected, result);
	}

	@Test
	public void typeTest() {
		String result = dog.getType();
		String expected = "Shiba Inu";
		assertEquals(expected, result);
	}

	@Test
	public void walkingPlaceTest() {
		String result = dog.getWalkingPlace();
		String expected = "Yoyogi Park";
		assertEquals(expected, result);
	}

	@Test
	public void isFatTest1() {
		Dog dog1 = new Dog("Pochi", 5, 100, 15, "Shiba Inu", "Yoyogi Park");

		boolean result = dog1.isFat();
		boolean expected = false;

		assertEquals(expected, result);
	}

	@Test
	public void isFatTest2() {
		Dog dog2 = new Dog("Pochi", 5, 100, 16, "Shiba Inu", "Yoyogi Park");

		boolean result = dog2.isFat();
		boolean expected = true;

		assertEquals(expected, result);
	}
}