import java.util.Scanner;
public class Exercici75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner e = new Scanner(System.in);
		System.out.print("Nº Elements > ");
		int n = e.nextInt();
		boolean error = false;
		int [] lista = new int[n];
		int v;int max;int pos = -999;
		
		for(int x = 0;x<n;x++) {
			lista[x] = -999;
		}
		int i = 0;
		while(true){
			if(i == n){break;}
			
			//INSERTAR VALOR
			System.out.printf("Valor %d > ",i+1);
			v = e.nextInt();
			
			//VALIDAR SI REPETIT --> error = true
			error = false;
			for(int x = 0;x<n;x++) {
				if(v == lista[x]) {
					error = true;
					System.err.println("ERROR - Valor Repetit!");
					x = n; //FIN FOR
				}
			}
			if (error == false) {
				lista[i]=v;i++;
			}
			//else if() {}
			
		}
		max = lista[0];
		pos = 0;
		for(int x = 0;x<n;x++) {
			if(lista[x]>max) {
				max = lista[x];
				pos = x;
			}
		}
		System.out.printf("\nRESULTAT\nValor Maxim: %d\nPosició: %d",max,pos);
		
		
	}

}
