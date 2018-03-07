package dkeep.logic;

public class GameMap {
	
	static char level1[][] = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X',' ',' ',' ','I',' ','X',' ',' ','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'X',' ','I',' ','I',' ','X',' ',' ','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X',' ','X','X','X','X',' ','X'},
            {'X',' ','I',' ','I',' ','X','k',' ','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
	
	 static char level2[][] = {
             {'X','X','X','X','X','X','X','X','X'},
             {'I',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X','X','X','X','X','X','X','X','X'}};
	 
	 private char[][] map;
	
	 public GameMap(char[][] map){
		 this.map=map;
		 
	 }
	
	public char[][] getMap(){
		return map;
	}
	
	public static void printLevel(char[][] map){
        for(int i = 0; i<map.length; i++){
           for(int j = 0; j<map.length; j++){
               System.out.print(map[i][j]);
           }
           System.out.println();
       }
    }

}
