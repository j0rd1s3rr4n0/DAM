import java.util.Scanner;

abstract class avio {
	private String matricula;
	private String marca;
	private String model;
	private String origen;
	private String desti;
	private int tripulants;
	private Coordenada coordenades;
	private int alçada;
	private boolean trenAterratge;
	private int rumb;
	private int accelerar;
	private int velocitat;
	private boolean motor_on;
	private int temps;
	private boolean enlairat;
	/**
	 * @param matricula
	 * @param marca
	 * @param model
	 * @param origen
	 * @param desti
	 * @param coordenades
	 * @param tripulants 
	 **/

	public avio(String matricula, String marca, String model, String origen, String desti, Coordenada coordenades, int tripulants) {
		this.matricula = matricula;
		this.setTrenAterratge(true);
		this.marca = marca;
		this.model = model;
		this.origen = origen;
		this.desti = desti;
		this.coordenades = coordenades;
		this.temps = 0;
		this.accelerar = 0;
		this.velocitat = 0;
		this.enlairat = false;
		this.rumb = 0;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDesti() {
		return desti;
	}
	public void setDesti(String desti) {
		this.desti = desti;
	}
	public Coordenada getCoordenades() {
		return coordenades;
	}
	public void setCoordenades(Coordenada coordenades) {
		this.coordenades = coordenades;
	}
	public int getTripulants() {
		return tripulants;
	}
	public void setTripulants(int tripulants) {
		this.tripulants = tripulants;
	}
	
	public int getAlçada() {
		return alçada;
	}

	public void setAlçada(int alçada) {
		this.coordenades.setLatitud(alçada);
		this.alçada = alçada;
	}

	public void upAlçada() {
		if(isEnlairat() == false) {
			setEnlairat(true);
		}
		setAlçada(getAlçada()+10);
		System.out.println("\n [ INCREMENTANT ALÇADA . . . ] \n");
	}
	
	public void downAlçada() {
		setAlçada(getAlçada()-10);
		System.out.println("\n [ BAIXANT ALÇADA . . . ] \n");
	}
	
	public boolean isTrenAterratge() {
		return trenAterratge;
	}

	public void setTrenAterratge(boolean trenAterratge) {
		this.trenAterratge = trenAterratge;
	
	}
	public void switchTrenAterratge() {
		if(true == isTrenAterratge()) {
			System.out.println("\n [ Tren d'Aterratge - DESACTIVAT ] \n");
			this.trenAterratge = false;
		}else {
			System.out.println("\n [ Tren d'Aterratge - ACTIVAT ] \n");
			this.trenAterratge = true;
		}
	}
	


	public int getRumb() {
		return rumb;
	}

	public void setRumb(int rumb) {
		this.rumb = rumb;
	}

	
	
	public int getAccelerar() {
		return accelerar;
	}

	public void setAccelerar(int accelerar) {
		this.accelerar = accelerar;
	}
	
	public void Accelerar() {
		setVelocitat(getVelocitat()+10);
		setAccelerar(getAccelerar()+10);
		System.out.println("\n [ ACCELERANT . . . ] \n");
		setVelocitat((getVelocitat() + (getAccelerar()*getTemps())));
	}
	public void Frenar() {
		setAccelerar(getAccelerar()-10);
		System.out.println("\n [ FRENANT . . . ] \n");
		setVelocitat((getVelocitat() + (getAccelerar()*getTemps())));
	}
	
	public int getVelocitat() {
		return this.velocitat;
	}

	public void setVelocitat(int velocitat) {
		this.velocitat = velocitat;
	}
	
	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public boolean isMotor_on() {
		return motor_on;
	}

	public void setMotor_on(boolean motor_on) {
		this.motor_on = motor_on;
	}
	public void switchMotor() {
		if(true == isMotor_on()) {
			System.out.println("\n [ MOTOR APAGAT! ] \n");
			this.motor_on = false;
		}else {
			System.out.println("\n [ MOTOR ENCES! ] \n");
			this.motor_on = true;
		}
	}
	public void idle() {setAccelerar(0);}

	public void info() {
		System.out.println(
			"\n MATRICULA: "+getMatricula() +
			"\n MARCA & MODEL: "+getMarca() +" "+getModel() +
			"\n NUMERO TRUPULANTS: "+getTripulants()+
			"\n COORDENADES: \n 	Longitud (X): "+getCoordenades().getLongitud() +"\n 	Latitud (Y): "+getCoordenades().getLatitud() +
			"\n TRAJECTE: "+getOrigen() +" --> "+getDesti()+"\n"
		);
	}
	
	public boolean isEnlairat() {
		return enlairat;
	}

	public void setEnlairat(boolean enlairat) {
		this.enlairat = enlairat;
	}
	abstract boolean askcombat();

	
}
