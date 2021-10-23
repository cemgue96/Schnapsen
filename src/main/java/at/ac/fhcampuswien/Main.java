package at.ac.fhcampuswien;

import at.ac.fhcampuswien.core.Game;

public class Main {

    public static void main(String[] args) {
	    //System.out.println("♠️♣️♥️♦️ Hello World! - let's play a game");

        //Print information about how game works like
        //Game.printplayInstructions();

        //Start a new game based on player input - for now start with new game automatically
        Game game = new Game();
        game.run();

    }
}
