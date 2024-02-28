import java.util.Scanner;
public class Exercici16 {

	public static void main(String[] args) {
		// Secuendia de Fibonacii
		Scanner e = new Scanner(System.in);
		int fibonacci;
		int x = 1; //x = 1
		int y = 1; //y = 1
		int i = 1; //i = 1;
		int s = 0;
		while(s<=2) {
			System.out.print("N> ");s = e.nextInt(); //stop = input("N> ")
		}
		System.out.print("FIBONACCI: "+x+" "+y+" "); //print("FIBONACCI:",x,y,end=" ")
		while(true){ //while(True):
			i++; // i+=1
			fibonacci = x+y; //fibonacci = x + y
			if(i == s){
				break;
			}
			System.out.print(fibonacci+" ");
			x = y;
			y = fibonacci;
		}
			//if (i==stop):
			//	break
			//print(fibonacci,end=" ")

		//x = y
		//y = fibonacci
			
			

	}

}
