package com.in28minutes.learn_spring_framework.Exercise;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BuisnessCalculateService {

	Dataservice dataservice;
	
	@Autowired
	public BuisnessCalculateService(Dataservice dataservice) {
		this.dataservice=dataservice;
	}

	public int findMax() {
		int a = Arrays.stream(dataservice.retrieveData()).max().orElse(0);
		return a;
	}
	
	
}
