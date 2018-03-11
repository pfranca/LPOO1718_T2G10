package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.*;

public class UserInterface {
	
	static char level1[][] = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X','H',' ',' ','I',' ','X',' ',' ','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'X',' ','I',' ','I',' ','X',' ',' ','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X',' ','X','X','X','X',' ','X'},
            {'X',' ','I',' ','I',' ','X','k',' ','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
	
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        Game game= new Game(new GameMap(level1));
        
        while(!game.isGameOver()){
        	game.getMap().printMap();
            String input = in.nextLine();
            game.moveHero(input);
            //printLevel();
        }
    }

	private static void updateGame(String input) {
		
	/*	switch(input) {
		case "w":game.moveHero('w'); break;
		case "a":break;
		case "s":break;
		case "d":break;
		default:break;
		}*/
		
	}

}
