package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MarioQualifier")
public class MarioGame implements GamingConsole {

	public void goUp() {
		System.out.println("Going up");
	}

	public void goDown() {
		System.out.println("Going down");
	}

	public void goLeft() {
		System.out.println("Going left");
	}

	public void goRight() {
		System.out.println("Going Right");
	}
}
