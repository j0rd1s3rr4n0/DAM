import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.color.*;
public class Ball {
	private static final int DIAMETER = 30;
	private static final Color Color = null;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	public int IZQUIERDA = 1;
	public int DERECHA = 2;
	public int TECHO = 3;
	private Game game;

	public Ball(Game game) {
		this.x = game.WITH/2;
		this.y = game.HEIGHT/3;
		this.game = game;
		
	}
	public void RestarPuntosRebote(int POSICION_REBOTE) {
		if(game.getScore()>1000) {
			game.setScore(game.getScore()-Game.RESTAPUNTOS_POR_REVOTE*game.getNIVEL());
			switch(POSICION_REBOTE) {
				case 1:System.err.println("-5 PTS - REBOTE PARED DERECHA");
				break;
				case 2:System.err.println("-5 PTS - REBOTE PARED IZQUEIRDA");
				break;
				case 3:System.err.println("-5 PTS - REBOTE TECHO");
				break;
			}
			
		}
		
	}
	
	
	void move() {
		boolean changeDirection = true;
		if (x + xa < 0) {
			xa =(int) game.speed;
			RestarPuntosRebote(IZQUIERDA);
		}
		else if (x + xa > game.getWidth() - DIAMETER) {
			xa = (int)-game.speed;
			RestarPuntosRebote(DERECHA);
			
		}
		else if (y + ya < 0) {
			ya = (int)game.speed;
			RestarPuntosRebote(TECHO);
			
			
			
		}
		else if (y + ya > game.getHeight() - DIAMETER) {
			//TODO AQUI ESTABLECER GAMEOVER
			if(game.VIDAS<1) {
				game.VIU = false;
			}else {
				game.VIDAS-=1;
				this.x = game.WITH/2;
				this.y = game.HEIGHT/3;
				//this.ya = -this.ya;
			}
		}
		else if (collisionRaquet()){
			ya = (int)-game.speed;
			y = game.racquet.getTopY() - DIAMETER;
		}
		
		if (game.ball.getBounds().intersects(game.pared.getBounds())){
			for (int i = 0; i < game.pared_ladrillos.size(); i++) {
				ladrillo brick = (ladrillo) game.pared_ladrillos.get(i);
				if (game.ball.getBounds().intersects(brick.getBounds())) {
					game.setScore(game.getScore()+10);		
					brick.vides-=1;
										
					// XPILOTA + DIAMETRE >= XBRICK && XPOLOTA +DIAMETRE => BRICKX+BRICKWITH // [] /  [________]  
					//if(this.x + this.DIAMETER > brick.getX() && this.x < brick.getX() + brick.getWith()){
					
					Rectangle brickR = brick.getBounds(); 
					
					/*if ((x + ((DIAMETER/3)*2) + xa > game.pared_ladrillos.get(i).getX()) && (x + xa < game.pared_ladrillos.get(i).getX() + game.pared_ladrillos.get(i).getWith())
					          && (y + ((DIAMETER/3)*2) > game.pared_ladrillos.get(i).getY()) && (y < game.pared_ladrillos.get(i).getY() + game.pared_ladrillos.get(i).getHeight())) {
						this.xa = -this.xa;
					     }
					      // ESQUERRA I DRETA
					      else if ((x + ((DIAMETER/3)*2) > game.pared_ladrillos.get(i).getX()) && (x < game.pared_ladrillos.get(i).getX() + game.pared_ladrillos.get(i).getWith())
					          && (y + ((DIAMETER/3)*2) + ya > game.pared_ladrillos.get(i).getY()) && (y + ya < game.pared_ladrillos.get(i).getY() + game.pared_ladrillos.get(i).getHeight())) {
					    	  this.ya = -this.ya;
					    	}*/
					
						if(this.x + this.DIAMETER > brickR.getX() && this.x < brickR.getX() + brickR.getWidth()){
						    this.ya = -this.ya;
						}else{
						    this.xa = -this.xa;

					}
				}
			}
		}
		
		changeDirection = true;
		this.x = this.x + this.xa;
		this.y = this.y + this.ya;
	}

	private boolean collisionRaquet() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	@SuppressWarnings("static-access")
	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}