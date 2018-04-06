package dkeep.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoseGUI extends JPanel {

	    /**
	     * Create the panel.
	     */
	    public LoseGUI() {
	        super();
	        setBtnMainMenu();
	        setBtnExit();
	        setLoseImage();

	        setLayout(null);
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

	public void setBtnMainMenu(){
		
			JButton btnMainMenu  = new JButton("");
			btnMainMenu.setOpaque(false);
			btnMainMenu.setContentAreaFilled(false);
			btnMainMenu.setBorderPainted(false);
			btnMainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					GameGUI.losePanel.setVisible(false);
					GameGUI.menu.setVisible(true);
					GameGUI.menu.requestFocus();
					
				}
			});
			btnMainMenu.setBounds(10, 500, 190, 80);
			add(btnMainMenu);	
		}
	    
	    private void setLoseImage() {
			JPanel losePanel = new JPanel();
			losePanel.setBounds(0, 0, 600, 600);
			losePanel.setBackground(Color.BLACK);
			ImageIcon loseImg = new ImageIcon(this.getClass().getResource("res/lose.png"));
			losePanel.add(new JLabel(loseImg));
			add(losePanel);
		}

}
