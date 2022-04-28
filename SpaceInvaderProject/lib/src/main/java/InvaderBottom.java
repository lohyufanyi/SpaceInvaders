import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

public class InvaderBottom extends Invader{
	private int points = points(10);
	private Image img = getImage("img_invaderbottomA.gif");
//	private Rectangle2D shape;
	protected InvaderBottom(int x, int y) {
		super(x, y);
		shape = new Rectangle2D.Double(x, y, 35, 35);
		
	}

	public void switchImg() {
		if (img == getImage("img_invaderhit.gif")) {
			System.out.println("hit image");
			return;
		}
		if (img == getImage("img_invaderbottomA.gif")) {
			img = getImage("img_invaderbottomB.gif");
		}
		else {
			img = getImage("img_invaderbottomA.gif");
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
