import java.util.Scanner;
public class Exercici18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double importe,percentatge,salariMensual,antiguitatEmpresa,treballador,userInput;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Anys en l'empresa del treballador: ");
		antiguitatEmpresa = input.nextDouble();// Antiguitat Treballador en anys
		System.out.print("Salari Mensual del Treballador: ");
		salariMensual = input.nextDouble();// Salari Inicial
		treballador = 1;
		
		if ((antiguitatEmpresa <= 1) && (antiguitatEmpresa > 0.0)) {
			percentatge = 0.05;
		}
		else if ((antiguitatEmpresa < 2) && (antiguitatEmpresa >= 1)) {
			percentatge = 0.07;
		}
		else if ((antiguitatEmpresa < 5) && (antiguitatEmpresa >= 2)) {
			percentatge = 0.1;
		}
		else if ((antiguitatEmpresa < 10) && (antiguitatEmpresa >= 5)) {
			percentatge = 0.15;
		}
		else if ( antiguitatEmpresa >= 10){
			percentatge = 0.2;
		}
		else {
			System.out.println("L'usuari no treballa aqui.");
			percentatge = 0;
			treballador = 0;
		}
		importe = (salariMensual * treballador) + (salariMensual * percentatge);
		System.out.println("Import del treballador: "+importe);
		
		
	}

}
