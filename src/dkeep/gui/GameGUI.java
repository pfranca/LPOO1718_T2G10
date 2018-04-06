package dkeep.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;


import javax.swing.JLayeredPane;

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
            {'I',' ',' ',' ','O',' ',' ','k','X'},
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
	static WinGUI winPanel;
	static LoseGUI losePanel;
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
		
		winPanel = new WinGUI();
		winPanel.setBounds(0, -3, 600, 600);
		winPanel.setVisible(false);
		layerPane.add(winPanel);
		
		losePanel = new LoseGUI();
		losePanel.setBounds(0, -3, 600, 600);
		losePanel.setVisible(false);
		layerPane.add(losePanel);
		
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
