package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole{

	public void goUp() {
		System.out.println(" super contra Going up");
	}

	public void goDown() {
		System.out.println("super contra Going down");
	}

	public void goLeft() {
		System.out.println("super contra Going left");
	}

	public void goRight() {
		System.out.println(" super contra Going Right");
	}

}
