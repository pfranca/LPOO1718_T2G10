package dkeep.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuGUI extends JPanel{
	
	private JFrame gameFrame = GameGUI.gameFrame;
	
	public MenuGUI() {
		super();
		
		setBtnNewGame();
		setBtnExit();
		//setBtnMapMaker();		
		setImage();
	}
	
	private void setImage() {
		JPanel menuImgPanel = new JPanel();
		menuImgPanel.setBounds(0, 0, 600, 600);
		menuImgPanel.setBackground(Color.BLACK);
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("res/menu4.png"));
		menuImgPanel.add(new JLabel(menuImg));
		add(menuImgPanel);
	}
	

private void setBtnExit() {
		
		JButton btnExit = new JButton("");
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(410, 500, 190, 80);
		add(btnExit);	
	}

public void setBtnNewGame(){
	
		JButton btnNewGame  = new JButton("");
		btnNewGame.setOpaque(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorderPainted(false);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String guard;
				String[] guardOptions = { "Rookie", "Drunken", "Suspicious" };
				guard = (String) JOptionPane.showInputDialog(gameFrame, "        Chose Guard's Personality.",
						"", JOptionPane.PLAIN_MESSAGE, null, guardOptions, "Rookie");
				GameGUI.setGame(guard);
				GameGUI.menu.setVisible(false);
				GameGUI.level1Panel.update();
				GameGUI.level1Panel.setVisible(true);
				GameGUI.level1Panel.requestFocus();
				
			}
		});
		btnNewGame.setBounds(10, 500, 190, 80);
		add(btnNewGame);	
	}

}
