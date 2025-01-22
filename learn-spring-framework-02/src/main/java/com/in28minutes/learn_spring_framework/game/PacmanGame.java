package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame  implements GamingConsole{

	

	public void goUp() {
		System.out.println(" Pacman Going up");
	}

	public void goDown() {
		System.out.println("Pacman Going down");
	}

	public void goLeft() {
		System.out.println("Pacman Going left");
	}

	public void goRight() {
		System.out.println(" Pacman Going Right");
	}

}
