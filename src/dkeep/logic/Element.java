package dkeep.logic;

/**  
* Element.java - Represents an element on the board, the hero, the guard, the ogre, the key, etc
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
*/ 
public class Element {
	
	private CellPosition pos;
	
	/**  
	*Element class constructor
	*
	*@param map An instance of GameMap containing a map with an element that's gonna be created
	*@param symbol the symbol that represents said elemnet in the map matrix
	*/
	public Element(GameMap map, char symbol) {
		for(int i=0;i<map.getMap().length;i++) {
			for(int j=0;j<map.getMap().length;j++) {
				if(map.getMap()[i][j]==symbol)
					this.pos = new CellPosition(j,i);
			}
		}		
	}
	
	/**  
	*@param x x coordenate value
	*@param y y coordenate value
	*@return Nothing.
	*/
	public void setPosition(int x,int y) {
		this.pos.set(x,y);
	}
	
	/**  
	*@return A Cell Position obejct containing the element position
	*/
	public CellPosition getPosition() {
		return pos;
	}

}
