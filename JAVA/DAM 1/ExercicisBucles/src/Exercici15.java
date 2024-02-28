import java.util.Scanner;
public class Exercici15 {

	public static void main(String[] args) {
		// Fer un algorisme que escrigui el triangle de Floyd. Inicialment llegirem un número N enter que representarà el
		// número de files a escriure.
		Scanner e = new Scanner(System.in); // input 
		int x = 1;// x = 1
		int i = 1;// i = 1
		int imax = 1;// imax = 1
		System.out.print("> ");int s = e.nextInt(); // stop = input('> ')
		while(i<=imax) {//while(i<=imax):
			/* Embellecedor
			if ( x < 10) {
				System.out.print("0"+x+" ");
			}
			else {
				System.out.print(x+" ");
			}
		 	*/
			System.out.print(x+" ");//print(x,end=" ")
			
			if ( i == imax) {	//if i == imax:
				i = 0; // i = 0
				imax++; //imax +=1
		
				System.out.print("\n"); // print('\n')
		}
		
		if ( imax > s) { // 	if imax > stop:
			break; // break
		}
		i++; // 	i+=1
		x++; // 	x+=1
		
		}
	}
}