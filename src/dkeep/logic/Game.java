package dkeep.logic;

import java.util.Random;

/**  
* Game.java - The "base" class for our dungeon game where the game elements are "stored"
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
*/ 
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
	private boolean win;
	
	/**  
	*@return the guard object of this instance of the game
	*/ 
	public Guard getGuard() {
		return this.guard;
	}
	
	/**  
	*@return the ogre object of this instance of the game
	*/ 
	public Ogre getOgre() {
		return this.ogre;
	}
	
	/**  
	*@return true if the game ends in a winning state or false otherwise
	*/ 
	public boolean getWin() {
		return win;
	}
	
	/**  
	*Game classe constructor
	*
	*@param map An object of type GameMap that contains the map of the level being played
	*/
	public Game(GameMap map) {
		this.map=map;
		this.hero = new Hero(map,'H');
		this.lever = new Key(map);
		this.guard = new Guard(map);
		this.win = false;
		
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
	
	/**  
	*Updates all the game elements(hero, guard, ogre)
	*
	*@param input String representing the direction in which the hero should move
	*@param guard A Guard object
	*@param ogre An Ogre object
	*@return Nothing.
	*/
	public void updateGame(String input, Guard guard, Ogre ogre) {		
		if(this.guard!=null) {
			moveGuard(guard);
			moveHero(input);
		}else {
			if(this.ogre!=null) {
				moveOgre();
				if(ogre.getClub()!=null)
					ogreClub(ogre);
				moveHero(input);
			}	
		}
	}
	
	/**  
	*Moves the hero based on player input
	*
	*@param input A String inputed by the player that tells in wich direction the hero should move
	*@return Nothing.
	*/
	public void moveHero(String input) {
		switch(input) {
		case "w":
			if(map.getMap()[hero.getPosition().getY()-1][hero.getPosition().getX()] == ' ' ) {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
			}
			if(guard==null && hero.getPosition().getY()-1 == lever.getPosition().getY() && hero.getPosition().getX() == lever.getPosition().getX()) {
					map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
					hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()-1); 
					hero.setKey();
			}
			break;
		case "a":
			if(hero.getKey() && hero.getPosition().getX()==1 && hero.getPosition().getY()==1 && map.getMap()[1][0] == 'I') {
				map.getMap()[1][0] = 'S';
				break;
			}
			/*if( hero.getKey() && map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {		
			}*/
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == ' ' ) {			
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
			}
			if(guard!=null && hero.getPosition().getY() == lever.getPosition().getY() && hero.getPosition().getX()-1 == lever.getPosition().getX()) {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
				hero.setPosition(hero.getPosition().getX()-1, hero.getPosition().getY()); 
				map.getMap()[5][0] = 'S';
				map.getMap()[6][0] = 'S';		
			}
			break;
		case "s":
			if(map.getMap()[hero.getPosition().getY()+1][hero.getPosition().getX()] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
				hero.setPosition(hero.getPosition().getX(), hero.getPosition().getY()+1); 
			}
			break;
		case "d":
			if(map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()+1] == ' ') {
				map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
				hero.setPosition(hero.getPosition().getX()+1, hero.getPosition().getY()); 
			}	
			if(guard==null && hero.getPosition().getY() == lever.getPosition().getY() && hero.getPosition().getX()+1 == lever.getPosition().getX()) {
					map.updateHero(hero.getPosition().getX(), hero.getPosition().getY(),input,hero.getKey());
					hero.setPosition(hero.getPosition().getX()+1, hero.getPosition().getY()); 
					hero.setKey();			
			}
			break;
		default:break;
		}	
	}
	
	/**  
	*Moves the guard according to its personality
	*
	*@param guard A Guard object
	*@return Nothing.
	*/
	public void moveGuard(Guard guard) {
		if(guard!=null) {
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
	}
	
	/**  
	*Moves the Ogre
	*
	*@param ogre An Ogre object
	*@return Nothing.
	*/
	public void moveOgre() {

			Random random = new Random();
			int r = random.nextInt(4);

			switch(r) {
			case 0:
				if(map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()+1] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"right");
					ogre.setPosition(ogre.getPosition().getX()+1, ogre.getPosition().getY()); 
				}
				break;
			case 1:
				if(map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()-1] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"left");
					ogre.setPosition(ogre.getPosition().getX()-1, ogre.getPosition().getY());
				}
				break;
			case 2:
				if(map.getMap()[ogre.getPosition().getY()+1][ogre.getPosition().getX()] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"down");
					ogre.setPosition(ogre.getPosition().getX(), ogre.getPosition().getY()+1); 
				}
				break;
			case 3:
				if(map.getMap()[ogre.getPosition().getY()-1][ogre.getPosition().getX()] == ' ') {
					map.updateOgre(ogre.getPosition().getX(), ogre.getPosition().getY(),"up");
					ogre.setPosition(ogre.getPosition().getX(), ogre.getPosition().getY()-1); 
				}
				break;
			default:break;
			}
	}
	
	/**  
	*Positions the ogre's club
	*
	*@param ogre An Ogre object
	*@return Nothing.
	*/
	public void ogreClub(Ogre ogre) {

			Random random = new Random();
			int r = random.nextInt(4);
			
			switch(r) {
			case 0:
				if (map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()+1] == ' ') {
					map.updateClub(ogre.getPosition().getX(), ogre.getPosition().getY(), r);
					ogre.setClub(ogre.getPosition().getX()+1, ogre.getPosition().getY());
				}
				break;
			case 1:
				if (map.getMap()[ogre.getPosition().getY()][ogre.getPosition().getX()-1] == ' ') {
					map.updateClub(ogre.getPosition().getX(), ogre.getPosition().getY(), r);
					ogre.setClub(ogre.getPosition().getX()-1, ogre.getPosition().getY());
				}
				break;
			case 2:
				if (map.getMap()[ogre.getPosition().getY()+1][ogre.getPosition().getX()] == ' ') {
					map.updateClub(ogre.getPosition().getX(), ogre.getPosition().getY(), r);
					ogre.setClub(ogre.getPosition().getX(), ogre.getPosition().getY()+1);
				}
				break;
			case 3:
				if (map.getMap()[ogre.getPosition().getY()-1][ogre.getPosition().getX()] == ' ') {
					map.updateClub(ogre.getPosition().getX(), ogre.getPosition().getY(), r);
					ogre.setClub(ogre.getPosition().getX(), ogre.getPosition().getY()-1);
				}
				break;
			default:break;
			}
	}
	
	/**  
	*@return A CellPosition object containing the hero position
	*/
	public CellPosition getHeroPosition() {
		return hero.getPosition();
		
	}
	
	/**  
	*@return A GameMap object containing the current map
	*/
	public GameMap getMap(){
		return map;
	}
	
	/**  
	*Changes the level by setting a new map
	*
	*@param map an instance of GameMap 
	*/
	public void setMap(GameMap map){
		this.map=map;
	}

	/**  
	*Checks if the game is in a final state
	*
	*@return true if it is in a final state and false otherwise
	*/
	public boolean isGameOver() {
		
		if(guard!=null && map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {
			this.guard = null;
			setMap(new GameMap(level2));
			this.ogre = new Ogre(map);
			this.hero.setPosition(1, 7);
			this.lever.setPosition(7, 1);
			this.ogre.setPosition(4, 1);
		}	
		if(checkOgre() || checkGuard() || checkWin()) {
			return true;
		}

		return false;
	}
	
	/**  
	*Checks if the game is in win state
	*
	*@return true if it is in a win state and false otherwise
	*/
	public boolean checkWin() {
		if(guard==null && map.getMap()[hero.getPosition().getY()][hero.getPosition().getX()-1] == 'S') {
			this.win = true;
			System.out.println("YOUWIN");
			return true;
		}	
		return false;
	}
	
	/**  
	*Checks if the hero 'touched' the ogre or his club
	*
	*@return true if it he did and false otherwise
	*/
	public boolean checkOgre() {
		if(ogre!=null) {
			if(hero.getPosition().getX() == ogre.getPosition().getX() && hero.getPosition().getY() == ogre.getPosition().getY()-1||
					hero.getPosition().getX() == ogre.getPosition().getX() && hero.getPosition().getY() == ogre.getPosition().getY()+1 ||
					hero.getPosition().getX() == ogre.getPosition().getX()-1 && hero.getPosition().getY() == ogre.getPosition().getY() ||
					hero.getPosition().getX() == ogre.getPosition().getX()+1 && hero.getPosition().getY() == ogre.getPosition().getY()){
					System.out.println("GAME OVER!");
					return true;
				}	
			if(ogre.getClub() !=null) {
				if(hero.getPosition().getX() == ogre.getClub().getX() && hero.getPosition().getY() == ogre.getClub().getY()-1||
						hero.getPosition().getX() == ogre.getClub().getX() && hero.getPosition().getY() == ogre.getClub().getY()+1 ||
						hero.getPosition().getX() == ogre.getClub().getX()-1 && hero.getPosition().getY() == ogre.getClub().getY() ||
						hero.getPosition().getX() == ogre.getClub().getX()+1 && hero.getPosition().getY() == ogre.getClub().getY()){
						System.out.println("GAME OVER!");
						return true;
					}				
			}
		}	
		return false;
	}
	
	/**  
	*Checks if the hero 'touched' the guard 
	*
	*@return true if it he did and false otherwise
	*/
	public boolean checkGuard() {
		if(guard!=null && !guard.getAsleep()) {
			if(hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()-1||
				hero.getPosition().getX() == guard.getPosition().getX() && hero.getPosition().getY() == guard.getPosition().getY()+1 ||
				hero.getPosition().getX() == guard.getPosition().getX()-1 && hero.getPosition().getY() == guard.getPosition().getY() ||
				hero.getPosition().getX() == guard.getPosition().getX()+1 && hero.getPosition().getY() == guard.getPosition().getY()){
				System.out.println("GAME OVER!");
				return true;
			}
		}
		return false;
	}
}
