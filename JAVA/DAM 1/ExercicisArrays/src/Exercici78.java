import java.util.Scanner;
public class Exercici78 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ol;
		int g;
		int x;
		char c;
		int index;
		char [] abcdari = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ñ','*'};
		int [] contador = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; 
		Scanner e = new Scanner(System.in);
		
		while(true) {
			System.out.print("Caracter: ");
			c = e.next().charAt(0);
			g = c;
			// a = -97 z = 122
			// A = -65 Z = 90
			// ñ = 241
			// Ñ = 209
			if ( g >=65 && g<=90) { //abedecari majuscules
				index = g -65;
				contador[index]+=1;
			}
			else if (g>=97 && g<=122){ // abecedari minuscules
				index = g -97;
				contador[index]+=1;
			}
			else if ( g == 241 || g == 209 ) { // Ñ
				index = 27;
				contador[index]+=1;
			}		
			else {
				index = 28;
				contador[index]+=1;
			}
			
			if(c=='.') {
				break;
			}
			
		}
		System.err.println("EOF");
		for(x=0;x<28;x++) {
			System.out.printf("Lletra %c : %d \n",abcdari[x],contador[x]);
		}
		
		
		
	}

}
