public class Examen{
	public static void main(String[] args){
		char C;int i = 0; int valor = 0; int gran = 0; 
		int numero;
		int Param = 0;
		int petit = 999; int mitjana = 0;
		String Nomg=""; String Nomp="";
		String BuffNom="";
		String Processar="";
		String amics = "Joan_21, Pau_23, Marta_19, Gemma_27.";
		
		while ( i < amics.length()) {
			C = amics.charAt(i);
			
			if ( C == '_') {
				C=' ';
				BuffNom = Processar;
				Processar = "";
				Param++;
			}
			if (C == ',') {
				C=' ';
				numero = Integer.parseInt(Processar);
				valor+=numero;
				Processar = "";
				Param++;
				if ( gran < numero) {
					gran = numero;
					Nomg = BuffNom;
					numero = 999;
				}
				
				else if (numero == gran){
					Nomg+=(" i "+BuffNom);
				}
				
				if (petit > numero) {
					petit = numero;
					Nomp = BuffNom;
				}
				else if (numero == petit) {
					petit = numero;
					numero = -999;
					Nomp+=(" i "+BuffNom);
				}
				else if (gran == numero){
					Nomg+=(" i "+BuffNom);
				}
			}
			if ( C == '.') {
				C=' ';
				numero = Integer.parseInt(Processar);
				valor+=numero;
				Processar = "";
				Param++;
				if ( gran < numero) {
					gran = numero;
					Nomg = BuffNom;
					numero = 999; //
				}
				
				else if (numero == gran){
					Nomg+=(" i "+BuffNom);
				}
				
				if (petit > numero) {
					petit = numero;
					Nomp = BuffNom;
				}
				else if (numero == petit) {
					petit = numero;
					numero = -999;
					Nomp+=(" i "+BuffNom);
				}
				else if (gran == numero){
					Nomg+=(" i "+BuffNom);
				}
				mitjana = valor/Param;
			}
			
			if(C!=' ') Processar+=C;
			i++;
		}
		System.out.printf("Quina és l'edat del més petit? %d en %s \nQuina és l'edat del més gran? %d en %s \nQuina és l'edat mitjana? %d", petit,Nomp,gran,Nomg,mitjana);
	}
}