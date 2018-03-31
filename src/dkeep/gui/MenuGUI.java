package dkeep.gui;

import javax.swing.*;

public class MenuGUI extends JPanel{
	
	private JButton btnNewGame;
	private JFrame gameFrame = GameGUI.gameFrame;
	
	public MenuGUI() {
		super();
		
		//setBtnNewGame();
		//setBtnExit();
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

}
