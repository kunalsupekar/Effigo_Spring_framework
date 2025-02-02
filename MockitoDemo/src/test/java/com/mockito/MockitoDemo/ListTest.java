package com.mockito.MockitoDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	void simpleTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3);
		assertEquals(3, mockList.size());

	}
	

	@Test
	void multipleReturn() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3).thenReturn(1);
		assertEquals(3, mockList.size());
		assertEquals(1, mockList.size());
		assertEquals(1, mockList.size());
	}
	
	
	@Test
	void parameters() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn("kunal");
		assertEquals("kunal", mockList.get(0));
		assertEquals(null, mockList.get(2));
	}
	
	@Test
	void genericParameters() {
		List mockList = mock(List.class);
		when(mockList.get(Mockito.anyInt())).thenReturn("kunal");
		assertEquals("kunal", mockList.get(0));
		//assertEquals(null, mockList.get(2));
	}
}
