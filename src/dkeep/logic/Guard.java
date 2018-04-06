package dkeep.logic;

import java.util.Random;

/**  
* GameMap.java - Represents athe game map
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
* @see Element.java
*/
public class Guard extends Element {	
	
	private String personality;
	private boolean isAsleep = false;
	private boolean reverseGuard = false;
	private int path[][] = { { 1, 8 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 5, 6 }, { 5, 5 }, { 5, 4 },
			{ 5, 3 }, { 5, 2 }, { 5, 1 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 }, { 6, 6 }, { 6, 7 },
			{ 6, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 } };
	
	/**  
	*Guard class constructor
	*
	*@param map An instance of GameMap containing a map with an Guard element
	*/
	public Guard(GameMap map) {
		super(map, 'G');
	}
	
	/**  
	*@param personality ENUM("Rookie","Drunken","Suspicious")
	*@return Nothing.
	*/
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	/**  
	*@return the guard personality(String)
	*/
	public String getPersonality() {
		return personality;
	}
	
	/**  
	*@return true if guard is a sleep or false otherwise
	*/
	public boolean getAsleep() {
		return isAsleep;
	}
	
	/**  
	*Moves the guard in its path
	*
	*@return Nothing.
	*/
	public void moveGuard() {
		for (int i = 0; i < 24; i++) {
			if (path[i][0] == this.getPosition().getY() && path[i][1] == this.getPosition().getX()) {
				if (reverseGuard) {
					if (i == 0) {
						this.setPosition(path[23][1], path[23][0]);
					} else {
						this.setPosition(path[i - 1][1], path[i - 1][0]);
					}
				} else {
					if (i == 23) {
						this.setPosition(path[0][1], path[0][0]);
					} else {
						this.setPosition(path[i + 1][1], path[i + 1][0]);
					}
				}
				break;
			}
		}
	}
	
	/**  
	*Moves the Rookie Guard
	*@return Nothing.
	*@see Guard.moveGuard()
	*/
	public void moveRookie() {
		moveGuard();
	}
	
	/**  
	*Moves the Drunken Guard
	*@return Nothing.
	*/
	public void moveDrunken() {
		Random r1 = new Random();
		Random r2 = new Random();
		int i = r1.nextInt(4);
		int j = r2.nextInt(4);
		if (i == 0) {
			this.isAsleep = true;	
		}
		else {
			this.isAsleep = false;
			
			if(j == 0) {
				this.reverseGuard = true;
			}
			else {
				this.reverseGuard = false;
			}
			moveGuard();
		}
	}

	/**  
	*Moves the Suspicious Guard
	*@return Nothing.
	*/
	public void moveSuspicious() {
		Random r = new Random();
		int i = r.nextInt(4);
		if(i == 0) {
			this.reverseGuard = true;
		}
		else {
			this.reverseGuard = false;
		}
		moveGuard();
	}
}
