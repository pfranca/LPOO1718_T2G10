package dkeep.logic;

/**  
* GameMap.java - Represents athe game map
* @author  Patricia Janeiro
* @author  Pedro França
* @version 1.0 
*/
public class GameMap {
	
	 private char[][] map;
	
	/**  
	*GameMap class constructor
	*
	*@param map a matrix(double array) os char's representing the game map and elements
	*/
	 public GameMap(char[][] map){
		 this.map=map;
		 
	 }
	
	/**  
	*@return the matrix of char representing the map
	*/
	public char[][] getMap(){
		return map;
	}
	
	/**  
	*Prints the map
	*
	*@return Nothing.
	*/
	public void printMap(){
        for(int i = 0; i<map.length; i++){
           for(int j = 0; j<map.length; j++){
               System.out.print(map[i][j]);
           }
           System.out.println();
       }
    }
	
	/**  
	*Updates the hero position in the "graphical" representation
	*
	*@param x hero's actual x position
	*@param y hero's actual y position
	*@param input direction to where the hero moved
	*@param key true if the hero has picked up the key and false if not
	*@return Nothing.
	*/
	public void updateHero(int x, int y, String input, boolean key) {
		if(map.length==10 &&  x==7 && y==8) {
			map[y][x]='k';
		}
		else {
			map[y][x]=' ';
		}
		if(!key) {
			switch(input){
				case "w": map[y-1][x]='H'; break;
				case "a": map[y][x-1]='H'; break;
				case "s": map[y+1][x]='H'; break;
				case "d": map[y][x+1]='H'; break;
				default:break;
			}	
		}
		if(key) {
			switch(input){
				case "w": map[y-1][x]='K'; break;
				case "a": map[y][x-1]='K'; break;
				case "s": map[y+1][x]='K'; break;
				case "d": map[y][x+1]='K'; break;
				default:break;
			}	
		}		
	}
	
	/**  
	*Updates the Guard position in the "graphical" representation
	*
	*@param x guard's actual x position
	*@param y guard's actual y position
	*@return Nothing.
	*/
	public void updateGuard(int x, int y) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(map[i][j]=='g') {
					map[i][j]=' ';
				}
				if(map[i][j]=='G')
					map[i][j]=' ';
			}
		}
		map[y][x]='G';
	}
	
	/**  
	*Updates the ogre position in the "graphical" representation
	*
	*@param x ogre's actual x position
	*@param y ogre's actual y position
	*@param direction random direction in which the ogre moved
	*@return Nothing.
	*/
	public void updateOgre(int x, int y, String direction) {
		
		map[y][x] = ' ';
		switch(direction){
		case "up": map[y-1][x]='O'; break;
		case "left": map[y][x-1]='O'; break;
		case "down": map[y+1][x]='O'; break;
		case "right": map[y][x+1]='O'; break;
		default:break;
		}
		
	}
	
	/**  
	*Updates the club position in the "graphical" representation
	*
	*@param x ogre's actual x position
	*@param y ogre's actual y position
	*@param r random direction in which the club moved
	*@return Nothing.
	*/
	public void updateClub(int x, int y, int r) {
		
		switch(r){
		case 0: map[y][x+1] = ' '; map[y][x+1]='*'; break;
		case 1: map[y][x-1] = ' '; map[y][x-1]='*'; break;
		case 2: map[y+1][x] = ' ';map[y+1][x]='*'; break;
		case 3: map[y-1][x] = ' '; map[y-1][x]='*'; break;
		default:break;
	}}

}
