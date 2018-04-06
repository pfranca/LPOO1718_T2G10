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
	
	char[][] map2 = {{'X','X','X','X','X'},
			{'X','H',' ','O','X'},
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
	public void testMoveHeroIntoWall() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertEquals(new CellPosition(1,1), game.getHeroPosition());
		game.moveHero("w");
		assertEquals(new CellPosition(1,1), game.getHeroPosition());
		
	}
	
	@Test
	public void testHeroIsCapturedByGuard() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("d");
		assertTrue(game.isGameOver());
	}
	
	@Test
	public void testHeroFailsToLeave() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("s");
		game.moveHero("a");
		assertFalse(game.isGameOver());
	}
	
	/*@Test
	public void testHeroStepsIntoLever() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("s");
		game.moveHero("s");
		System.out.println(gameMap.getMap()[2][0]);
		assertEquals('S', gameMap.getMap()[2][0]);
		assertEquals('S', gameMap.getMap()[3][0]);
	}*/

	@Test
	public void testHeroIsCapturedByOgre() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("d");
		assertTrue(game.isGameOver());
	}
	
	@Test
	public void testHeroFailsToOpenDoor() {
		GameMap gameMap = new GameMap(map);
		Game game= new Game(gameMap);
		assertFalse(game.isGameOver());
		game.moveHero("s");
		game.moveHero("a");
		assertFalse(game.isGameOver());
	}

}
