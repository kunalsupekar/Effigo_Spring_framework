package com.in28minutes.learn_spring_framework.game;

public class GameRunner {

	private GamingConsole game;

	public GameRunner(GamingConsole game) {
		this.game = game;
	}
	
	public void runGame() {
		System.out.println("game is running : "+game);
		
		game.goUp();
		game.goDown();
		game.goLeft();
		game.goRight();


	}
	
	

}
