package objectGame;

public class HighScore {

	private int points = 0;
	
	
	public HighScore(int points) {
		this.points = points;
	}
	
	public void addScore() {
		points += 1;
	}
	
	public String getPoints() {
		if (points == 0) {
			return "0";
		}
		return Integer.toString(points);
	}
	
	public void reset() {
		points = 0;
	}
}
