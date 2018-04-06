package dkeep.logic;

/**  
* Hero.java - Represents the Hero element of the game
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
* @see Element.java
*/
public class Hero extends Element{
	
	boolean hasKey;
	
	/**  
	*Hero class constructor
	*
	*@param map An instance of GameMap containing a map with an Hero element
	*/
	public Hero(GameMap map,char simbol) {
		super(map, simbol);
		hasKey=false;
	}
	
	/**  
	*Sets hasKey to true
	*@return Nothing.
	*/
	public void setKey() {
		hasKey=true;
	}
	
	/**  
	*@return true if the hero has the key and false otherwise
	*/
	public boolean getKey() {
		return hasKey;
	}

}
