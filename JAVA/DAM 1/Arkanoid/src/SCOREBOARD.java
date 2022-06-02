import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class SCOREBOARD extends JPanel{
	private String[] usernames ;
	private int[] points;
	public int HEIGHT;
	public int WIDTH;
		
	public SCOREBOARD(String[] User,int[] points,int HEIGHT,int WIDTH) {
		this.usernames = User;
		this.points = points;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}
	public void paint(Graphics g) {	
		try{
			g.fillRect(-1, -1, Game.HEIGHT, Game.WIDTH);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Verdana", Font.BOLD, 40));
			g.drawString("SCOREBOARD", 30, 30);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
			if(usernames.length>-1) {
				for(int i = 0; i < usernames.length; i++) {
					try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
					g.setColor(Color.RED);
					g.setFont(new Font("Verdana", Font.BOLD, 16));
					if((i+1) < 10) {
						g.drawString("[0"+(i+1)+"]  "+usernames[i],10, 70+(30*i));
						g.drawString("PTS: "+points[i], 160, 70+(30*i));
					}else {
						g.drawString("["+(i+1)+"]  "+usernames[i],10, 70+(30*i));
						g.drawString("PTS: "+points[i], 160, 70+(30*i));
					}
					//g.drawString(i+1+")"+usernames[i]+" : "+points[i], 30, 70+(30*i));
				}
			}}catch(Exception e) {e.getStackTrace();}
		
	}
	public void OrdenarPorPuntos() {
		
	}
	public void pintar(String[] User,int[] points) {
		this.usernames = User;
		this.points = points;
		try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
		repaint();
	}


}
