package com.testing.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ListOperationTest {
	private ListOperations list = new ListOperations();
	
	@Test
	public void addElementTest() {
		List<Integer> temp = new ArrayList<>();
		list.addElement(temp, 10);
		Assertions.assertTrue(temp.contains(10));
	}
	
	@Test
	public void removeElementTest() {
		List<Integer> temp = new ArrayList<>();
		temp.add(10);
		list.removeElement(temp, 10);
		boolean remove = temp.contains(10);
		Assertions.assertFalse(remove);
	}
	
	@Test
	public void getSizeTest() {
		List<Integer> temp = Arrays.asList(12,2,3);
		Assertions.assertEquals(temp.size(), list.getSize(temp));
		
	}
}
