import java.util.Scanner;
public class Exercici93 {
	public int comptarlletres(char a){
		String[] lletres = "abcdefghijklmnopqrstuvwxyz".split("");
		int contador = 0;
		for(int x = 0; x < lletres.length ; x++) {
			if(a == lletres[x].charAt(0)){
				contador+=1;
			}
		}
		return contador;
	}

	public String llegirString() {
		Scanner e = new Scanner(System.in);
		System.out.print("PARAULA: ");
		String paraula = e.nextLine();

		return paraula;
	}

	public char[] lletresDiferents(String paraula) {
		String[] lletres = "abcdefghijklmnopqrstuvwxyz".split("");
		int[] contador = new int[26];
		char c[] = new char[26];
		String[] parauleta = paraula.toLowerCase().split("");
		/*
		  AQUEST BUCLE ES PERQUE DE BONES A PRIMERES L'ARRAY
		  DE JAVA NECESITA UN VALOR DIFERENT AL '' DEFAULT .
		*/
		for (int l = 0; l < c.length; l++) {
			c[l] = '.';
		}
		
		/*
			AGAFA LA EL ARRAY D'STRING A QUE CONTE LES PARAULES QUE HEM ESCRIT
			I PER A CADA LLETRA LA COMPARA AMB CADA LLETRA DE L'ABECEDARI, SI
			COINCIDEIX AMB ALGUNA LLETRA DE L'ACEBEDARI LA AFAGEIX DE L'ARRAY,
			SINO NO.
		*/
		for (int x = 0; x < lletres.length; x++) {
			for (int i = 0; i < parauleta.length; i++) {
		      if (parauleta[i].equals(lletres[x])) {
		         c[x] = lletres[x].charAt(0);
		      }
		   }
		}

		// AGAFA ELS CARACTERS I ELS PASA A UN STRING
		String g = "";
		for (char Char: c) {
		   if (Char != '.') {
		      g += Char;
		   }
		}

		// Agafa els caracters del string i els pasa a char
		char[] nou_array = new char[g.length()];
		for (int o = 0; o < g.length(); o++) {
			nou_array[o] = g.charAt(o);
		}
		
		/*
			CONTAR CARACTERES Y DESPUES HACER UN ARRAY POR ESOS
			CARACERES QUE SU CONTADOR ESTE EN MAYOR A 0
		*/
		for (int h = 0; h < c.length; h++) {
			// ep ~ { 0 , 0 } ;
			contador[h]	+= comptarlletres(c[h]);
			// AQUI AFEGEIX EL NUMERO DE LLETRES QUE TE <LA_LLETRA_QUE_TENS>
		}

		String ppp = "";
		for (int j = 0; j < lletres.length; j++) {
			if (contador[j] > 0) {
				ppp += lletres[j];
			}
		}
		
		int[] cont = new int[ppp.length()];
		for (int h = 0; h < parauleta.length; h++) {

				// NO SE SAPIGUT COM IMPLEMENTAR LA FUNCIO DE COMPTAR LLETRES AQUÍ NI ABAIX
			
			cont[h]	+= comptarlletres(parauleta[h].charAt(0));
			// AQUI AFEGEIX EL NUMERO DE LLETRES QUE TE <LA_LLETRA_QUE_TENS>
		}
		
		char[] nou_arrays = new char[ppp.length()];
		for (int i = 0; i < ppp.length(); i++) {
			nou_arrays[i] = ppp.charAt(i);
		}
		return nou_arrays;
	}

	public static void main(String[] args) {
	   Exercici93 p = new Exercici93();
	   String[] lletres = "abcdefghijklmnopqrstuvwxyz".split("");
	   char[] l = p.lletresDiferents(p.llegirString());
	   
	   for (char i: l) {
	      System.out.println(i + " : " + p.comptarlletres(i) );
	   }
	}
}