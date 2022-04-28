import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

public class InvaderMiddle extends Invader{
	private Image img = getImage("img_invadermiddleA.gif");
	private int points = points(20);
//	private Rectangle2D shape;
	
	protected InvaderMiddle(int x, int y) {
		super(x, y);
		shape = new Rectangle2D.Double(x, y, 35, 35);

		
		// TODO Auto-generated constructor stub
	}
	
	public void switchImg() {
		if (img == getImage("img_invaderhit.gif") ) {
			return;
		}
		if (img == getImage("img_invadermiddleA.gif")) {
			img = getImage("img_invadermiddleB.gif");
		}
		else {
			img = getImage("img_invadermiddleA.gif");
		}
	}

	@Override
	public void draw(Graphics2D g) {
		var x = getX();
		var y = getY();
		g.drawImage(img, x, y, null);
	}

	public Missile shoot() {
//		fire.setFramePosition(0);
//		fire.start();
		var x = getX();
		var y = getY();
		return new Missile(x, y);
	}

}
