package dkeep.logic;

import java.util.Random;

public class Guard extends Element {	
	
	private String personality;
	private boolean isAsleep = false;
	private boolean reverseGuard = false;
	private int path[][] = { { 1, 8 }, { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 5, 6 }, { 5, 5 }, { 5, 4 },
			{ 5, 3 }, { 5, 2 }, { 5, 1 }, { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 }, { 6, 6 }, { 6, 7 },
			{ 6, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 } };
	
	public Guard(GameMap map) {
		super(map, 'G');
	}
	
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	public String getPersonality() {
		return personality;
	}
	
	public boolean getAsleep() {
		return isAsleep;
	}
	
	public void moveGuard() {
		for (int i = 0; i < 24; i++) {
			if (path[i][0] == this.getPosition().getY() && path[i][1] == this.getPosition().getX()) {

				if (reverseGuard) {
					if (i == 0) {
						this.setPosition(path[23][1], path[23][0]);
					} else {
						this.setPosition(path[i - 1][1], path[i - 1][0]);
					}
				} else {
					if (i == 23) {
						this.setPosition(path[0][1], path[0][0]);
					} else {
						this.setPosition(path[i + 1][1], path[i + 1][0]);
					}
				}

				break;
			}
		}
	}
	
	public void moveRookie() {
		moveGuard();
	}
	
	public void moveDrunken() {
		Random r1 = new Random();
		Random r2 = new Random();

		int i = r1.nextInt(4);
		int j = r2.nextInt(4);

		if (i == 0) {
			this.isAsleep = true;	
		}
		else {
			this.isAsleep = false;
			
			if(j == 0) {
				this.reverseGuard = true;
			}
			else {
				this.reverseGuard = false;
			}

			moveGuard();
		}
	}

	public void moveSuspicious() {
		Random r = new Random();
		
		int i = r.nextInt(4);
		
		if(i == 0) {
			this.reverseGuard = true;
		}
		else {
			this.reverseGuard = false;
		}
		
		moveGuard();
	}
}
