package Bilder;

import static TrexGame.GameScreen.SKY;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Sky extends Enviroment {

	
	public Sky() {
		image1 = Data.getResourceImage("data/moldTRSok.png");
		image2 = Data.getResourceImage("data/nothing.png");
		image3 = Data.getResourceImage("data/nothing.png");
		
		listImage = new ArrayList<BufferedImage>();
			for (int i = 0; i < 100; i++) {
				listImage.add( random());
				
			}
		}
	
	@Override 
	public void draw(Graphics g){
		for (int i = 0; i < listImage.size() -1; i++) {
			g.drawImage(listImage.get(i), (90*i +Xpos), (int) SKY -5, null);
			
		}							
	}	
}
	
	


