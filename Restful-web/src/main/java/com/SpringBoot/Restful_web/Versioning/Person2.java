package com.SpringBoot.Restful_web.Versioning;


public class Person2 {
  
	private Name name;
	
	public Person2(Name name) {
		this.name=name;
	}
	public Name getName(){
		return this.name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "person v2 [name= "+name+ "]";
	}
	
}
