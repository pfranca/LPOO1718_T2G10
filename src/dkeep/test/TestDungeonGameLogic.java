package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;


import dkeep.logic.CellPosition;
import dkeep.logic.Game;
import dkeep.logic.GameMap;

public class TestDungeonGameLogic {
	
	char[][] map = {{'X','X','X','X','X'},
			{'X','H',' ','G','X'},
			{'I',' ',' ',' ','X'},
			{'I','k',' ',' ','X'},
			{'X','X','X','X','X'}};
	

	@Test
	public void testMoveHeroIntoToFreeCell() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertEquals(new CellPosition(1,1), game.getHeroPosition());
		game.moveHero("s");
		assertEquals(new CellPosition(1,2), game.getHeroPosition());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("d");
		assertTrue(game.isGameOver());
	}

}
