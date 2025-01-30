package com.example.SpringAOP.data;

import org.springframework.stereotype.Component;

@Component
public class DataService {
  
	public int[] reteriveData() {
		return new 	int[] {1,2,3,4,1,99,3,2,32,11,2};
	}
}
