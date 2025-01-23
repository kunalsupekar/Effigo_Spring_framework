package com.in28minutes.learn_spring_framework.Exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDbDataService implements Dataservice{

	@Override
	public int[] retrieveData() {
		
		return new int[] {1,2,3,4,5,6};
	}

}
