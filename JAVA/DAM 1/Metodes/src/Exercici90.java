import java.util.Scanner;
public class Exercici90 {
  /*
  	• int Llegirenter();
  	• int mesGran(int[] valors);
  	• int mesPetit(int[] valors);
  	• double mitjana(int[] valors);
   */
  Scanner e = new Scanner(System.in);

  public int Llegirenter() {
    System.out.print("Numero: ");
    int num = e.nextInt();
    return num;
  }

  public int mesGran(int[] valors) {
    int max = valors[0];
    for (int i = 1; i < valors.length; i++) {
      max = Math.max(max, valors[i]);
    }
    return max;
  }
  public int mesPetit(int[] valors) {
    int min = valors[0];
    for (int i = 1; i < valors.length; i++) {
      min = Math.min(min, valors[i]);
    }
    return min;
  }
  public double mitjana(int[] valors) {
    double mitjana = 0.0;
    for (int i = 0; i < valors.length; i++) {
      mitjana += valors[i];
    }
    mitjana = mitjana / valors.length;
    return mitjana;
  }

  public static void main(String[] args) {
    Exercici90 p = new Exercici90();
    boolean sortir = false;
    /*
     * a[0] => Almacena puntos para contar los numeros que hay
     * a[1] => Almacena los numeros separados por ","	 
     */
    while (!sortir) {
      String a[] = {
        "",
        ""
      };
      int num = 1;

      while (num != 0) {
        num = p.Llegirenter();
        a[0] += ".";
        a[1] += (num + ",");
      }
      //System.out.println(a[0]);
      System.out.print("\nOPCIONS:\n 1.- Mitjana\n 2.- Més Gran\n 3.- Més Petit\n 4.- Borrar Valors\n 5.- Sortir\n> ");
      Scanner e = new Scanner(System.in);
      char elecio = e.next().charAt(0);

      int n = a[0].length() - 1;

      //System.out.println(a[0].length()-1); // Numero de Numeros
      String b[] = a[1].split(",");
      int c[] = new int[n];
      //System.out.println(Arrays.asList(a));
      for (int i = 0; i != n; i++) {
        c[i] = Integer.parseInt(b[i]);
      }
      //for (int i : c) {System.out.print(i);}

      switch (elecio) {
      case '1':
        System.out.println("La Mitjana és: " + p.mitjana(c));
        break;
      case '2':
        System.out.println("El Nombre Més Alt és: " + p.mesGran(c));
        break;
      case '3':
        System.out.println("El Nombre Més Petit és: " + p.mesPetit(c));
        break;
      case '4':
        for (int x = 0; x < c.length; x++) {
          c[x] = 0;
        }
        break;
      case '5': sortir = true;break;
      default:
        System.out.println("Aquest Valor No Correspon A Cap Acció!");
      }
    }
  }
}