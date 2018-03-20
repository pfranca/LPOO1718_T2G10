package dkeep.logic;

public class Key {
	
	private CellPosition pos;
	
	public Key(GameMap map) {
		for(int i=0;i<map.getMap().length;i++) {
			for(int j=0;j<map.getMap().length;j++) {
				if(map.getMap()[i][j]=='k')
					this.pos = new CellPosition(j,i);
			}
		}
		
	}
	
	public CellPosition getPosition() {
		return pos;
	}

}
