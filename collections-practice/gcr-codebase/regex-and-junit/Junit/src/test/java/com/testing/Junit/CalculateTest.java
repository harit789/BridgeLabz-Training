package com.testing.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateTest {
	private Calculator cal = new Calculator();
	
	@Test
	public void addTest() {
		int result = cal.add(4, 4);
		int expected = 8;
		Assertions.assertEquals(expected, result);
	}
	
	@Test
	public void subtractTest() {
		int result = cal.subtract(9, 5);
		int expected = 4;
		Assertions.assertEquals(expected, result);
	}
	
	@Test
	public void multiplyTest() {
		int result = cal.multiply(4, 5);
		int expected = 20;
		Assertions.assertEquals(expected, result);
	}
	
	@Test
	public void divideTest() {
		int result = cal.divide(4, 2);
		int expected = 2;
		Assertions.assertEquals(expected, result);
	}
	
	
}
