package com.mockito.MockitoDemo.buissens;

public class SomeBuisnessIMpl {

	
    private DataService dataService;
	
	
	
	public SomeBuisnessIMpl(DataService stub) {
		// TODO Auto-generated constructor stub
		super();
		this.dataService = stub;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value > greatestValue)
				greatestValue = value;
		}
		return greatestValue;
	}
	
}

interface DataService{
	int[] retrieveAllData();
}