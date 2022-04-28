import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Invader extends Ship{
	protected Image img;
	
	protected int points;
	
	protected Invader(int x, int y) {
		super(x, y);
		
	}
	
	public int points(int x) {
		points = x;
		return points;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Image getDestroyed() {
		img = getImage("img_invaderhit.gif");
		return img;
	}
	public Missile shoot() {
//		fire.setFramePosition(0);
//		fire.start();
		var x = getX();
		var y = getY();
		return new Missile(x, y);
	}
//	@Override
//	public void draw(Graphics2D g) {
//		
////		g.fill(shape);
//		g.setColor(Color.WHITE);
//		g.drawRect(getX(), getY(), 25,25);
//	}
	
	public Rectangle2D getRectangle () {

		int x = getX();
		int y = getY();
		int w = 25;
		int h = 25;
		return new Rectangle2D.Double(x, y, w , h);
	}
	
}
