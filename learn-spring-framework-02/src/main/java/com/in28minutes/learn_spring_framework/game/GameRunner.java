package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GamingConsole game;

	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
		this.game = game;
	}
	
//	public GameRunner( GamingConsole game) {
//		this.game = game;
//	}

	public void runGame() {
		System.out.println("game is running : " + game);

		game.goUp();
		game.goDown();
		game.goLeft();
		game.goRight();

	}

}
