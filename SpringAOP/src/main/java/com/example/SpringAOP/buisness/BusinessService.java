package com.example.SpringAOP.buisness;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringAOP.data.DataService;

@Service
public class BusinessService {
 
	@Autowired
	private DataService dataService;
	
	@TrackTime
	public int calculateMax() {
		int[] data=dataService.reteriveData();
		return Arrays.stream(data).max().orElse(0);
		
	}
}
