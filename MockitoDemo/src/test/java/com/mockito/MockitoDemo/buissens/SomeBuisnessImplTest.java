package com.mockito.MockitoDemo.buissens;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBuisnessImplTest {

	@Test
	void test() {
		DataService stub=new DataServiceStub2();
		SomeBuisnessIMpl buisnessIMpl=new SomeBuisnessIMpl(stub);
	int result=	buisnessIMpl.findTheGreatestFromAllData();
	assertEquals(result,56);
	}
	
	@Test
	void findTheGreatestFromAllData_withOneValue() {
		DataService stub=new DataServiceStub1();
		SomeBuisnessIMpl buisnessIMpl=new SomeBuisnessIMpl(stub);
	int result=	buisnessIMpl.findTheGreatestFromAllData();
	assertEquals(result,1);
	}


}

class DataServiceStub1 implements DataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1};
	}
	
}

class DataServiceStub2 implements DataService{

	@Override
	public int[] retrieveAllData() {
	
		return new int[] {1,2,3,4,56,6,1};
	}
	
}
