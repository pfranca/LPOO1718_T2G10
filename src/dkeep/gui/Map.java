package dkeep.gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Map extends JPanel{
	
	protected ImageIcon wall;
	protected ImageIcon guard;
	protected ImageIcon sleepingGuard;
	protected ImageIcon floor;
	protected ImageIcon hero;
	protected ImageIcon key;
	protected ImageIcon openDoor;
	protected ImageIcon closedDoor;
	protected ImageIcon ogre;
	
	public Map() {
		super();

	}
	
	private ImageIcon resizeImage(ImageIcon im) {

		Image img = im.getImage();
		Image newimg = img.getScaledInstance(this.getWidth() / 10, this.getHeight() / 10, Image.SCALE_DEFAULT);

		return new ImageIcon(newimg);
	}
	
	protected void setImages() {

		wall = new ImageIcon(this.getClass().getResource("res/wall.png"));
		guard = new ImageIcon(this.getClass().getResource("res/guard.png"));
		sleepingGuard = new ImageIcon(this.getClass().getResource("res/sleepingGuard.png"));
		floor = new ImageIcon(this.getClass().getResource("res/floor.png"));
		hero = new ImageIcon(this.getClass().getResource("res/hero.png"));
		key = new ImageIcon(this.getClass().getResource("res/key.png"));
		openDoor = new ImageIcon(this.getClass().getResource("res/openDoor2.png"));
		closedDoor = new ImageIcon(this.getClass().getResource("res/closedDoor2.png"));
		//ogre = new ImageIcon(this.getClass().getResource("res/ogre.png"));
		ogre = new ImageIcon(this.getClass().getResource("res/guard.png"));

		wall = resizeImage(wall);
		guard = resizeImage(guard);
		sleepingGuard = resizeImage(sleepingGuard);
		floor =resizeImage(floor);
		hero = resizeImage(hero);
		key = resizeImage(key);
		openDoor = resizeImage(openDoor);
		closedDoor = resizeImage(closedDoor);
		ogre = resizeImage(ogre);
	}
	
	public void paintComponent (char[][] map) {
		char c;

		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++) {

				c = map[i][j];

				switch (c) {
				case 'X':
					this.add(new JLabel(wall));
					break;
				case 'G':
					this.add(new JLabel(guard));
					break;
				case 'g':
					this.add(new JLabel(sleepingGuard));
					break;
				case 'I':
					this.add(new JLabel(closedDoor));
					break;
				case 'H':
					this.add(new JLabel(hero));
					break;
				case 'k':
					this.add(new JLabel(key));
					break;
				case 'S':
					this.add(new JLabel(openDoor));
					break;
				case 'O':
					this.add(new JLabel(guard));
					break;
				default:
					this.add(new JLabel(floor));
					break;
				}

			}
		

	}
	
	public void update(char[][] map){
		removeAll();

		repaint();
		
		paintComponent(map);
		
		
		revalidate();
	}

}
