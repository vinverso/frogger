package frogger;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		Background background = new Background(this);;
		Cast cast;
		
		
	public View(Cast cast) {
		this.cast = cast;
	}
	
	/**
	 * draws the background and then the sprites
	 */
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(background.drawBackground(), 0, 0, getWidth(), getHeight(), this);
		for (Sprite s : cast.getCastList()) {
        	g.drawImage(s.loadImage(), s.getX(), s.getY(), this);
        }

	}
}
