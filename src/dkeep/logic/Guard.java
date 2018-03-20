package dkeep.logic;

public class Guard {
	
	private CellPosition pos;
	private String personality; //Rookie, Drunken, Suspicious
	private int path[][] = { { 1, 8 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 5, 6 }, { 5, 5 }, { 5, 4 },
			{ 5, 3 }, { 5, 2 }, { 5, 1 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 }, { 6, 6 }, { 6, 7 },
			{ 6, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 } };
	
	public Guard(int x,int y, String personality) {
		this.pos = new CellPosition(x,y);
		this.personality = personality;
	}
	
	public CellPosition getPosition() {
		return pos;
	}
	
	public String getPersonality() {
		return personality;
	}
	
	public void moveRookie(GameMap map) {
		
		for(int i = 0; i <= 23; i++) {
			if (path[i][0] == this.getPosition().getX() && path[i][1] == this.getPosition().getY()) {

					if (i == 0) {
						this.getPosition().set(path[0][23], path[1][23]);
					}
					else {
						this.getPosition().set(path[0][i - 1], path[1][i - 1]);
					}

					if (i == 23) {
						this.getPosition().set(path[0][0], path[1][0]);
					}
					else {
						this.getPosition().set(path[0][i + 1], path[1][i + 1]);
					}

				break;
			}		
		}
	}
	
	public void moveDrunken(GameMap map) {
		
	}

	public void moveSuspicious(GameMap map) {
		
	}
}
