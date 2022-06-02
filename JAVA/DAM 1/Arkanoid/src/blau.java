import java.awt.Color;
import java.awt.Graphics2D;

public class blau  extends ladrillo {

	public blau(int x, int y, int with, int height, int vides) {
		super(x, y, with, height, vides);
	}	
	@Override
	void morir(int i) {
		Game.setScore(Game.getScore()+Game.BONUS_BREAK_BLOCK);
		System.out.println("BLUE BLOCK DESTROYED");
		System.out.println("BOOST SPEED!");
	 	temps.BoostSpeed();
		
	}
	@Override
	void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fillRect(X, Y, with, height);
	}
}
