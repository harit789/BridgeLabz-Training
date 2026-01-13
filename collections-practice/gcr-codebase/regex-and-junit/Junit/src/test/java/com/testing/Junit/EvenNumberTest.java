package com.testing.Junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class EvenNumberTest {
	EvenNumber num = new EvenNumber();
	

	@ParameterizedTest
	@ValueSource(ints = {2,4,6,7,9})
	public void isEvenCheck(int n) {
		Assertions.assertTrue(num.isEven(n));
	}
}
