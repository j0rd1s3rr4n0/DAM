import java.util.Scanner;
import java.util.Random;
public class examen_ordinador_tonto {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		Random rand = new Random();
		
		int [] buida = new int[10];
		int [] energia = new int [10];
		char [] num = {'1','2','3','4','5','6','7','8','9','0'};
		char [] vocals = {'A','E','I','O','U'};
		char [] consonants = {'B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Z'};
		
		
		int a = 0;
		boolean fin = false;
		
		double mitjana = 0;
		int val_cont = 0;
		int val_acum = 0;
		char opcio = '4';
		int acum_ant;
				
		// char ==> consum energia
		
		while(!fin){
			char segur = ' ';mitjana = 0;
			
			
			System.out.println("1.- Buidar bateria.\n2.- Carregar bateria.\n3.- Imprimir energia de la Bateria.\n4.- Escriure N caràcters.\n5.- Estadistica.\n6.- Sortir.\n> ");
			opcio = e.next().charAt(0);
			
			switch(opcio) {
				case '1' : System.out.print("Esteu segurs d'esborrar la bateria? [S/N]\n >");segur = e.next().toUpperCase().charAt(0);if(segur == 'S') {energia=buida;};break;

				case '2' : if (energia.equals(buida)) {for(int x = 0; x < energia.length;x++) {int ValorRandom = rand.nextInt(3);energia[x] = ValorRandom;val_cont = x;val_acum+=ValorRandom;}}else {System.out.print("Encara Queden Cel·les amb càrrega!\nVoleu procedir a càrregar les cel·les? [S/N]\n>");segur = e.next().toUpperCase().charAt(0);if(segur == 'S') {for(int x = 0; x < energia.length;x++) {int ValorRandom = rand.nextInt(3);energia[x] = ValorRandom;val_cont = x;val_acum+=ValorRandom;}} if(val_acum == 0) {val_acum =1;};mitjana = val_acum / val_cont;System.out.print("Càrrega actual: ");for(int x = 0; x < energia.length;x++) {System.out.print(energia[x]+" ");}System.out.print("\nCàrrega Total: "+val_acum+ " unitats");System.out.printf("\nMitjana de les cel·les: %.2f  unitats per cel·la.\n\n",mitjana);}break;

				case '3' : System.out.print("Càrrega actual: ");for(int x = 0; x < energia.length;x++) {char b;if (energia[x] == 0){b = '-';}else if (energia[x] == 1){b = '+';}else{b = '*';}System.out.print(b+" ");}System.out.print("\n"); break;
				
				case '4' : break;
				
				case '5' : break;
					
				case '6' : fin = true;break;
				
				default: break;
			
			}
			
			System.out.print("Quants caracters vol escriure?\n> ");
			int buffer = e.nextInt();
			char [] Notepad = new char [buffer];
			
			int i = 0;
			String Norm;
			for(int x = 0; x < energia.length;x++) {val_acum = energia[x];val_cont = x;};mitjana = val_acum / val_cont;
			while(i < buffer){
				int resta = 0;
				//CALCULAR ENERGIA
				for(int x = 0; x < energia.length;x++) {val_acum = energia[x];val_cont = x;};mitjana = val_acum / val_cont;
				acum_ant = val_acum;
				
				if(val_acum <= 2){System.out.print("\nVols seguir (S/N): ");segur = e.next().toUpperCase().charAt(0);if (segur == 'N'){i = buffer+1;}}
				
				char letra = e.next().charAt(0);
				
				if(val_acum <= 0){Norm = "( NO PODEM ESCRIURE JA QUE ENS FALTEN UNITATS!)";}else{Norm = "( Estat bateria: "+acum_ant+" unitats restants)";}
				/*AQUI ESTA CALCULANT QUANT HA DE RESTAR D'ENERGIA*/
				for(int c = 0;c<3;c++){
					if (c == 0){
						int q = num.length;
						for(int k = 0;k<q;k++){
							if(num[k] == letra){resta+=1;}}}
							else if ( c == 1){int q = vocals.length;for(int k = 0;k<q;k++){
								if(vocals[k] == letra){resta+=2;}}}
							else{int q = consonants.length;for(int k = 0;k<q;k++){if(consonants[k] == letra){resta+=2;}}}
				}

				/* AQUI RESTAREM FINS ARRIBAR A 0 */
				
				val_acum = acum_ant;

				/*FIN RESTA ENERGIA*/
				System.out.printf(" - Consumeix %d unitats %s",resta,Norm);
				i++;
			}
			

		}
			

	}

}
