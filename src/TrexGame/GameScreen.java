package TrexGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Bilder.Land;
import Bilder.Sky;
import objectGame.Gubbe;
import objectGame.HighScore;
import objectGame.Cactus;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends JPanel  implements Runnable, KeyListener{
	
	public static final float GRAVITY =  0.2f;
	public static final float SKY = 5;
	public static final float GROUND =  130;
	
	private HighScore highscore;
	private Gubbe gubb;
	private Thread thread;
	private Land land; 
	private Sky sky;
	private Cactus cactus;
	private JLabel restart;
	private JLabel gameOver;
	
	//Konstruktorn
	public GameScreen() {
		thread = new Thread(this);
		gubb = new Gubbe();
		land = new Land();
		sky = new Sky();
		cactus = new Cactus();
		highscore = new HighScore(0);
		restart = new JLabel();
		gameOver = new JLabel();
	}
	
	public void startGame() {
		thread.start();
	}

	public void run() {
		while (true) {
			try {
				updateAll();
				if (gubb.detectCollision(cactus)) {
					gameOverText();	
				}
				if (cactus.getX() < -35) {
					cactus.setX(650);
				}
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateAll() {
		gubb.update();
		land.update();
		sky.update();
		cactus.update();
		highscore.addScore();
	}

	private void gameOverText() throws InterruptedException {
		restart.setText("Press ENTER to restart");
		restart.setBounds(325, 45, 200,50);
		gameOver.setText("GAME OVER!!");
		gameOver.setBounds(325, 33, 200,50);
		add(restart);
		add(gameOver);
		repaint();
		Thread.sleep(20000);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(0, (int) GROUND, 650, (int) GROUND);
		g.drawString(highscore.getPoints() + ":"  +   "points", 325, 40);
		gubb.draw(g);
		land.draw(g);
		sky.draw(g);
		cactus.draw(g);
	}
	public void restartGame() {
		remove(gameOver);
		remove(restart);
		cactus.reset();
		highscore.reset();
		thread.interrupt();
	}
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE && Gubbe.getY() == 78 ) {
			gubb.jump();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			restartGame();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
