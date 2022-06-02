import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class wall {
	// ARA METEIX NO TE SENTIT PERO EN SI ERA PER A EN UN FUTUR REALITZAR UN RECTANGLE INVISIBLE
	/*
	 AQUEST ACTUARA COM A COLLIDER I AIXI NO PERDRA RENDIMENT EL JOC PER COMPROBAR 5000 VEGADES SI CADA UN DELS BLOCKS GENERATS ES TOCA AMB LA PILOTA
	 AIXI NOMES HO COMPROBA SI ESTA DINS DEL COLLIDER QUE OCUPARA el (HEIGHT/3)*2
	 */
	private int with;
	private int height;
	private int X = 0;
	private int Y = 0;
	public static final int LADRILLOROJO  = 1;
	public static final int LADRILLORAZUL = 2;
	public int VIDESVERD = 3;
	public int VIDESBLAU = 1;
	public int VIDESRED = 2;
	public int blocks_per_fila = 8;
	
	public wall(int h, int w) { //height,with
		this.setHeight(h);
		this.setWith(w);
	}
	
	public void crearTablero(int level,ArrayList<ladrillo> ladrillos) {
		int withblocks = 42;
		int heightblocks = 22;
		
		Game.blocksvius = true;
		
		int[][] random_block_selector = new int [100][100];
		// PONE DE MANERA RANDOM EN LAS LISTAS LOS NUEMEROS PARA HACER SORTEO
		
		for(int x = 0; x < random_block_selector[0].length; x++) {
			for(int i = 0; i < random_block_selector[0].length ; i++) {
				random_block_selector[x][i] = getRandomNumber(0, 11);
			}
		}
		
		//ESCOGE LOS BLOQUES DEFINITIVAMENTE
		for(int x = 0; x < level ; x++) {
			for(int i = 0; i < blocks_per_fila ; i ++) {
				switch(random_block_selector[getRandomNumber(0,99)][getRandomNumber(0,99)]) {
					case 4:case 10:
							ladrillos.add(new vermell((withblocks+5)*i+5,(heightblocks+5)*x+10,withblocks, heightblocks,VIDESRED));break;
					case 0:case 2:case 3:case 5:
							ladrillos.add(new blau((withblocks+5)*i+5,(heightblocks+5)*x+10,withblocks, heightblocks,VIDESBLAU));break;
					default:
							ladrillos.add(new verd((withblocks+5)*i+5,(heightblocks+5)*x+10,withblocks, heightblocks,VIDESVERD));break;
				}
			}
		}
	}
	public void paint(Graphics2D g2d,ArrayList<ladrillo> ladrillos,int files) {
		
			if(Game.collider) {
				g2d.setColor(Color.DARK_GRAY);
			}else {
				g2d.setColor(Color.GRAY);
			}
			g2d.fillRect(0,0,with,height/2-50);
		
		// COMPROVAR SI ESTAN VIVOS LOS LADRILLOS
			Game.ladrillos_size = ladrillos.size();
			//if (ladrillos.size() < 1 ){Game.blocksvius = false;}
		
		if(ladrillos.size() > 0)	
			for(int x = 0; x < blocks_per_fila*files; x++) {
					if(ladrillos.size() > x)
						ladrillos.get(x).paint(g2d);
			}
		
		/*
			g2d.drawRect(50,50,30,30);
			g2d.fillOval(0,0,30,30);
			g2d.drawOval(0,50,30,30);
		*/
	}
	
	
	public int getWith() {
		return with;
	}
	public void setWith(int with) {
		this.with = with;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getRandomNumber(int min, int max) {
		int[]randomlist = new int[5];
		for(int i=0;i<randomlist.length-1;i++) {
			float g = (float) ((Math.random() * (max - min)) + min);
			randomlist[i]= (int) g; 
		}
		int h = ((int) ((Math.random() * (5 - 1)) + 1));
	    return randomlist[h];
	}
	public Rectangle getBounds() {
		return new Rectangle(this.X, this.Y, this.with, this.height/2);
	}
}
