package dkeep.gui;

import javax.swing.*;

import java.awt.event.*;
import java.awt.GridLayout;


public class Level1GUI extends Map implements KeyListener {
	
	public Level1GUI(int width, int height, int size) {
		super();

		setBackground(java.awt.Color.BLACK);
		this.setLayout(new GridLayout(size, size));
		this.setSize(width, height);
		this.setVisible(true);
		
		setImages();
		
		addKeyListener(this);
		
	}

	
	public void update(){
		super.update(GameGUI.getMap().getMap());
	}
	
	public void playGameRound(String input) throws InterruptedException{
		

		GameGUI.getGame().updateGame(input, GameGUI.getGame().getGuard(), GameGUI.getGame().getOgre());
		if(GameGUI.getMap().getMap()[GameGUI.getGame().getHeroPosition().getY()][GameGUI.getGame().getHeroPosition().getX()-1] == 'S') 	{
			this.setLayoutSize(9);
		}

		if (GameGUI.getGame().isGameOver() && !GameGUI.getGame().getWin()){	
			GameGUI.level1Panel.setVisible(false);
			GameGUI.losePanel.setVisible(true);
			GameGUI.losePanel.requestFocus();	
		} else if (GameGUI.getGame().isGameOver() && GameGUI.getGame().getWin()){	
			GameGUI.level1Panel.setVisible(false);
			GameGUI.winPanel.setVisible(true);
			GameGUI.winPanel.requestFocus();	
		}
			
		update();
		
	
			
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		try{
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT: 
			playGameRound("a");  
			break;
		case KeyEvent.VK_RIGHT:
			playGameRound("d");  
			break;
		case KeyEvent.VK_UP: 
			playGameRound("w");   
			break;
		case KeyEvent.VK_DOWN: 
			playGameRound("s");  
			break;
		 }	
		
		}catch (InterruptedException e1){
			
		}
		
		requestFocus();
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void setLayoutSize(int size) {
		this.setLayout(new GridLayout(size, size));	
	}
	


}
