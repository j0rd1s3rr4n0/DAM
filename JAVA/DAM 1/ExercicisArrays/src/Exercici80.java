import java.util.Scanner;
public class Exercici80 {
	// NUMEROS PERFECTES
	//vaxasoftware.com/doc_edu/mat/numperfe_esp.pdf
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int numero = 1;
		int x = 0; int max = 0;
		System.err.print("Rango del 1-");
		int maxnum = e.nextInt();
		int suma = 0;
		int perf = 0;
		int [] numperfectes = new int[50];
		int c = 0;
		while(x<maxnum) {c=0;for(int i = 1 ; i <=(numero+x); i++){
			if((numero+x)%i==0){c+=1;}}if (c > max ) {max = c;}x++;} // Explorar y Planificar
		//System.err.println(max); // Retorna el valor maxim de divisors que es poden fer servir
		int temp [] = new int [max]; // Herramientas y Suministros
		x = 0;
		
		
		while(x<maxnum) {
		int sum = 0;
		for(int i = 1 ; i <=(numero+x); i++){
			if((numero+x)%i==0){
				
				sum+=i;
			}
		}
		sum -= (numero+x);
		//System.err.println((numero+x)+"|"+sum);
		if(sum == (numero+x)) {
			if (perf >= 49) {
				System.err.println("");
			}
			numperfectes[0] = sum;
			System.out.println("Numero Perfecte: "+sum);
			perf+=1;
		}
			x++;}
		
	}
}