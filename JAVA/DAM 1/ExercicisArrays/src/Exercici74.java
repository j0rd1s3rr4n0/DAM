import java.util.Scanner;

public class Exercici74 {
	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int max;char dpt;
		System.out.print("Nº Nombres dins la llista > ");
		max = e.nextInt();
		int[] llista = new int[max];
		int[] temp = new int[max];
		
		for ( int i = 0; i<max; i++ ) {
			System.out.printf("%d >",i+1);
			llista[i] = e.nextInt();
		}
		int y = 0;
		int x = max-1;
		while(true) {
			if (y == max) {break;}
			temp[y] = llista[x];
			y++;
			x--;
		}
		
		y = 0;
		x = max-1;
		while(true) {
			if (y == max) {break;}
			llista[y] = temp[y];
			y++;
		}
		System.out.print("Llista = [");
		for(int g = 0;g<max;g++) {
			if (g == max-1) {
				dpt =']';
			}
			else {
				dpt = ',';
			}
			System.out.printf(" %d %c",llista[g],dpt);
		}
	}
}
