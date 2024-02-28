//import java.util.Scanner;
public class Exercici73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 100;
		//Scanner e = new Scanner(System.in);
		int [] LlistaQuadrat = new int[max];
		for (int i = 0;i<max;i++) {
			LlistaQuadrat[i] = i*i;
		}
		
		for ( int c = 0;c<max;c++) {
			System.out.println(LlistaQuadrat[c]);
		}
	}
}
