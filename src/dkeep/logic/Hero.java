package dkeep.logic;

public class Hero extends Element{
	
	boolean hasKey;
	
	public Hero(GameMap map,char simbol) {
		super(map, simbol);
		hasKey=false;
	}
	
	public void setKey() {
		hasKey=true;
	}
	
	public boolean getKey() {
		return hasKey;
	}
	

}
