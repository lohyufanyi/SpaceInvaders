import java.applet.AudioClip;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public abstract class Ship extends Drawable{
	protected String state = "h";
	protected Image img;
	protected Rectangle2D shape;
	protected int width = 20;
	protected int height = 20;
	
	protected Clip aud = getSound("aud_hit.wav");
	
	protected Ship(int x, int y) {
		super(x, y);
		shape = new Rectangle2D.Double(x, y, 25, 25);
		
		// TODO Auto-generated constructor stub
	}
	
	
	protected Clip getSound(String filename) {
		Clip clip = null;
		try {
		InputStream in = getClass().getResourceAsStream( filename );
		InputStream buf = new BufferedInputStream( in );
		AudioInputStream stream = AudioSystem.getAudioInputStream( buf );
		clip = AudioSystem.getClip();
		clip.open( stream );
		} 
		catch (UnsupportedAudioFileException |
				IOException | LineUnavailableException e) {
		e.printStackTrace();
		}
		return clip;
		}
	
	public boolean isHit(Rectangle2D object) {
		
		if (getDimensions().intersects(object)) {
//			img = getImage("img_basehit.gif");
			aud.setFramePosition(1);
			
			aud.start();
			return true;
		}
		return false;
	}
	
	public Rectangle2D getDimensions() {
		return new Rectangle2D.Double(getX(), getY(), 35, 35);
	}
	

}
