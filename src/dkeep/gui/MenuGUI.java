package dkeep.gui;

import javax.swing.*;
import java.awt.event.*;

import dkeep.gui.Level1GUI;

public class MenuGUI extends JPanel{
	
	private JButton btnNewGame;
	private JFrame gameFrame = GameGUI.gameFrame;
	private JLayeredPane layerPane = GameGUI.layerPane;
	private Level1GUI level1 = GameGUI.level1;
	
	public MenuGUI() {
		super();
		
		setBtnNewGame();
		setBtnExit();
		//setBtnMapMaker();
		
		setImage();
	}
	
	private void setImage() {
		JPanel menuImgPanel = new JPanel();
		menuImgPanel.setBounds(0, 0, 1000, 1000);
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("res/menu.png"));
		menuImgPanel.add(new JLabel(menuImg));
		add(menuImgPanel);
	}
	
	public void setBtnNewGame() {
		btnNewGame = new JButton("Start New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameGUI.menu.setVisible(false);
				level1.setVisible(true);
				}
			
		});
		btnNewGame.setBounds(375, 360, 250, 80);
		add(btnNewGame);
	}
	
	public void setBtnExit() {
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(375, 460, 250, 80);
		add(btnExit);
	}

}
