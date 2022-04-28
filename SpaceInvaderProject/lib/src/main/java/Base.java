import java.awt.Graphics2D;
import java.awt.Image;

import javax.sound.sampled.Clip;

public class Base extends Ship{
	protected Image img;
	protected Image imgHit;
	protected int width = 35;
	protected int height = 35;
	
	
	private Clip fire = getSound("aud_basefire.wav");
	
	public Base(int x, int y) {
		super(x, y);
		img = getImage("img_base.gif");
		setWidth(40);
		setHeight(40);
	}

	public void getDestroyed() {
		img = getImage("img_basehit.gif");
		
	}
	
	@Override
	public void draw(Graphics2D g) {
		var x = getX();
		var y = getY();
		g.drawImage(img, x, y, null);
	}
	
	public Missile shoot() {
		fire.setFramePosition(0);
		fire.start();
		var x = getX();
		var y = getY();
		return new Missile(x, y);
	}
	
}
