package TrexGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import objectGame.Gubbe;

public class GameWindow extends JFrame {
	
	private final int WIDTH = 650;
	private final int HEIGHT = 200;
	private GameScreen gameScreen;
	
	public GameWindow() {
		super("No Internet :C");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color. WHITE); 
		gameScreen = new GameScreen();
		add(gameScreen);
		addKeyListener(gameScreen);
	}
	
	
	public void startGame() {
		gameScreen.startGame();
	}
	
	public static void main(String args[]) {
		GameWindow gw = new GameWindow();
		gw.setVisible(true);
		gw.startGame();

	}
}
