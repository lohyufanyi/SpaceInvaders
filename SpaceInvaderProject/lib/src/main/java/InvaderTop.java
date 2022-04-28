import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class InvaderTop extends Invader{
	protected Image img;
	
	private int points = points(30);
//	private Rectangle2D shape;
	InvaderTop(int x, int y) {
		super(x, y);
		img = getImage("img_invadertopA.gif");
		shape = new Rectangle2D.Double(x, y, 35, 35);
		
	}
	
	public void switchImg() {
		if (img == getImage("img_invaderhit.gif")) {
			return;
		}
		if (img.equals(getImage("img_invadertopA.gif"))) {
			img = getImage("img_invadertopB.gif");
		}
		else {
			img = getImage("img_invadertopA.gif");
		}
		
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		var x = getX();
		var y = getY();
		g.drawImage(img, x, y,null);
	}

	public Missile shoot() {
//		fire.setFramePosition(0);
//		fire.start();
		var x = getX();
		var y = getY();
		return new Missile(x, y);
	}
}
