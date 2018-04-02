package dkeep.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

import dkeep.logic.Game;
import dkeep.logic.GameMap;

public class Level1GUI extends JPanel {
	
	static char level1[][] = {
            {'X','X','X','X','X','X','X','X','X','X'},
            {'X','H',' ',' ','I',' ','X',' ','G','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'X',' ','I',' ','I',' ','X',' ',' ','X'},
            {'X','X','X',' ','X','X','X',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X',' ','X','X','X','X',' ','X'},
            {'X',' ','I',' ','I',' ','X','k',' ','X'},
            {'X','X','X','X','X','X','X','X','X','X'}};
	
	private static Game game;
	private JTextArea gameText;
	private JLabel lblGuardsPersonality;
	private JComboBox comboBox;
	private JTextArea gameMessage;
	private JButton btnUp;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	
	public Level1GUI() {
		super();
		
		setBtnExit();
		setGameText();
		setLblGuardPers();
		setGuardComboBox();
		setGameMessage();
		setBtnUp();
		setBtnDown();
		setBtnLeft();
		setBtnRight();
		
		gameText.setText(null);
		Level1GUI.game= new Game(new GameMap(level1));
		Level1GUI.game.setMap(new GameMap(level1));
		
		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
		btnLeft.setEnabled(true);
		btnRight.setEnabled(true);
		gameMessage.setText("You can play now");
		for(int i = 0; i<game.getMap().getMap().length; i++){
	          for(int j = 0; j<game.getMap().getMap().length; j++){
	             gameText.append((game.getMap().getMap()[i][j])+"");
	          }
	          gameText.append("\n");
	    }
	}
	
	public void setBtnExit() {
	JButton btnExit = new JButton("Exit");
	btnExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	btnExit.setBounds(455, 276, 89, 23);
	add(btnExit);
	}
	
	public void setGameText() {
		gameText = new JTextArea();
		gameText.setBounds(22, 46, 305, 224);
		gameText.setFont(new Font(Font.MONOSPACED, Font.PLAIN,15));
		add(gameText);
	}
	
	public void setLblGuardPers() {
		lblGuardsPersonality = new JLabel("Guard Personality");
		lblGuardsPersonality.setBounds(36, 27, 128, 14);
		add(lblGuardsPersonality);
	}
	
	public void setGuardComboBox() {
		comboBox = new JComboBox();
		comboBox.setBounds(182, 24, 106, 20);
		add(comboBox);
		comboBox.addItem("Random Guard");
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	Level1GUI.game.getGuard().setPersonality(comboBox.getSelectedItem().toString());
		    }
		});
	}
	
	public void setGameMessage() {
		gameMessage = new JTextArea();
		gameMessage.setBounds(22, 284, 234, 15);
		gameMessage.setText("You can start a new game!");
		add(gameMessage);
	}

	public void setBtnUp() {
		btnUp = new JButton("Up");
		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(game.isGameOver()) {
					gameMessage.setText("Game Over");
					btnUp.setEnabled(false);
					btnDown.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					
				}else {
					game.moveHero("w");
		            game.moveGuard(game.getGuard());
		            gameMessage.setText("you moved up");
		            gameText.setText(null);
		            for(int i = 0; i<game.getMap().getMap().length; i++){
				          for(int j = 0; j<game.getMap().getMap().length; j++){
				             gameText.append((game.getMap().getMap()[i][j])+"");
				          }
				          gameText.append("\n");
				    }
				}
	            
			}
		});
		btnUp.setBounds(398, 115, 89, 23);
		btnUp.setEnabled(false);
		add(btnUp);
	}
	
	public void setBtnDown() {
		btnDown = new JButton("Down");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(game.isGameOver()) {
					gameMessage.setText("Game Over");
					btnUp.setEnabled(false);
					btnDown.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					
				}else {
					game.moveHero("s");
		            game.moveGuard(game.getGuard());
		            gameMessage.setText("you moved down");
		            gameText.setText(null);
		            for(int i = 0; i<game.getMap().getMap().length; i++){
				          for(int j = 0; j<game.getMap().getMap().length; j++){
				             gameText.append((game.getMap().getMap()[i][j])+"");
				          }
				          gameText.append("\n");
				    }
				}
	            
			}
		});
		btnDown.setBounds(398, 185, 89, 23);
		btnDown.setEnabled(false);
		add(btnDown);
	}
	
	public void setBtnLeft() {
		btnLeft = new JButton("Left");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(game.isGameOver()) {
					gameMessage.setText("Game Over");
					btnUp.setEnabled(false);
					btnDown.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					
				}else {
					game.moveHero("a");
		            game.moveGuard(game.getGuard());
		            gameMessage.setText("you moved left");
		            gameText.setText(null);
		            for(int i = 0; i<game.getMap().getMap().length; i++){
				          for(int j = 0; j<game.getMap().getMap().length; j++){
				             gameText.append((game.getMap().getMap()[i][j])+"");
				          }
				          gameText.append("\n");
				    }
				}
	            
			}
		});
		btnLeft.setBounds(339, 150, 89, 23);
		btnLeft.setEnabled(false);
		add(btnLeft);
	}
	
	public void setBtnRight() {
		btnRight = new JButton("Right");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(game.isGameOver()) {
					gameMessage.setText("Game Over");
					btnUp.setEnabled(false);
					btnDown.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					
				}else {
					game.moveHero("d");
		            game.moveGuard(game.getGuard());
		            gameMessage.setText("you moved right");
		            gameText.setText(null);
		            for(int i = 0; i<game.getMap().getMap().length; i++){
				          for(int j = 0; j<game.getMap().getMap().length; j++){
				             gameText.append((game.getMap().getMap()[i][j])+"");
				          }
				          gameText.append("\n");
				    }
				}
	            
			}
		});
		btnRight.setBounds(455, 150, 89, 23);
		btnRight.setEnabled(false);
		add(btnRight);
	}

}
