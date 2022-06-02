
public class Coordenada {
	private int latitud; // y
	private int longitud; // x
	
	public Coordenada(int x, int y) {
		this.setLongitud(x);
		this.setLatitud(y);
	}

	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
}
/*
String matricula
String marca
String model,
String origen
String desti

Coordenada coordenades,
int tripulants)

COMBAT
misils [] => RAND { 1,0,1,0,0,1,1,0};
objectiu [] = X / Y


COMERCIAL
int capacitat_passatgets

*/