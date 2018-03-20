package dkeep.logic;

public class Guard {
	
private CellPosition pos;
	
	public Guard(GameMap map) {
		for(int i=0;i<map.getMap().length;i++) {
			for(int j=0;j<map.getMap().length;j++) {
				if(map.getMap()[i][j]=='G')
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
	
	public void moveGuard() {
		if(pos.getX() == 8 && pos.getY()== 1 ){
           setPosition(7,1);
        } else if(pos.getX() == 7 && pos.getY()== 1 ){
            setPosition(7,2);
        } else if(pos.getX() == 7 && pos.getY()== 2 ){
            setPosition(7,3);
        } else if(pos.getX() == 7 && pos.getY()== 3 ){
            setPosition(7,4);
        } else if(pos.getX() == 7 && pos.getY()== 4 ){
            setPosition(7,5);
        } else if(pos.getX() == 7 && pos.getY()== 5 ){
            setPosition(6,5);
        } else if(pos.getX() == 6 && pos.getY()== 5 ){
            setPosition(5,5);
        } else if(pos.getX() == 5 && pos.getY()== 5 ){
            setPosition(4,5);
        } else if(pos.getX() == 4 && pos.getY()== 5 ){
            setPosition(3,5);
        } else if(pos.getX() == 3 && pos.getY()== 5 ){
            setPosition(2,5);
        } else if(pos.getX() == 2 && pos.getY()== 5 ){
            setPosition(1,5);
        } else if(pos.getX() == 1 && pos.getY()== 5 ){
            setPosition(1,6);
        } else if(pos.getX() == 1 && pos.getY()== 6 ){
            setPosition(2,6);
        } else if(pos.getX() == 2 && pos.getY()== 6 ){
            setPosition(3,6);
        } else if(pos.getX() == 3 && pos.getY()== 6 ){
        	setPosition(4,6);
        } else if(pos.getX() == 4 && pos.getY()== 6 ){
            setPosition(5,6);
        } else if(pos.getX() == 5 && pos.getY()== 6 ){
            setPosition(6,6);
        } else if(pos.getX() == 6 && pos.getY()== 6 ){
            setPosition(7,6);
        } else if(pos.getX() == 7 && pos.getY()== 6 ){
            setPosition(8,6);
        } else if(pos.getX() == 8 && pos.getY()== 6 ){
           setPosition(8,5);
        } else if(pos.getX() == 8 && pos.getY()== 5 ){
        	setPosition(8,4); 
        } else if(pos.getX() == 8 && pos.getY()== 4 ){
            setPosition(8,3);
        } else if(pos.getX() == 8 && pos.getY()== 3 ){
            setPosition(8,2);
        } else if(pos.getX() == 8 && pos.getY()== 2 ){
            setPosition(8,1);
        }
    }
}


