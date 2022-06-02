import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.color.*;
import org.json.simple.*;

import java.util.Timer;

/*
888888    db    .dP"Y8 88  dP 88     88 .dP"Y8 888888 
  88     dPYb   `Ybo." 88odP  88     88 `Ybo."   88   
  88    dP__Yb  o.`Y8b 88"Yb  88  .o 88 o.`Y8b   88   
  88   dP""""Yb 8bodP' 88  Yb 88ood8 88 8bodP'   88   
  
[-] LADRILLO ROJO CAER AL MORIR
[-] ORDENAR LISTA SCOREBOARD POR PUNTUACIÓN

*/
@SuppressWarnings("serial")
public class Game extends JPanel {	
	private static String USERNAME = null;
	public static boolean ISLIVERAQUET;
	static int HEIGHT = 600; // 960
	static int WITH = 400; // 720
	
	private static int SCORE = 0;
	public static double speed = 1;
	public int NIVEL = 0;
	public int VIDAS = 3;
	public ArrayList<ladrillo> pared_ladrillos = new ArrayList<ladrillo>();
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Timer tiempo = new Timer();
	private static boolean gamestarted = false;
	public static boolean VIU = false;
	static wall pared = new wall(HEIGHT,WITH);
	public static boolean blocksvius;
	public static int ladrillos_size = 0;
	private String[] usernames;
	private int[] points;
	public static int BONUS_LEVEL = 100;
	public static int BONUS_KICK_BLOCK = 10;
	public static int BONUS_BREAK_BLOCK = 50;
	public static int AVANCE_RED_BLOCK = 10;
	public static double VELOCIDADJUEGO = 1;
	public static int RESTAPUNTOS_POR_REVOTE = 5;
	public static boolean collider = true; // ACTIVAR PARA VER COLLIDER WALL
	public String LEVELED;
	
	public static int getScore() {
		return SCORE;
	}
	
	public Game(int h) {
		racquet.setY(h-((h/3)/3));
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	private void move() throws InterruptedException {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.GRAY);
		g2d.fillRect(0, 0, WIDTH+400, HEIGHT-80);
		pared.paint(g2d, pared_ladrillos,NIVEL);
		ball.paint(g2d);
		racquet.paint(g2d,String.valueOf(getScore()));
		g.setColor(Color.BLACK);
		/**/
		if(ISLIVERAQUET==false || isGamestarted()==false) {
			g.setFont(new Font("Verdana", Font.BOLD, 20));
			g.drawString("PRESS ANY KEY TO PLAY", WIDTH+60, HEIGHT/2);
		}
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		if(NIVEL > 10) {
			LEVELED = "MAX";
		}else {
			LEVELED = String.valueOf(NIVEL);
		}
		int ALTURA_EXTRA = 50;
		g.setColor(Color.BLUE);
		g.drawString("NIVEL: "+LEVELED, WIDTH+10, HEIGHT-ALTURA_EXTRA);
		g.setColor(Color.RED);
		g.drawString("VIDAS: "+String.valueOf(VIDAS), WIDTH+130*2, HEIGHT-ALTURA_EXTRA);
		/**/
		

	}
	
