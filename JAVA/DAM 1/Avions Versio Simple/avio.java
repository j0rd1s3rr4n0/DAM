
public class avio {
	private String matricula;
	private int autonomia;
	private int capacitat_de_carrega;
	private int alçada;
	private int posicio_X;
	
	public avio(String matricula,int Autonomia,int Alçada,int Capacitat_de_carrega,int Posicio_X) {
		this.setAlçada(Alçada);
		this.setMatricula(matricula);
		this.setPosicio_X(Posicio_X);
		this.setAutonomia(Autonomia);
		this.setCapacitat_de_carrega(Capacitat_de_carrega);
	}
	
	public void modificarPos(int pos){
		switch(pos) {
		case 0:setPosicio_X(getPosicio_X()+1);break;
		case 1:setPosicio_X(getPosicio_X()-1);break;
		}
	}
	
	public void modificarAlt(boolean alçada) {
		if(alçada) {setAlçada((getAlçada()+1));}
		else {setAlçada((getAlçada()-1));}
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String m) {
		this.matricula = m;
	}
	public int getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	
	public int getAlçada() {
		return alçada;
	}
	public void setAlçada(int alçada) {
		this.alçada = alçada;
	}
	public int getCapacitat_de_carrega() {
		return capacitat_de_carrega;
	}
	public void setCapacitat_de_carrega(int capacitat_de_carrega) {
		this.capacitat_de_carrega = capacitat_de_carrega;
	}
	public int getPosicio_X() {
		return posicio_X;
	}
	public void setPosicio_X(int posicio_X) {
		this.posicio_X = posicio_X;
	}
	

}
