import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.sound.sampled.Clip;

public class Missile extends Drawable{
	private int width = 2;
	private int hight = 10;
	protected Rectangle2D shape;
	
	// add variables for sound (aud_hit, aud_basefire)
	
	protected Missile(int x, int y) {
		super(x, y);
		shape = new Rectangle2D.Double(x,y,2, 10);
	}

	@Override
	public void draw(Graphics2D g) {
		
//		g.fill(shape);
		g.setColor(Color.WHITE);
		g.drawRect(getX()+12, getY(), 2,10);
	}
	
	public boolean isHit(Rectangle2D object) {
		
		if (getRectangle().intersects(shape)) {
			return true;
		}
		return false;
	}
	public Rectangle2D getRectangle () {
		int x = getX();
		int y = getY();
		int w = 2;
		int h = 10;
		return new Rectangle2D.Double(x, y, w , h);
	}
}


