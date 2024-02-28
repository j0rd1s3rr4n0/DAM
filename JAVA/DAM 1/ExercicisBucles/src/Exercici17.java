import java.util.Scanner;
 
public class Exercici17 {
 
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        System.out.print("Introduzca numero de filas: ");
        int columna = e.nextInt();
        e.close();
 
        System.out.println();
        for(int fila = 1; fila<=columna; fila++){ // Hasta que fila no sea superior
            // " "
            for(int blancos = 1; blancos<=columna-fila; blancos++){
                System.out.print(" "); // Imprime espacio en blanco mientras que espacio_blanco sea superior a (columna-fila) 
            }
            //*
            for(int asteriscos=1; asteriscos<=(fila*2)-1; asteriscos++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}