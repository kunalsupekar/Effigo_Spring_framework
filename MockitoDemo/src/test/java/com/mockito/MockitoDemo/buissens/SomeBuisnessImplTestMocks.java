package com.mockito.MockitoDemo.buissens;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBuisnessImplTestMocks {

	@Mock
	private DataService  dataServiceMock;
	
	@InjectMocks
	private SomeBuisnessIMpl 	 buisnessIMpl;
	
	@Test
	void test() {
		//DataService dataServiceMock=mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,22,33,44,55,121});
	//	SomeBuisnessIMpl buisnessIMpl=new SomeBuisnessIMpl(dataServiceMock);
	assertEquals(121,buisnessIMpl.findTheGreatestFromAllData());
	}
	
	@Test
	void singlevalue() {
		DataService dataServiceMock=mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {121});
		SomeBuisnessIMpl buisnessIMpl=new SomeBuisnessIMpl(dataServiceMock);
	assertEquals(121,buisnessIMpl.findTheGreatestFromAllData());
	}
	
	


}
