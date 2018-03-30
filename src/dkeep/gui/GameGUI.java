package dkeep.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import dkeep.logic.Game;
import dkeep.logic.GameMap;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	private JFrame frame;
	private static Game game;

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
				
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(455, 276, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JTextArea gameText = new JTextArea();
		gameText.setBounds(22, 46, 305, 224);
		gameText.setFont(new Font("Courier New", Font.PLAIN,15));
		frame.getContentPane().add(gameText);
		
		JLabel lblGuardsPersonality = new JLabel("Guard Personality");
		lblGuardsPersonality.setBounds(36, 27, 128, 14);
		frame.getContentPane().add(lblGuardsPersonality);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(182, 24, 106, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Rookie");
		comboBox.addItem("Drunken");
		comboBox.addItem("Suspicious");
		
		JTextArea gameMessage = new JTextArea();
		gameMessage.setBounds(22, 284, 234, 15);
		gameMessage.setText("You can start a new game!");
		frame.getContentPane().add(gameMessage);
		
		JButton btnUp = new JButton("Up");
		btnUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		btnUp.setBounds(398, 115, 89, 23);
		btnUp.setEnabled(false);
		frame.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		btnDown.setBounds(398, 185, 89, 23);
		btnDown.setEnabled(false);
		frame.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		btnLeft.setBounds(339, 150, 89, 23);
		btnLeft.setEnabled(false);
		frame.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		});
		btnRight.setBounds(455, 150, 89, 23);
		btnRight.setEnabled(false);
		frame.getContentPane().add(btnRight);
		
		JButton btnNewGame = new JButton("Start New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameGUI.game= new Game(new GameMap(level1));
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
		});
		btnNewGame.setBounds(363, 42, 165, 23);
		frame.getContentPane().add(btnNewGame);
		
		
	}
}
