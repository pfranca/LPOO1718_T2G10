package dkeep.logic;

import java.util.Random;

public class Guard extends Element {	
	
	private String personality;
	private boolean isAsleep = false;
	
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
		if(this.getPosition().getX() == 8 && this.getPosition().getY()== 1 ){
           setPosition(7,1);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 1 ){
            setPosition(7,2);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 2 ){
            setPosition(7,3);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 3 ){
            setPosition(7,4);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 4 ){
            setPosition(7,5);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 5 ){
            setPosition(6,5);
        } else if(this.getPosition().getX() == 6 && this.getPosition().getY()== 5 ){
            setPosition(5,5);
        } else if(this.getPosition().getX() == 5 && this.getPosition().getY()== 5 ){
            setPosition(4,5);
        } else if(this.getPosition().getX() == 4 && this.getPosition().getY()== 5 ){
            setPosition(3,5);
        } else if(this.getPosition().getX() == 3 && this.getPosition().getY()== 5 ){
            setPosition(2,5);
        } else if(this.getPosition().getX() == 2 && this.getPosition().getY()== 5 ){
            setPosition(1,5);
        } else if(this.getPosition().getX() == 1 && this.getPosition().getY()== 5 ){
            setPosition(1,6);
        } else if(this.getPosition().getX() == 1 && this.getPosition().getY()== 6 ){
            setPosition(2,6);
        } else if(this.getPosition().getX() == 2 && this.getPosition().getY()== 6 ){
            setPosition(3,6);
        } else if(this.getPosition().getX() == 3 && this.getPosition().getY()== 6 ){
        	setPosition(4,6);
        } else if(this.getPosition().getX() == 4 && this.getPosition().getY()== 6 ){
            setPosition(5,6);
        } else if(this.getPosition().getX() == 5 && this.getPosition().getY()== 6 ){
            setPosition(6,6);
        } else if(this.getPosition().getX() == 6 && this.getPosition().getY()== 6 ){
            setPosition(7,6);
        } else if(this.getPosition().getX() == 7 && this.getPosition().getY()== 6 ){
            setPosition(8,6);
        } else if(this.getPosition().getX() == 8 && this.getPosition().getY()== 6 ){
           setPosition(8,5);
        } else if(this.getPosition().getX() == 8 && this.getPosition().getY()== 5 ){
        	setPosition(8,4); 
        } else if(this.getPosition().getX() == 8 && this.getPosition().getY()== 4 ){
            setPosition(8,3);
        } else if(this.getPosition().getX() == 8 && this.getPosition().getY()== 3 ){
            setPosition(8,2);
        } else if(this.getPosition().getX() == 8 && this.getPosition().getY()== 2 ){
            setPosition(8,1);
        }
    }

	
	public void moveRookie() {
		moveGuard();
	}
	
	public void moveDrunken() {
		Random r1 = new Random();

		int i = r1.nextInt(4);

		if (i == 0) {
			this.isAsleep = true;	
		}
		else {
			this.isAsleep = false;
			moveGuard();
		}
	}

	public void moveSuspicious() {
		moveGuard();
	}
}
