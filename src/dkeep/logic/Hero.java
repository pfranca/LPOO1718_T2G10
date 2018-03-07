package dkeep.logic;

public class Hero {
	
	private CellPosition pos;
	
	public Hero(GameMap map) {
		for(int i=0;i<map.getMap().length;i++) {
			for(int j=0;j<map.getMap().length;j++) {
				if(map.getMap()[i][j]=='H')
					this.pos = new CellPosition(j,i);
			}
		}
		
	}
	
	public void setPosition(int x,int y) {
		this.pos.set(x,y);
	}
	
	public CellPosition getPosition() {
		return pos;
	}
	

}
