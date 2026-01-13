package com.testing.Junit;

public class ExceptionHandle {
	public int divide(int a , int b) {
		if(b == 0) {
			throw new ArithmeticException("Dividing by zero");
		}
		return a/b;
	}
}
