import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SpaceInvaders extends JFrame {
	protected boolean win = false;
	protected Timer timer;
	protected int points1=0;
	protected boolean gameOver=false;
	public SpaceInvaders() {
		
		setTitle("Space Invaders");
		Container con = this.getContentPane();
		con.setBackground(Color.black);
		JLabel scoreP = new JLabel("Score: " +points1);
		JPanel p1 = new JPanel(new BorderLayout());
		p1.setBackground(Color.BLACK);
		add(p1, BorderLayout.NORTH);
		Font myFont = new Font("Serif", Font.BOLD, 18);
		scoreP.setFont(myFont);
		scoreP.setForeground(Color.GREEN);
		p1.add(scoreP);
		con.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar( menuBar); 
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");
		
		menuBar.add(game);
		menuBar.add(help);
		
//		JPanel p = new Panel();
//		add(p);
//		p.setVisible(true);
		
		//add event listeners
		
		JMenuItem about = help.add("About...");
		JMenuItem newGame = game.add("New Game");
		
		game.addSeparator();
		
		JMenuItem pause = game.add("Pause");
		JMenuItem resume = game.add("Resume");
		
		game.addSeparator();
		
		JMenuItem quit = game.add("Quit");
		
		add(new JPanel() {
			private Mechanics m = new Mechanics(0);
			private Invader[] invaders = m.getInitial();
			private int dirSwitch = 20;
			private int pulse = 0;
			private int lim = 40;
			private boolean left;
			private boolean right;
			
			protected Missile missile;
			protected Missile invaderMissile;
			protected Missile invaderMissile2;
			protected Missile invaderMissile3;
			
			protected Base base;
			private Mystery mysteryShip;
			private int mysteryMove = 5;

			{
				this.setBackground(Color.BLACK);
				setFocusable(true);
				addKeyListener(new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						var key = e.getKeyCode();
						switch (key) {
							case KeyEvent.VK_SPACE : if (missile == null) missile = base.shoot(); break; // add event details (missile pixel + audio)
							case KeyEvent.VK_RIGHT : right=true; break;
							case KeyEvent.VK_LEFT : left=true; break;
							default : return;
						}
						repaint();
					}

					@Override
					public void keyReleased(KeyEvent e) {
						var key = e.getKeyCode();
						switch (key) {		
							case KeyEvent.VK_RIGHT : right=false; break;
							case KeyEvent.VK_LEFT : left=false; break;
						}  
					}
				});

				base = new Base(230, 350);
				
				missile = null;
				// add time listener here
				
				Timer timer = new Timer(45,  e-> {
					if (mysteryShip == null && m.isNull(invaders)) {
						gameOver = true;
						
						repaint();
						return;
					}
					if (gameOver == true) {
						
						missile  = new Missile(700, 800);
						repaint();
						return;
					}
					if (m.checkAllHitBase(base, invaders)) {
						base.getDestroyed();
						gameOver = true;
						repaint();
						return;
					}
					var rand4 = Math.random(); 
						if (rand4 >= .997 && mysteryShip == null) {
							mysteryShip = new Mystery(230, 30);
							var rand5 = Math.random();
							if (rand5 >= .5) {
								mysteryMove = -5;
							}
							else {
								mysteryMove = 5;
							}
						}
					if (mysteryShip != null) {
							
						if (mysteryShip.getX() >= 450) {
							mysteryMove = -5;
						}
						if (mysteryShip.getX() <= 0) {
							mysteryMove = 5;
						}
						if (pulse % 2==0) {
							mysteryShip.moveHorizontally(mysteryMove);
						}
					}
					if (left && base.getX() > 0) {
						base.moveHorizontally(-5); 
					}
					if (right && base.getX() < 460)  {
						base.moveHorizontally(5);
					}
					
					if (missile != null) {
						if(m.checkAllHit(invaders,missile)) {						
							missile = null;
							points1 = m.getPoints();
							scoreP.setText("Score: " + points1);
							invaders = m.getList();    
							repaint();
						
							return;
						}
						else {
							missile.moveVertically(-5);
						}
						if (missile.getY() < 0) {
							missile = null;
							return;
						}
						if (mysteryShip != null) {	
							if (mysteryShip.isHit(missile.getRectangle())) {	
								points1 += mysteryShip.getRandPoints();
								scoreP.setText("Score: " + points1);
								mysteryShip = null;
								missile = null;
								return;
							}
						}
							
							if(m.checkAllHit(invaders,missile)) {
								
								missile = null;
								points1 = m.getPoints();
								scoreP.setText("Score: " + points1);
								invaders = m.getList();  
								repaint();
								return;
							}
						}
						
								
					
					if (pulse == lim) {
						
						pulse = 0;
						if (m.checkRightBounds(invaders)) { 
							m.moveAllY(invaders);
							
							dirSwitch = -20;
							if (lim >= 3)
								lim *= .9;
							else {
								
							}
						}
						
					    if (m.checkLeftBounds(invaders)) { 
							m.moveAllY(invaders);
							
							dirSwitch = 20;
							if (lim >=3)
								lim *= .9;
							else {
								
							}
						}
						m.switchAllImgs(invaders);
						m.moveAllX(invaders, dirSwitch);
						
					}
					
					
					
					// move invader missile and make sure there's 
//					   no more than three
					
					if (invaderMissile != null) {
						if (base.isHit(invaderMissile.getRectangle())) {
							base.getDestroyed();
							invaderMissile = null;
							gameOver = true;
							return;
						}
						if (invaderMissile.getY() >= 500) {
							invaderMissile =  null;
						}
						else {
							if (pulse%2==0)
								invaderMissile.moveVertically(5);
						}
					}
					if (invaderMissile == null ) {
						var random = Math.random();
						var rand = new Random();
						Invader x = invaders[rand.nextInt(50)];
						if (random > .20 && x != null) { // -> 5% of the time
//							m.getRandIndex(invaders).shoot();
							invaderMissile = x.shoot();
						}
					}
					if (invaderMissile2 != null) {
						if (base.isHit(invaderMissile2.getRectangle())) {
							base.getDestroyed();
							invaderMissile2=null;
							gameOver = true;
							return;
						}
						if (invaderMissile2.getY() >= 500) {
							invaderMissile2 =  null;
						}
						else {
							if (pulse%2==0)
								invaderMissile2.moveVertically(5);
						}
					}
					if (invaderMissile2 == null ) {
						var random = Math.random();
						var rand2 = new Random();
						Invader y = invaders[rand2.nextInt(50)];
						if (random > .20 && y != null) { // -> 5% of the time
//							m.getRandIndex(invaders).shoot();
							invaderMissile2 = y.shoot();
						}
					}
					if (invaderMissile3 != null) {
						if (base.isHit(invaderMissile3.getRectangle())) {
							base.getDestroyed();
							invaderMissile3=null;
							gameOver = true;
							return;
						}
						if (invaderMissile3.getY() >= 500) {
							invaderMissile3 =  null;
						}
						else {
							if (pulse%2==0)
								invaderMissile3.moveVertically(5);
						}
					}
					if (invaderMissile3 == null ) {
						var random = Math.random();
						var rand3 = new Random();
						Invader z = invaders[rand3.nextInt(50)];
						if (random > .20 && z != null) { // -> 80% of the time
//							m.getRandIndex(invaders).shoot();
							invaderMissile3 = z.shoot();
						}
					}
					pulse++;
					repaint();
//					
						});
				
				pause.addActionListener(p -> {
					timer.stop();
					
				});
				
				resume.addActionListener(r -> {
					timer.start();
					
				});
				
				newGame.addActionListener(n -> {
					dispose();
					SpaceInvaders m = new SpaceInvaders();
					m.setVisible(true);
					
				});
				timer.start();
				
				
				
				
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						timer.stop();
					}
						
				});
				
			}
		
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				base.draw(g2);
				if (missile != null) {
					missile.draw(g2);
				}
				for (Invader i : invaders) {
					if (i == null) {
						continue;
					}
					i.draw(g2);
				}
				if (invaderMissile != null) {
					invaderMissile.draw(g2);
				}
				if (invaderMissile2 != null) {
					invaderMissile2.draw(g2);
				}
				if (invaderMissile3 != null) {
					invaderMissile3.draw(g2);
				}
				if (mysteryShip != null) {
					
					mysteryShip.draw(g2);
				}
				
				if (gameOver != false) {		
					Font font = new Font("Times New Roman", Font.BOLD, 50);
					g.setFont(font);
					g.setColor(Color.GREEN);
					g.drawString("Game Over", 120, 45);
				}
				
//				if (win != false) {
//					Font font = new Font("Times New Roman", Font.BOLD, 50);
//					g2.setFont(font);
//					g.setColor(Color.GREEN);
//					g.drawString("You Win", 120, 45);
//				}
			}
				
		});
		setSize(500, 450);
		
		about.addActionListener(e -> {
			JOptionPane.showMessageDialog(SpaceInvaders.this, "______________\n"
					+ "Space Invaders\nby Loh Yufanyi\n______________");
			
		});
		quit.addActionListener(e -> {
			int response = JOptionPane.showConfirmDialog(SpaceInvaders.this, "Are you a quitter?");
			if (response == JOptionPane.OK_OPTION) {
				dispose();
			}
		});
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public static void main(String [] args) {
		
		JFrame k = new SpaceInvaders();
		k.setVisible(true);
		
	}
}

 





