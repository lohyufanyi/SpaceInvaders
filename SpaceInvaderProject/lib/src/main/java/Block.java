import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Block extends Drawable{
	private Rectangle2D shape;
	protected Block(int x, int y) {
		super(x, y);
		shape = new Rectangle2D.Double(x, y, 50, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.black);
		g.fill(shape);
	}
	
	public boolean collision(Rectangle2D object) {
		Rectangle2D result = new Rectangle2D.Double();
	
		if (shape.intersects(object.getX(), object.getY(), object.getWidth(), object.getHeight())) {
			System.out.println("hit");
			return true;
		}
		return false;
	}
}
