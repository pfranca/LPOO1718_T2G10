package dkeep.logic;

import java.util.Random;

public class Game {
	
	private GameMap map;
	private Hero hero;
	private Key lever;
	private Guard guard;
	
	public Guard getGuard() {
		return this.guard;
	}
	
	public Game(GameMap map) {
		this.map=map;
		this.hero = new Hero(map);
		this.lever = new Key(map);
		this.guard = new Guard(map);
		
		Random r = new Random();
		int i = r.nextInt(3);

		switch(i) {
		case 0:
			this.guard.setPersonality("Rookie");
			break;
		case 1:
			this.guard.setPersonality("Drunken");
			break;
		case 2:
			this.guard.setPersonality("Suspicious");
			break;
		default:
			break;
		}
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
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == map.getMap()[lever.getPosition().getY()][lever.getPosition().getX()]) {
				map.getMap()[5][0] = 'S';
				map.getMap()[6][0] = 'S';
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
	
	public void moveGuard(Guard guard) {
		String personality = guard.getPersonality();
		switch(personality) {
		case "Rookie":
			guard.moveRookie();
			break;
		case "Drunken":
			guard.moveDrunken();
			break;
		case "Suspicious":
			guard.moveSuspicious();
			break;
		default:break;
		}
		
		if(!guard.getAsleep()) {
			map.updateGuard(guard.getPosition().getX(), guard.getPosition().getY());
		}
		else {
			map.getMap()[guard.getPosition().getY()][guard.getPosition().getX()] = 'g';
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
		if(!guard.getAsleep()) {
			if(hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()-1||
				hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()+1 ||
				hero.getPosition().getX() == guard.getPosition().getX()-1 && hero.getPosition().getY() == guard.getPosition().getY() ||
				hero.getPosition().getX() == guard.getPosition().getX()+1 && hero.getPosition().getY() == guard.getPosition().getY()){
				System.out.println("GAME OVER!");
				return true;
			}
		}
		
		if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {
			System.out.println("YOU WIN!"); 
			return true;
		}		
		return false;
	}
}
