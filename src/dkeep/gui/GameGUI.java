package dkeep.gui;

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

public class GameGUI {
	
	static JFrame gameFrame;
	static JLayeredPane layerPane;
	static MenuGUI menu;
	static Level1GUI level1;

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
		gameFrame.setResizable(false);
		gameFrame.setBounds(100, 100, 1000, 1000);
		gameFrame.setTitle("DnD");
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.getContentPane().setLayout(null);
		
		
		layerPane = new JLayeredPane();
		layerPane.setBounds(0,0,1000,1000);
		gameFrame.getContentPane().add(layerPane);
		layerPane.setLayout(null);
		
		level1 = new Level1GUI();
		level1.setBounds(0, 0, 1000, 1000);
		layerPane.add(level1);
		level1.setLayout(null);
		level1.setVisible(false);
		
		menu = new MenuGUI();
		menu.setBounds(0, 0, 1000, 1000);
		layerPane.add(menu);
		menu.setLayout(null);
		
		
	}
}
