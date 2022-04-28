import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;


public abstract class Drawable {
	private int x = 0;
	private int y = 0;
	private int height;
	private int width;
	
	// add height and width
	protected Drawable(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public abstract void draw(Graphics2D g);
	
	public void moveHorizontally(int pixels) {
		x += pixels;
	}
	
	public void moveVertically(int pixels) {
		y += pixels;
	}
	
	public void setWidth(int w) {
		this.width = w;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	protected Image getImage(String filename) {
		URL url = getClass().getResource( filename );
		ImageIcon icon = new ImageIcon( url );
		return icon.getImage();
	}
}
