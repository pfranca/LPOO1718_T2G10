package dkeep.logic;

public class Ogre extends Element{
	
	private CellPosition club;
	
	public Ogre(GameMap map) {
		super(map, 'O');
		club = new CellPosition(0, 0);
	}

	public CellPosition getClub() {
		return club;
	}
	
	public void setClub(int X, int Y) {
		club.set(X, Y);
	}
}