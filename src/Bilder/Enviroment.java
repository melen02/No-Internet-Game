package Bilder;

import static TrexGame.GameScreen.GROUND;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


abstract class Enviroment {
		
	List<BufferedImage> listImage; 
	BufferedImage image1, image2, image3;
	int Xpos = 0;
	
	public BufferedImage random() {
		double i = Math.random() * 3;
		int y = (int) i;
		if (y == 0) {
			return image1;
		}else if (y ==1) {
			return image2;
		}else {
			return image3;
		}		
	}
	
	public int getXpos() {
		return Xpos;
	}
	
	public void update() {
		Xpos -=4;
	}
	
	public void draw(Graphics g){
		for (int i = 0; i < listImage.size() -1; i++) {
			g.drawImage(listImage.get(i), (90*i +Xpos), (int) GROUND -9, null);
		}							
	}
}