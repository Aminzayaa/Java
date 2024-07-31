package sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SampleTest {
	@Test
	public void division_by_zero() {
	int result = Sample.dividing(500, 0);
	int expected = 0; // Expected results
	// Compare expected results with processing results
	assertEquals(expected, result);
	}
}