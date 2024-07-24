package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import jp.co.axiz.pet.Lizard;

/** * Lizard Class test case */
public class LizardTest {
	Lizard lizard = new Lizard("Taro", 36, 25, 1);

	@Test
	public void nameTest() {
		String result = lizard.getName();
		String expected = "Taro";
		assertEquals(expected, result);
	}

	@Test
	public void ageTest() {
		int result = lizard.getAge();
		int expected = 36;
		assertEquals(expected, result);
	}

	@Test
	public void heightTest() {
		int result = (int) lizard.getHeight();
		int expected = (int) 25;
		assertEquals(expected, result);
	}

	@Test
	public void weightTest() {
		int result = (int) lizard.getWeight();
		int expected = (int) 1;
		assertEquals(expected, result);
	}

	@Test
	public void isDangerousTest1() {
		boolean result = lizard.isDangerous();
		boolean expected = true;
		assertEquals(expected, result);
	}
}