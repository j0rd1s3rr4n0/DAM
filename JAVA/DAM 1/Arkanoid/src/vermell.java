import java.awt.Color;
import java.awt.Graphics2D;

public class vermell  extends ladrillo {
	private static boolean MovingRed = false;
	public vermell(int x, int y, int with, int height, int vides) {
		super(x, y, with, height, vides);
	}	
	@Override
	void morir(int i) {
		Game.setScore(Game.getScore()+Game.BONUS_BREAK_BLOCK);
		vermell.MoveDown(i);
		System.out.println("RED BLOCK DESTROYED");
		
	}
	public static void MoveDown(int i) {
		Y=Y+50;

	}
	@Override
	void paint(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillRect(X, Y, with, height);
	}

}
