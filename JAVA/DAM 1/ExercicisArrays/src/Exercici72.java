import java.util.Scanner;
public class Exercici72 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n,posicio,negatius,positius,neutres;
		Scanner e = new Scanner(System.in);
		
		System.out.print("Elements: ");
		n = e.nextInt();
		int [] dades = new int[n];
		
		negatius = 0;positius=0;neutres=0;
		
		for(posicio = 0;posicio<n;posicio++) {
			System.out.printf("Element [%d] > ",posicio+1);
			dades[posicio] = e.nextInt();
			if (dades[posicio] > 0) {positius+=1;}
			else {if (dades[posicio] == 0) {neutres+=1;}else {negatius+=1;}}
		}
		System.out.printf("DADES\n=====\nNeutres:%d\nNegatius:%d\nPositius:%d",neutres,negatius,positius);
	}
}
