package Bilder;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static TrexGame.GameScreen.GROUND;

public class Land extends Enviroment {
	
	
	public Land( ) {
		image1 = Data.getResourceImage("data/land1TRSok.png");
		image2 = Data.getResourceImage("data/land2TRSok.png");
		image3 = Data.getResourceImage("data/land3TRSok.png");
		
		listImage = new ArrayList<BufferedImage>();
		for (int i =0;  i < 100; i++) {
			listImage.add( random());
		}
		
	}
}
