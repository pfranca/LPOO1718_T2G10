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
             {'I',' ',' ',' ','O',' ',' ','k','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X',' ',' ',' ',' ',' ',' ',' ','X'},
             {'X','H',' ',' ',' ',' ',' ',' ','X'},
             {'X','X','X','X','X','X','X','X','X'}};
	 
	 private char[][] map;
	
	 public GameMap(char[][] map){
		 this.map=map;
		 
	 }
	
	public char[][] getMap(){
		return map;
	}
	
	public void printMap(){
        for(int i = 0; i<map.length; i++){
           for(int j = 0; j<map.length; j++){
               System.out.print(map[i][j]);
           }
           System.out.println();
       }
    }
	
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

}
