package dkeep.logic;

/**  
* Key.java - Represents the Key element of the game
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
* @see Element.java
*/
public class Ogre extends Element{
	
	private CellPosition club;
	
	/**  
	*Ogre class constructor
	*
	*@param map An instance of GameMap containing a map with an Ogre element
	*/
	public Ogre(GameMap map) {
		super(map, 'O');
		club = new CellPosition(0, 0);
	}

	/**  
	* @return a CellPosition object coitaing the position of the ogre's club
	*/
	public CellPosition getClub() {
		return club;
	}

	/**  
	* @param x x value of the club position
	* @param x x value of the club position
	* @return Nothing.
	*/
	public void setClub(int x, int y) {
		club.set(x, y);
	}
}