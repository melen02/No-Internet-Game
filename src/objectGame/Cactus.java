package objectGame;

import static TrexGame.GameScreen.GROUND;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Bilder.Data;

public class Cactus implements Figures {
	private float x = 650;
	private float speedX = 0;
	private float y = GROUND - 47;
	private float cactusSpeed = -5;
	private BufferedImage cherecterImage;
	
	
	public Cactus() {
		cherecterImage = Data.getResourceImage( "data/cactusOP.png");
	}
	
	
//	public  void Animation(String a, String b){
//		if (java.lang.System.currentTimeMillis() % 10 == 0) {
//			return;
//		}else if (java.lang.System.currentTimeMillis() %20  == 0) {
//			return;
//		}
//		return;
//	}

	public void update() {
		speedX = cactusSpeed;
		x += speedX;	
	}

	public void draw(Graphics g) {
		g.drawImage(cherecterImage, (int) x, (int) y, null);	
	}
	
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float newX) {
		x = newX;
	}
	
	public BufferedImage getCherecterImage() {
		return cherecterImage;
	}
	
	public float getImageEdgeY() {
		return y - (getCherecterImage().getHeight()/2);
	}
	
	public void reset() {
		x = 650;
	}
}



	

	


