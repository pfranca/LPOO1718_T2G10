package dkeep.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;

import dkeep.logic.Game;
import dkeep.logic.GameMap;
import dkeep.logic.Guard;

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
		
		

		if (GameGUI.getGame().isGameOver()){	
			System.exit(0);	
		}
		//GameGUI.getGame().moveHero(input);
		
		
		//GameGUI.getGame().moveGuard(GameGUI.getGame().getGuard());
		GameGUI.getGame().updateGame(input, GameGUI.getGame().getGuard());
		if(GameGUI.getMap().getMap()[GameGUI.getGame().getHeroPosition().getY()][GameGUI.getGame().getHeroPosition().getX()-1] == 'S') 	
			GameGUI.setLevel2();

		
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


	public void setSize(int size) {
		this.setLayout(new GridLayout(size, size));
		
	}
	
	

}
