import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ladrillo {
	// x / y
	private int [] coord_m; // ESTABLEIX LA POSICIO DEL LADRILLO RELATIVA
	private int [] coord_i; // ESTABLEIX LA POSICIO ON COMENÇA
	private int [] coord_f; // ESTABLEIX LA POSICIO ON ACABA
	protected int X;
	protected static int Y;
	public boolean vivo;
	protected int with;
	protected int height;
	protected int vides;
	protected boolean muriendo = false;
	
	public ladrillo(int X, int Y, int with,int height,int vides) {
		this.X = X;
		this.Y = Y;
		this.with = with;
		this.height = height;
		this.vides = vides;
	}
	
	abstract void morir(int i);
	
	void paint(Graphics2D g2d) {
		g2d.fillRect(this.X,this.Y,this.with,this.height);
	}
	
	public int getX() {
		return X;
	}
	
	public Rectangle getBounds() {
		return new Rectangle( X,  Y, with, height);
	}
	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int[] getCoord_m() {
		return coord_m;
	}

	public void setCoord_m(int[] coord_m) {
		this.coord_m = coord_m;
	}

	public int[] getCoord_i() {
		return coord_i;
	}

	public void setCoord_i(int[] coord_i) {
		this.coord_i = coord_i;
	}

	public int[] getCoord_f() {
		return coord_f;
	}

	public void setCoord_f(int[] coord_f) {
		this.coord_f = coord_f;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}
	public int getWith() {
		return this.with;
	}
}
