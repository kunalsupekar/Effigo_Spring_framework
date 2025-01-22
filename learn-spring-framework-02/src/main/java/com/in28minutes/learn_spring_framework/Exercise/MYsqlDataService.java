package com.in28minutes.learn_spring_framework.Exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class MYsqlDataService implements Dataservice {

	@Override
	public int[] retrieveData() {
		
		return new int[] {11,22,33,44,55,66,77,88,99};
	}

}
