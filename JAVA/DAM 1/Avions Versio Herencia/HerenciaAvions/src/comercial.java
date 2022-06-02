
public class comercial extends avio {
	private int capacitat_passatgets;
	private int [] dimensions = new int[3];
	
	public comercial(String matricula, String marca, String model, String origen, String desti,int tripulants, Coordenada coordenades,int capacitat_passatgets, int[] dimensions) {
		super(matricula,marca,model,origen,desti,coordenades,tripulants);
		this.setCapacitat_passatgets(capacitat_passatgets);
		this.setDimensions(dimensions);
	}
	
	public int getCapacitat_passatgets() {
		return capacitat_passatgets;
	}
	
	public void setCapacitat_passatgets(int capacitat_passatgets) {
		this.capacitat_passatgets = capacitat_passatgets;
	}

	public int[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(int[] dimensions) {
		this.dimensions = dimensions;
	}
	
	public void info() {
		System.out.println("-======================= AVIO COMERCIAL =======================-");
		super.info();
		System.out.println("-==============================================================-");
		
	}
	@Override
	boolean askcombat() {return false;}
	
}
