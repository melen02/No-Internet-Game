package objectGame;

import static TrexGame.GameScreen.GROUND;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Bilder.Data;

import static TrexGame.GameScreen.GRAVITY;

public class Gubbe implements Figures{
	private float x = 25;
	static float y = GROUND;
	private float speedY = 0;
	private BufferedImage cherecterImage;
//	private long lastImageSwitchTime = 0;
	
	public Gubbe() {
		setCharacterImage(Data.getResourceImage(("data/gubbeRun1.png")));
	}
	
	public void update() {
		if ( y >= GROUND - getCherecterImage().getHeight()) {
			speedY = 0;
			y = GROUND -getCherecterImage().getHeight();
		} else {
			speedY+=GRAVITY;
			y+=speedY;
		}
	}
	
	// Konstigt med animationen, bilden hoppar upp efter byte
//	public void Animation(String a, String b) {
//	    long currentTime = System.currentTimeMillis();
//	    if (currentTime - lastImageSwitchTime >= 950) {
//	        lastImageSwitchTime = currentTime;
//	        if ((currentTime / 1000) % 2 == 0) {
//	        	setCharacterImage(Data.getResourceImage(a));
//	        } else {
//	        	setCharacterImage(Data.getResourceImage(b));
//	        }
//	        
//	    }
//	}
	
	public void draw(Graphics g) {
//		Animation("data/gubbeRun1.png", "data/gubbeRun1.png");
		g.drawImage(getCherecterImage(), (int) x, (int) y, null);
	}
	
	public void jump() {
		speedY = -5;
		y += speedY;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	public static float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}

	public BufferedImage getCherecterImage() {
		return cherecterImage;
	}

	public void setCharacterImage(BufferedImage cherecterImage) {
		this.cherecterImage = cherecterImage;
	}
	
	public boolean detectCollision(Cactus c) {
		if (this.getX()+10 == c.getX() && this.getY() >= c.getImageEdgeY()) {
			return true;
		}
		return false;
	}
}
	

