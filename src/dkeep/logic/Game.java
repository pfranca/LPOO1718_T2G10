package dkeep.logic;

import java.util.Random;

public class Game {
	
	static char level2[][] = {
            {'X','X','X','X','X','X','X','X','X'},
            {'I',' ',' ',' ','O',' ',' ','k','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','H',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X','X','X','X','X','X','X'}};

	private GameMap map;
	private Hero hero;
	private Key lever;
	private Guard guard;
	private Ogre ogre;
	
	public Guard getGuard() {
		return this.guard;
	}
	
	public Ogre getOgre() {
		return this.ogre;
	}
	
	public Game(GameMap map) {
		this.map=map;
		this.hero = new Hero(map);
		this.lever = new Key(map);
		this.guard = new Guard(map);
		this.ogre = new Ogre(map);
		
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
	
	public void updateGame(String input, Guard guard, Ogre ogre) {		
		if(this.guard!=null) {
			moveGuard(guard);
			moveHero(input);
		}else {
			/*if(this.ogre!=null)
				moveOgre(ogre);*/
			moveHero(input);
		}
		
	}

	public void moveHero(String input) {
		switch(input) {
		case "w":
			if(map.getMap()[hero.getPosition().getY()-1][hero.getPosition().getX()] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
			}
			if(guard==null && hero.getPosition().getY()-1 == lever.getPosition().getY() &&
					hero.getPosition().getX() == lever.getPosition().getX()) {
					
					map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
					hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
					//map.getMap()[lever.getPosition().getY()][lever.getPosition().getX()]='k';
					map.getMap()[1][0] = 'S';
						
			}
			break;
		case "a":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == ' ') {
				
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
			}
			if(guard!=null && hero.getPosition().getY() == lever.getPosition().getY() &&
				hero.getPosition().getX()-1 == lever.getPosition().getX()) {
				
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
				//map.getMap()[lever.getPosition().getY()][lever.getPosition().getX()]='k';
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
			if(guard==null && hero.getPosition().getY() == lever.getPosition().getY() &&
					hero.getPosition().getX()+1 == lever.getPosition().getX()) {
					
					map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input);
					hero.setPosition(hero.getPosition().getX()+1, hero.getPosition().getY()); 
					//map.getMap()[lever.getPosition().getY()][lever.getPosition().getX()]='k';
					map.getMap()[1][0] = 'S';
						
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
	
	public void moveOgre(Ogre ogre) {
		
		while (ogre!=null) {

			Random random = new Random();

			int r = random.nextInt(4);

			if (r == 0) {
				if(map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()+1] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"right");
					ogre.setPosition(ogre.getPosition().getX()+1, ogre.getPosition().getY()); 
				}
				
			}
				
			if (r == 1) {
				if(map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()-1] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"left");
					ogre.setPosition(ogre.getPosition().getX()-1, ogre.getPosition().getY()); 
				}
			}
				
			if (r == 2) {
				if(map.getMap()[ogre.getPosition().getY()+1][ogre.getPosition().getX()] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"down");
					ogre.setPosition(ogre.getPosition().getX(), ogre.getPosition().getY()+1); 
				}
			}
				
			if (r == 3) {
				if(map.getMap()[ogre.getPosition().getY()-1][ogre.getPosition().getX()] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"up");
					ogre.setPosition(ogre.getPosition().getX(), ogre.getPosition().getY()-1); 
				}
			}

		}
	}
	
	public void ogreClub(Ogre ogre) {

		while (ogre!=null) {

			int x = ogre.getPosition().getX();
			int y = ogre.getPosition().getY();

			Random random = new Random();

			int r = random.nextInt(4);

			if (r == 0)
				x += 1;
			if (r == 1)
				x -= 1;
			if (r == 2)
				y += 1;
			if (r == 3)
				y -= 1;

			if (map.getMap()[y][x] == ' ') {
				ogre.setClub(x, y);
				break;
			}
		}

	}
	
	public CellPosition getHeroPosition() {
		return hero.getPosition();
		
	}
	
	public GameMap getMap(){
		return map;
	}
	
	public void setMap(GameMap map){
		this.map=map;
	}

	public boolean isGameOver() {
		//check for guard
		if(guard!=null && !guard.getAsleep()) {
			if(hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()-1||
				hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()+1 ||
				hero.getPosition().getX() == guard.getPosition().getX()-1 && hero.getPosition().getY() == guard.getPosition().getY() ||
				hero.getPosition().getX() == guard.getPosition().getX()+1 && hero.getPosition().getY() == guard.getPosition().getY()){
				System.out.println("GAME OVER!");
				return true;
			}
		}

		if(guard!=null && map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {
			this.guard = null;
			setMap(new GameMap(level2));
			this.ogre = new Ogre(map);
			this.hero.setPosition(1, 7);
			this.lever.setPosition(7, 1);
			this.guard = null;
			this.ogre.setPosition(ogre.getPosition().getX(), ogre.getPosition().getY());
		}		
		
		if(guard==null && map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {
			System.out.println("YOUWIN");
		}	
			
		return false;
	}
}
