package dkeep.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

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
		menuImgPanel.setBounds(0, 0, 1000, 1000);
		ImageIcon menuImg = new ImageIcon(this.getClass().getResource("res/menu2.png"));
		menuImgPanel.add(new JLabel(menuImg));
		add(menuImgPanel);
	}
	
private void setBtnExit() {
		
		JButton btnExit = new JButton("");
		btnExit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnExit.setBackground(Color.BLACK);
		btnExit.setIcon(new ImageIcon(MenuGUI.class.getResource("res/btnExit3.jpg")));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(650, 860, 275, 65);
		add(btnExit);	
	}

public void setBtnNewGame(){
	
		JButton btnNewGame  = new JButton("");
		btnNewGame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewGame.setBackground(Color.BLACK);
		btnNewGame.setIcon(new ImageIcon(MenuGUI.class.getResource("res/btnNewGame3.jpg")));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		btnNewGame.setBounds(600, 750, 320, 86);
		add(btnNewGame);
		
	}

}
