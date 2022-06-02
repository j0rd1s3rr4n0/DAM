import java.util.Scanner;
public class Exercici89 {
  /*
  [0] mostrar => Decideix si es mostra o no el resultat
  [1] funcionar => Mante funcionant el Programa
   */

  Scanner e = new Scanner(System.in);

  public static void main(String[] args) {
    Exercici89 p = new Exercici89();
    boolean booleanos[] = {
      false,
      true
    };
    int[] numeros = new int[2];
    while (booleanos[1]) {
      numeros[0] = numeros[1];
      System.out.print("Numero: ");
      numeros[1] = p.LlegirEnter();
      //System.out.println(numeros[0]+","+numeros[1]);
      if (numeros[1] == 0) {
        booleanos[1] = false;
        System.out.println("FIN DEL PROGRAMA");
      } else {
        if (numeros[0] != 0) {
          System.out.println(" Es Divisor " + numeros[0] + " de " + numeros[1] + " ?\n > " + p.esDivisor(numeros[0], numeros[1]));
        } else {}
      }

    }
  }

  public boolean esDivisor(int Divisor, int Divident) {
    return ((Divisor % Divident) == 0) ? true : false;
  }

  public int LlegirEnter() {
    int num = e.nextInt();
    return num;
  }
}