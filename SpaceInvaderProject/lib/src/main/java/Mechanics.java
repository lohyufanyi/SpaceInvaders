import java.awt.Graphics2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//   class sets initial state and handles setting up all the 
//   movements or anything done to multiple invader ships


public class Mechanics{
	private int points;
	private int index;
	private Invader[] invaders;
	public Mechanics (int pts) {
		points = pts;
		
	}
	
	public Invader[] getInitial() {
		int x = 80;
		int y = 65;
		invaders = new Invader[50];
		Invader invader = new InvaderTop(x, y);
		Invader invader2 = new InvaderTop(invader.getX()+35, y);
		Invader invader3 = new InvaderTop(invader2.getX()+35, y);
		Invader invader4 = new InvaderTop(invader3.getX()+35, y);
		Invader invader5 = new InvaderTop(invader4.getX()+35, y);
		Invader invader6 = new InvaderTop(invader5.getX()+35, y);
		Invader invader7 = new InvaderTop(invader6.getX()+35, y);
		Invader invader8 = new InvaderTop(invader7.getX()+35, y);
		Invader invader9 = new InvaderTop(invader8.getX()+35, y);
		Invader invader10 = new InvaderTop(invader9.getX()+35, y);
		y+=25;
		Invader invader11 = new InvaderMiddle(x, y);
		Invader invader12 = new InvaderMiddle(invader11.getX()+35, y);
		Invader invader13= new InvaderMiddle(invader12.getX()+35, y);
		Invader invader14 = new InvaderMiddle(invader13.getX()+35, y);
		Invader invader15 = new InvaderMiddle(invader14.getX()+35, y);
		Invader invader16 = new InvaderMiddle(invader15.getX()+35, y);
		Invader invader17 = new InvaderMiddle(invader16.getX()+35, y);
		Invader invader18 = new InvaderMiddle(invader17.getX()+35, y);
		Invader invader19 = new InvaderMiddle(invader18.getX()+35, y);
		Invader invader20 = new InvaderMiddle(invader19.getX()+35, y);
		y+=25;
		Invader invader21 = new InvaderMiddle(x, y);
		Invader invader22 = new InvaderMiddle(invader21.getX()+35, y);
		Invader invader23= new InvaderMiddle(invader22.getX()+35, y);
		Invader invader24 = new InvaderMiddle(invader23.getX()+35, y);
		Invader invader25 = new InvaderMiddle(invader24.getX()+35, y);
		Invader invader26 = new InvaderMiddle(invader25.getX()+35, y);
		Invader invader27 = new InvaderMiddle(invader26.getX()+35, y);
		Invader invader28 = new InvaderMiddle(invader27.getX()+35, y);
		Invader invader29 = new InvaderMiddle(invader28.getX()+35, y);
		Invader invader30 = new InvaderMiddle(invader29.getX()+35, y);
		y += 25;
		Invader invader31 = new InvaderBottom(x, y);
		Invader invader32 = new InvaderBottom(invader21.getX()+35, y);
		Invader invader33= new InvaderBottom(invader22.getX()+35, y);
		Invader invader34 = new InvaderBottom(invader23.getX()+35, y);
		Invader invader35 = new InvaderBottom(invader24.getX()+35, y);
		Invader invader36 = new InvaderBottom(invader25.getX()+35, y);
		Invader invader37 = new InvaderBottom(invader26.getX()+35, y);
		Invader invader38 = new InvaderBottom(invader27.getX()+35, y);
		Invader invader39 = new InvaderBottom(invader28.getX()+35, y);
		Invader invader40 = new InvaderBottom(invader29.getX()+35, y);
		y+=25;
		Invader invader41 = new InvaderBottom(x, y);
		Invader invader42 = new InvaderBottom(invader21.getX()+35, y);
		Invader invader43= new InvaderBottom(invader22.getX()+35, y);
		Invader invader44 = new InvaderBottom(invader23.getX()+35, y);
		Invader invader45 = new InvaderBottom(invader24.getX()+35, y);
		Invader invader46 = new InvaderBottom(invader25.getX()+35, y);
		Invader invader47 = new InvaderBottom(invader26.getX()+35, y);
		Invader invader48 = new InvaderBottom(invader27.getX()+35, y);
		Invader invader49 = new InvaderBottom(invader28.getX()+35, y);
		Invader invader50 = new InvaderBottom(invader29.getX()+35, y);
		invaders[0] = invader; invaders[1] = invader2; invaders[2] = invader3;invaders[3] = invader4;invaders[4] = invader5;invaders[5] = invader6;
		invaders[6] = invader7;invaders[7] = invader8;invaders[8] = invader9;invaders[9] = invader10; invaders[10] = invader11; invaders[11]=invader12;
		invaders[12]=invader13;invaders[13]=invader14;invaders[14]=invader15;invaders[15]=invader16;invaders[16]=invader17;invaders[17]=invader18;invaders[18]=invader19;
		invaders[19]=invader20;invaders[20]=invader21;invaders[21]=invader22;invaders[22]=invader23;invaders[23]=invader24;invaders[24]=invader25;
		invaders[25]=invader26;invaders[26]=invader27;invaders[27]=invader28; invaders[28]=invader29;invaders[29]=invader30;
		invaders[30]=invader31;invaders[31]=invader32;invaders[32]=invader33;invaders[33]=invader34;invaders[34]=invader35;invaders[35]=invader36;invaders[36]=invader37;
		invaders[37]=invader38;invaders[38]=invader39;invaders[39]=invader40;invaders[40]=invader41;invaders[41]=invader42;invaders[42]=invader43;
		invaders[43]=invader44;invaders[44]=invader45;invaders[45]=invader46; invaders[46]=invader47;invaders[47]=invader48;invaders[48]=invader49; invaders[49]=invader50;
	
		//make into for loop
	
	return invaders;
	}
	public void moveAllY(Invader[] s) {
		for (int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				continue;
			}
			s[i].moveVertically(12);
		}
	}	
	
	public boolean checkRightBounds(Invader[] s) {
		Invader inv = null;
		for (int i=0; i< s.length; i++) {
			if (s[i] == null) {
				continue;
			}
			inv = s[i];
			if (inv.getX() + 35 >= 480) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkLeftBounds(Invader[] s) {
		Invader inv = null;
		for (int i=0; i< s.length; i++) {
			if (s[i] == null) {
				continue;
			}
			inv = s[i];
			if (inv.getX() - 10 <= 0) {
				return true;
			}	
		}
		return false;
	}
	
	public void moveAllX(Invader[] s, int direction) {
		for (int i=0; i < s.length; i++) {
			if (s[i] == null) {
				continue;
			}
			s[i].moveHorizontally(direction);
		}
	}
	
	public void switchAllImgs(Invader[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				continue;
			}
			if (i <= 9) {
				InvaderTop t = (InvaderTop)s[i];
				t.switchImg();
			}
			if (i > 9 && i <= 29) {
				InvaderMiddle t = (InvaderMiddle)s[i];
				t.switchImg();
			}
			if (i > 29 && i <50) {
				InvaderBottom t = (InvaderBottom)s[i];
				t.switchImg();
			}
		}
	}
	
	public boolean checkAllHit(Invader[] s, Missile m) {
		
		for (int i = 0; i < s.length; i++) {
			if (s[i]==null) {
				continue;
			}	
			Invader temp = s[i];
			if (temp.isHit(m.getRectangle())) {			
				points += temp.getPoints();
				index = i;
				s[i] = null;
				invaders = s;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAllHitBase(Base base, Invader[] s) {
		for (int i = 0; i < s.length; i++) {
			if (s[i]==null) {
				continue;
			}	
			Invader temp = s[i];
			// should add if they are at the same y position instead
			if (temp.isHit(base.getDimensions())) {			
				return true; 
			}
		}
		
		return false;
	}
	
	public Invader[] getList() {
		return invaders;
	}
	
//	public Invader getRandIndex(Invader[] s) {
//		int lenCt = 0;
//		Invader last;
//		Invader [] fin = new Invader[9];
//		for (int i = 0; i < s.length; i++) {
//			last = s[i];
//			while (s[i + 10] != null) {
//				last = s[i + 10];
//				fin[i] = last;
//			}
//			
//		}
//		
//		
//		
//		
//	}
	
	public int getI() {
		return index;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean isNull(Invader[] a) {
		for (int i=0; i < a.length; i++) {
			if (a[i] == null) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
}