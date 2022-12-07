

public class Calculadora {

	public static double suma(double a,double b) {

		return a+b;
	}
	
	public static double resta(double a,double b) {
		
		return a-b;
	}
	
	public static double multi(double a,double b) {
		
		return a*b;
	}
	
	public static double divi(double a,double b) throws IllegalArgumentException{
		if ( b != 0) {
			return a/b;
		}
		else {
			throw new IllegalArgumentException ( "Infinito" );
		}
	}
}