	public void gameOver() {
		
		SCOREBOARD scoreboard = new SCOREBOARD(new String[0], new int[0],this.HEIGHT,this.WIDTH);
		JFrame frame2 = new JFrame("SCOREBOARD ARKANOID");
		frame2.add(scoreboard);
		frame2.setSize(WITH, HEIGHT);
		frame2.setVisible(true);
		frame2.setLocation(360, 240);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(frame2.HIDE_ON_CLOSE);
		
		scoreboard.pintar(this.usernames, this.points);
		scoreboard.repaint();
		int input = JOptionPane.showOptionDialog(this, "CLOSE GAME","GAME OVER",JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
		if(input == JOptionPane.OK_OPTION)
		{
			System.exit(ABORT);
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Game game = new Game(HEIGHT);
		SCOREBOARD_READER datos = new SCOREBOARD_READER("scoreboard.json");
		temps timer =new temps(); //Intancio la clase
		timer.start(); //Ejecuto el metodo run del Thread
		
		game.VIU = true;
		String printinglogs = ("  ____       _       _   _               _                    \r\n"
		+ " |  _ \\ _ __(_)_ __ | |_(_)_ __   __ _  | |    ___   __ _ ___ \r\n"
		+ " | |_) | '__| | '_ \\| __| | '_ \\ / _` | | |   / _ \\ / _` / __|\r\n"
		+ " |  __/| |  | | | | | |_| | | | | (_| | | |__| (_) | (_| \\__ \\\r\n"
		+ " |_|   |_|  |_|_| |_|\\__|_|_| |_|\\__, | |_____\\___/ \\__, |___/\r\n"
		+ "                                 |___/              |___/     ");
		System.out.println(printinglogs);
		do {
			do {USERNAME = JOptionPane.showInputDialog("SCOREBOARD USERNAME");
			}while(USERNAME == null);
		}while(USERNAME.length() == 0);
		
		JFrame frame = new JFrame("ARKANOID @j0rd1s3rr4n0");
		frame.add(game);
		frame.setSize(WITH, HEIGHT);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ISLIVERAQUET = true;
		game.VIDAS = 3;
		game.setNIVEL(11);
		game.setScore(0);
		while (true) {
			
			blocksvius = true;
			if(game.NIVEL>10) { game.NIVEL-=1;}
			if(game.isGamestarted()) {
				game.NIVEL++;
			}
			pared.crearTablero(game.NIVEL,game.pared_ladrillos);

			game.blocksvius=true;
			do{

				game.move();
				game.repaint();
				
				int r = -1;
				for(int i = 0; i < game.pared_ladrillos.size(); i++) {
					if(game.pared_ladrillos.get(i).vides <= 0) r = i;	
				}
				
				if(r != -1) {
					if(game.pared_ladrillos.get(r).muriendo == false) {
						game.removeBlock(r);
					}else {
						game.pared_ladrillos.get(r).morir(r);
					}
				}
				Thread.sleep((long) (3-VELOCIDADJUEGO));
				
				if(game.ladrillos_size==0) {game.blocksvius = false;}
				
			}while(VIU == true && game.blocksvius == true);
			game.VELOCIDADJUEGO = 0;
			if(game.NIVEL>0) {
				game.setScore(game.getScore()+BONUS_LEVEL);
			}
			datos.saveUser(Game.USERNAME,game.getScore());
			game.ball.x = game.WITH/2;
			game.ball.y = game.HEIGHT/3;
			if(game.VIDAS <=0) {game.VIU = false;}
			
			datos.saveUser(Game.USERNAME,game.getScore());
			if(game.VIU == false) {
				game.usernames = datos.getusers();
				game.points = new int[game.usernames.length];
				for(int i = 0; i < game.usernames.length;i++) {game.points[i] = datos.getpoints(game.usernames[i]);}
				game.gameOver();
				//game.viu = true;game.blocksvius=true;
				break;
				}
		}
	}

	

	public static boolean isISLIVERAQUET() {
		return ISLIVERAQUET;
	}

	public static void setISLIVERAQUET(boolean iSLIVERAQUET) {
		ISLIVERAQUET = iSLIVERAQUET;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public static int getWITH() {
		return WITH;
	}

	public static void setWITH(int wITH) {
		WITH = wITH;
	}

	public static double getSpeed() {
		return speed;
	}

	public static void setSpeed(double speed) {
		Game.speed = speed;
	}

	public int getNIVEL() {
		return NIVEL;
	}

	public void setNIVEL(int nIVEL) {
		NIVEL = nIVEL;
	}

	public int getVides() {
		return VIDAS;
	}

	public void setVides(int vides) {
		this.VIDAS = vides;
	}

	public ArrayList<ladrillo> getPared_ladrillos() {
		return pared_ladrillos;
	}

	public void setPared_ladrillos(ArrayList<ladrillo> pared_ladrillos) {
		this.pared_ladrillos = pared_ladrillos;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Racquet getRacquet() {
		return racquet;
	}

	public void setRacquet(Racquet racquet) {
		this.racquet = racquet;
	}

	public Timer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Timer tiempo) {
		this.tiempo = tiempo;
	}

	public static wall getPared() {
		return pared;
	}

	public static void setPared(wall pared) {
		Game.pared = pared;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public static void setScore(int s) {
		SCORE = s;
	}
	public static void sc(int s) {
		Game.setScore(s);
	}

	public void removeBlock(int i) {
		if(pared_ladrillos.get(i) instanceof vermell) {
			//pared_ladrillos.get(i).morir(i);
			pared_ladrillos.remove(i);
		}else {
			pared_ladrillos.get(i).morir(i);
			pared_ladrillos.remove(i);
		}
	}

	public static boolean isGamestarted() {
		return gamestarted;
	}

	public static void setGamestarted(boolean gamestarted) {
		Game.gamestarted = gamestarted;
	}

	public static boolean isBlocksvius() {
		return blocksvius;
	}

	public static void setBlocksvius(boolean blocksvius) {
		Game.blocksvius = blocksvius;
	}

	public static int getLadrillos_size() {
		return ladrillos_size;
	}

	public static void setLadrillos_size(int ladrillos_size) {
		Game.ladrillos_size = ladrillos_size;
	}
	// DESTRUEIX EL BLOCK
	/*
	public static void destroy(int i) {
		pared_ladrillos.remove(i);
		
	}*/
	
	
}
