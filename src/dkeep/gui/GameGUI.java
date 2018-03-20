package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import dkeep.logic.Game;
import dkeep.logic.GameMap;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class GameGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI window = new GameGUI();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 560, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewGame.setBounds(455, 76, 89, 23);
		frame.getContentPane().add(btnNewGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(455, 276, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 75, 305, 224);
		frame.getContentPane().add(textArea);
		
		JButton btnUp = new JButton("Up");
		btnUp.setBounds(398, 149, 89, 23);
		frame.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(398, 222, 89, 23);
		frame.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(337, 185, 89, 23);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setBounds(455, 185, 89, 23);
		frame.getContentPane().add(btnRight);
		
		JLabel lblGuardsPersonality = new JLabel("Guard Personality");
		lblGuardsPersonality.setBounds(22, 49, 106, 14);
		frame.getContentPane().add(lblGuardsPersonality);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(122, 44, 106, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");
	}
}
