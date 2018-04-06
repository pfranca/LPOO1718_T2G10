package dkeep.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinGUI extends JPanel {

    /**
     * Create the panel.
     */
    public WinGUI() {
        super();
 
        
        setBtnMainMenu();
        setBtnExit();
        setWinImage();

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
				
			}
		});
		btnMainMenu.setBounds(10, 500, 190, 80);
		add(btnMainMenu);	
	}
    
    private void setWinImage() {
		JPanel winPanel = new JPanel();
		winPanel.setBounds(0, 0, 600, 600);
		winPanel.setBackground(Color.BLACK);
		ImageIcon winImg = new ImageIcon(this.getClass().getResource("res/win.png"));
		winPanel.add(new JLabel(winImg));
		add(winPanel);
	}
	
}