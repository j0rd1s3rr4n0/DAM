import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private int Y;
	private int WITH = 100;
	private int HEIGHT = 20;
	
	
	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y-50;
	}

	public int getWITH() {
		return WITH;
	}

	public void setWITH(int wITH) {
		WITH = wITH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	int x = WITH+50;
	int xa = 0;
	private Game game;

	public Racquet(Game game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH/2)
			x = x + xa;
	}

	public void paint(Graphics2D g,String Score) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, Y, WITH, HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		g.drawString(Score, x+10, Y+18);
		
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if(!game.isGamestarted()) {
			game.setScore(0);
			game.setGamestarted(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = (int)-game.speed;System.out.println("PRESSED LEFT ARROW KEY");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = (int)game.speed;
			System.out.println("PRESSED RIGHT ARROW KEY");
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			xa = (int)-game.speed;
			System.out.println("PRESSED A KEY");
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			xa = (int)game.speed;
			System.out.println("PRESSED D ARROW KEY");
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}