package dkeep.logic;

public class Ogre extends Element{
	
	private CellPosition club;
	
	public Ogre(GameMap map) {
		super(map, 'O');
	}

	public CellPosition getClub() {
		return club;
	}
	
	public void setClub(int x, int y) {
		club.set(x, y);
	}
}