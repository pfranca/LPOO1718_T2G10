package dkeep.logic;

public class Game {
	
	private GameMap map;
	private Hero hero;
	private Guard guard;
	
	
	public Game(GameMap map) {
		this.map=map;
		this.hero = new Hero(map);
		this.guard = new Guard(map);
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
	
	public void moveGuard() {
		guard.moveGuard();
		map.updateGuard(guard.getPosition().getX(), guard.getPosition().getY());
	}
	
	public CellPosition getHeroPosition() {
		return hero.getPosition();
		
	}
	
	public GameMap getMap(){
		return map;
	}


	public boolean isGameOver() {
		//check for guard
		if(hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()-1||
			hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()+1 ||
			hero.getPosition().getX() == guard.getPosition().getX()-1 && hero.getPosition().getY() == guard.getPosition().getY() ||
			hero.getPosition().getX() == guard.getPosition().getX()+1 && hero.getPosition().getY() == guard.getPosition().getY()){
			return true;
		}
		return false;
	}
}
