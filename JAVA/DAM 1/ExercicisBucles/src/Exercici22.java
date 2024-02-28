import java.util.Scanner;
public class Exercici22 {

	public static void main(String[] args) {
		/*
		 	56. Fer un programa per entrar (caràcter a caràcter) un text (no buit) del que hem de dir el número de A’s que hi
			7. Ídem anterior però ara heu de dir el nombre de caràcters diferents de A.
			58. Ídem anterior però ara heu de comptar les vocals que hi ha en el text, tant majúscules com minúscules.
			59. Ídem anterior però ara heu de calcular el % de lletres A amb relació als caràcters dels espais en blanc ‘ ‘ (caldrà
			saber el número de A i d'espais en blanc) . Si s’entran 10 ‘ ‘ i 5 ‘A’ hi ha un 50% de A respecte als ‘ ‘
			60. Igual que l’exercici 56 però cal comptar la seqüència dels dos caràcters ‘LA’.
			61. Ídem anterior però ara s’ha de comptar ‘LA’ i ‘SI’.
		*/
		
		Scanner e = new Scanner(System.in);
		String Texto;
		int a = 0;
		int diffA = 0;
		int espais = 0;
		int vocals = 0;
		int beforeChar = 0;
		int perCent = 0;
		int n = 0;
		int LA = 0;
		int SI = 0;
		boolean changeesp = false;
		char g;
		boolean contCharWord=true;
		String word ="";
		espais = 0;
		vocals = 0;
		System.out.println("==========================================\n                 T E X T\n==========================================\n");
		Texto = e.nextLine();
		int gvg = (int) (Texto.replaceAll(" ", "").length());
		
		while(true) { 
			g = Texto.charAt(n);
			int vg = (int) g;
			if (g == ' ') {
				espais++;
			}
			else {
				//System.out.print(g+" "+vg+" | ");
				// FILTRO SI / LA
				//LA
				if (((vg==65 ) || (vg == 97 )) && (beforeChar == 76 || beforeChar == 108) ) {LA+=1;}
				//SI
				if (((vg==73 ) || (vg == 105 )) && (beforeChar == 83 || beforeChar == 115) ) {SI+=1;}

				// Consonantes
				if (((vg >= 98) && (vg <= 100)) || ((vg >= 102) && (vg <= 104)) || ((vg >= 106) && (vg <= 110)) || ((vg >= 112) && (vg <= 116)) || ((vg >= 118) && (vg <= 122))){diffA+=1;}
				else if (((vg >= 66)&&(vg <=68)) || ((vg >= 70)&&(vg <=72)) || ((vg >= 74)&&(vg <=78)) || ((vg >= 80)&&(vg <=84)) || ((vg >= 86)&&(vg <=90))){diffA+=1;}
				//vocales
				else if (((vg == 97) || (vg == 101) || (vg == 105) || (vg == 111) || (vg == 117) || ((vg >=224) && (vg <=230)) || ((vg >=232) && (vg <=240)) || ((vg >=242) && (vg <=246)) || ((vg >=248) && (vg <=252)))){vocals += 1;
					if ((vg == 64) || (vg == 97) || ((131 >= vg) && (vg <= 134)) || (vg == 142) || (vg == 143) || (vg == 160) || ((181 >= vg) && (vg <= 183)) || ((198 >= vg) && (vg <= 199))||(vg == 224) || (vg == 225) || (vg == 226) || (vg == 228)) {a+=1;}
					else if ((vg != 64) || (vg != 97) ){diffA+=1;}
				}
				else if ((vg==(97-32)) || (vg==(101-32)) || (vg==(105-32)) || (vg==(111-32)) || (vg==(117-32)) || ((vg>=(224-32)) && (vg<=(230-32))) || ((vg>=(232-32)) && (vg<=(240-32))) || ((vg>=(242-32)) && (vg<=(246-32))) || ((vg>=(248-32)) && (vg<=(252-32) ))){vocals += 1;
					if ((vg == 64) || (vg == 97) || ((131 >= vg) && (vg <= 134)) || (vg == 142) || (vg == 143) || (vg == 160) || ((181 >= vg) && (vg <= 183)) || ((198 >= vg) && (vg <= 199))||(vg == 224) || (vg == 225) || (vg == 226) || (vg == 228)) {a+=1;}
					else if ((vg != 64) || (vg != 97) ){diffA+=1;}
				}}

			//EOW
			if (n == Texto.length()-1) {
				break;
			}
			
			
			
			n++;
			//ESPACIOS
			//espais = Texto.length() - Texto.replaceAll(" ", "").length();
			beforeChar= vg;
		}
		if(espais == 0) {
			espais = a;
			changeesp = true;
		}
		perCent = (int)(double)( (a/espais)*100);
		
		//System.out.println(espais);
		
		if (changeesp == true) {
			espais = 0;
		}
		System.out.printf("\n==========================================\nEspais: %d\nA's: %d\nCaràcters diferents a A: %d\nVocals: %d\nHi ha un %d%s de A's respecte als ' '(espais)\nLA: %d\nSI: %d",espais,a,diffA,vocals,perCent,'%',LA,SI);
		
	}

}
