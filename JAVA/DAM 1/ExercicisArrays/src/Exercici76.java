import java.util.Scanner;
public class Exercici76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner e = new Scanner(System.in);
		int valor; int m;
		
		System.err.print("Nº Elements > ");
		int n = e.nextInt();
		int [] taula = new int [n];
		
		for(int x = 0;x<n;x++) {
			System.err.printf("Element %d > ",x);
			valor = e.nextInt();
			taula[x]=valor;
		}
		System.out.print("Taula_Original = [");
		for(int x = 0;x<=n-1;x++) {
			System.out.print(taula[x]);
			if(x==n-1) {
				System.out.print("]\n");
			}
			else {
				System.out.print(",");
			}
		}
		if(n%2 != 0) {
			m=n-1;
			for(int x = 0;x<=m;x++) {
				if(taula[x]%2 == 0) {
					taula[x] = taula[x];
				}
			}
		}
		else {
			for(int x = 0;x<n;x++) {
				if(taula[x]%2 == 0) {
					taula[x] = taula[x]-1;
				}
			}
		}
		System.out.print("Taula_Modificada = [");
		for(int x = 0;x<=n-1;x++) {
			System.out.print(taula[x]);
			if(x==n-1) {
				System.out.print("]");
			}
			else {
				System.out.print(",");
			}
		}
		
	}

}
