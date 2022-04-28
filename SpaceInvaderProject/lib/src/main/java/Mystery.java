//import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.sound.sampled.Clip;

public class Mystery extends Invader{
	private Image img;
	protected Clip aud = getSound("aud_mystery.wav");
	protected Rectangle2D shape;
	
	protected Mystery(int x, int y) {
		super(x, y);
		img = getImage("img_mystery.gif");
		shape = new Rectangle2D.Double(x, y, 30, 30);
		points = getRandPoints();
	}
	
	public int getRandPoints() {
		var rand = Math.random();
		int pts = 0;
		if (rand <= .25) {
			pts = 50;
		}
		if (rand > .25 && rand <= .5) {
			pts = 100;
		}
		if (rand > .5 && rand <= .75) {
			pts = 150;
		}
		if (rand > .75 && rand <= 1) {
			pts = 300;
		}
		return pts;
	}
	
	@Override
	public void draw(Graphics2D g) {
		aud.setFramePosition(0);
		aud.start();
		var x = getX();
		var y = getY();
		g.drawImage(img, x, y, null);
		
	}
	
	public void removeSound() {
		aud = null;
	}

}
