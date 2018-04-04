package dkeep.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.border.MatteBorder;

import java.awt.event.*;

import dkeep.gui.Level1GUI;

public class MenuGUI extends JPanel{
	
	private JFrame gameFrame = GameGUI.gameFrame;
	private JLayeredPane layerPane = GameGUI.layerPane;
	private JComboBox comboBox;
	
	public MenuGUI() {
		super();
		
		setBtnNewGame();
		setBtnExit();
		//setBtnMapMaker();
		
		setImage();
	}
	
	private void setImage() {
		JPanel menuImgPanel = new JPanel();
		menuImgPanel.setBounds(0, 0, 500, 500);
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
		btnExit.setBounds(150, 400, 150, 30);
		add(btnExit);	
	}

public void setBtnNewGame(){
	
		JButton btnNewGame  = new JButton("");
		btnNewGame.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewGame.setBackground(Color.BLACK);
		btnNewGame.setIcon(new ImageIcon(MenuGUI.class.getResource("res/btnNewGame3.jpg")));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				comboBox = new JComboBox();
				comboBox.setBounds(182, 24, 106, 20);
				add(comboBox);
				comboBox.addItem("Random Guard");
				comboBox.addItem("Rookie");
				comboBox.addItem("Drunken");
				comboBox.addItem("Suspicious");		
				comboBox.addActionListener (new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				    	String guard= comboBox.getSelectedItem().toString();
				    	GameGUI.setGame(guard);
						GameGUI.menu.setVisible(false);
						GameGUI.level1Panel.update();
						GameGUI.level1Panel.setVisible(true);
						GameGUI.level1Panel.requestFocus();
				    }
				});
							
				
			}
		});
		btnNewGame.setBounds(300, 450, 150, 40);
		add(btnNewGame);
		
	}

}
