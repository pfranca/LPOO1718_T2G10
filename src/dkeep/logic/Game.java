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
			if(map.getMap()[hero.getPosition().getY()-1][hero.getPosition().getX()] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
			}
				break;
		case "a":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
			}
			break;
		case "s":
			if(map.getMap()[hero.getPosition().getY()+1][hero.getPosition().getX()] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()+1); 
			}
			break;
		case "d":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()+1] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX()+1, hero.getPosition().getY()); 
			}	
			break;
		default:break;
		}
		
	}
	
	public CellPosition getHeroPosition() {
		return hero.getPosition();
		
	}
	
	public GameMap getMap(){
		return map;
	}


	public boolean isGameOver() {
		//check for guard
		if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()+1] == 'G' ||
				map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'G' ||
				map.getMap()[hero.getPosition().getY()+1][hero.getPosition().getX()] == 'G' ||
				map.getMap()[hero.getPosition().getY()-1][hero.getPosition().getX()] == 'G'){
			return true;
		}
		return false;
	}
}
