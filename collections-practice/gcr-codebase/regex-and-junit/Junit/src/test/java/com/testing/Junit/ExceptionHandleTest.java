package com.testing.Junit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExceptionHandleTest {
	private ExceptionHandle div  = new ExceptionHandle();
	@Test
	public void divideTest() {
		int result = div.divide(4, 6);
		int expected = 0;
		Assertions.assertEquals(expected, result);
	}
	
	@Test
	public void divideByZero() {
		Assertions.assertThrows(ArithmeticException.class,()-> div.divide(5, 0));
	}
}
