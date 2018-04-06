package dkeep.logic;

/**  
* CellPosition.java - Represents a cell position on the boards, holds a x and y value
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
*/ 
public class CellPosition {

	private int x;
	private int y;
	
	/**  
	*CellPosition classe constructor
	*
	*@param x x coordenate value
	*@param y y coordenate value
	*/
	public CellPosition(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**  
	*@param x x coordenate value
	*@param y y coordenate value
	*@return Nothing.
	*/
	public void set(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**  
	*@return x value
	*/
	public int getX() {
		return x;
	}
	
	/**  
	*@return y value
	*/
	public int getY() {
		return y;
	}
}
