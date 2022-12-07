package procFuncs;

public class procFuncs {
// ZONA DE VARIABLES GLOBALS TOTES LES FUNCIONS HI PODEN ACCEDIR
	int x,y;
	int resultat;
	int [] nombres;
	
	public static void main(String[] args) {
		procFuncs p = new procFuncs();
		p.principal();
	}
	
	public void principal() {
		// z es una variable LOCAL!! Nomes viu dins del procediment principal()
		int z = 0;
		x =5;	y=6;
		imprimirResultatSuma();
		
		x =10;	y=25;
		imprimirResultatSuma();
		//perque a jav+a el resultat de definir funcions no importa si es declara despres i no avans.
		
		inicialitzarArray();
		imprimirArray();
	}
	
	public void imprimirResultatSuma() {
		System.out.println("El resultat de la suma\nes igual a "+(x+y));
	}
	
	public void inicialitzarArray() {
		for(int i = 0; i<nombres.length;i++) {
			nombres[i]=i;
		}
	}
	
	public void imprimirArray() {
		for(int i = 0; i<nombres.length;i++) {
			System.out.println(nombres[i]);
		}
	}
}
