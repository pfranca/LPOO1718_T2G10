package dkeep.logic;

public class Element {
	
	private CellPosition pos;
	
	public Element(GameMap map, char symbol) {
		for(int i=0;i<map.getMap().length;i++) {
			for(int j=0;j<map.getMap().length;j++) {
				if(map.getMap()[i][j]==symbol)
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
