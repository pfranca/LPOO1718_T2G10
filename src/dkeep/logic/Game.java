package dkeep.logic;

public class Game {
	
	private GameMap map;
	private Hero hero;
	
	
	public Game(GameMap map) {
		this.map=map;
		this.hero = new Hero(map);
	}

	public void moveHero(String input) {
		switch(input) {
		case "w":
			if(map.getMap()[hero.getPosition().getY()-1][hero.getPosition().getX()] != 'X') {
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
				//update map
			}
				break;
		case "a":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] != 'X') {
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
				//update map
			}
			break;
		case "s":
			if(map.getMap()[hero.getPosition().getY()+1][hero.getPosition().getX()] != 'X') {
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()+1); 
				//update map
			}
			break;
		case "d":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()+1] != 'X') {
				hero.setPosition(hero.getPosition().getX()+1, hero.getPosition().getY()); 
				//update map
			}	
			break;
		default:break;
		}
		
	}
	
	public CellPosition getHeroPosition() {
		return hero.getPosition();
		
	}
	
}
