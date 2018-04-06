package dkeep.logic;

/**  
* Key.java - Represents the Key element of the game
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
* @see Element.java
*/
public class Key extends Element {
	
	/**  
	*Key class constructor
	*
	*@param map An instance of GameMap containing a map with an Key element
	*/
	public Key(GameMap map) {
		super(map, 'k');
	}

}
