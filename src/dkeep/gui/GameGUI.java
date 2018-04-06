package dkeep.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import dkeep.logic.Game;
import dkeep.logic.GameMap;

public class GameGUI {
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
	static char level2[][] = {
            {'X','X','X','X','X','X','X','X','X'},
            {'I',' ',' ',' ',' ',' ',' ','O','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','H',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X','X','X','X','X','X','X'}};
	
	static JFrame gameFrame;
	static JLayeredPane layerPane;
	static MenuGUI menu;
	static Level1GUI level1Panel;
	static Game game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.gameFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public GameGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		gameFrame = new JFrame();
		gameFrame.setResizable(true);
		gameFrame.setBounds(400, 160, 600, 635);
		//gameFrame.pack();
		gameFrame.setTitle("DnD");
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.getContentPane().setLayout(null);
		
		
		layerPane = new JLayeredPane();
		layerPane.setBounds(0,0,600,600);
		gameFrame.getContentPane().add(layerPane);
		layerPane.setLayout(null);
		
		level1Panel = new Level1GUI(650, 650, 10);
		level1Panel.setBounds(0, 0, 600, 600);
		level1Panel.setVisible(false);
		layerPane.add(level1Panel);
		
		menu = new MenuGUI();
		menu.setBounds(0, -3, 600, 600);
		layerPane.add(menu);
		menu.setLayout(null);
		
		
	}
	
	public static void setGame(String guard) {
		GameGUI.game = new Game(new GameMap(level1));
		GameGUI.game.getGuard().setPersonality(guard);

	}
	
	
	public static Game getGame() {
		return game;
	}
	
	
	public static GameMap getMap() {
		return game.getMap();
	}
	
}
