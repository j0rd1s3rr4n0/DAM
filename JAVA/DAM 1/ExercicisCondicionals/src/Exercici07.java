import java.util.Scanner;
public class Exercici07 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner entrada = new Scanner(System.in);
        double num1,num2,num3,max,min,mid;
        
        System.out.print("Num1: ");
        num1 = entrada.nextDouble();
        System.out.print("Num2: ");
        num2 = entrada.nextDouble();
        System.out.print("Num3: ");
        num3 = entrada.nextDouble();
        
        if(num1>num2) {
            if(num1>num3) {
                if(num2>num3) {
                    System.out.println("Ordre Major->Menor: "+num1+", "+num2+", "+num3);                 
                }else {
                    System.out.println("Ordre Major->Menor: "+num2+", "+num3+", "+num1);
                }
            }else {
                System.out.println("Ordre Major->Menor: "+num3+", "+num1+", "+num2);
            }
        }else {
            if(num2>num3) {
                if(num1>num3) {
                    System.out.println("Ordre Major->Menor: "+num2+", "+num1+", "+num3);
                }else {
                    System.out.println("Ordre Major->Menor: "+num2+", "+num3+", "+num1);
                }              
            }else {
                System.out.println("Ordre Major->Menor: "+num3+", "+num2+", "+num1);
            }
        }
    }    
    /*
     *  max = Math.max
     *  min = Math.min
     *  Suma  A + B + C - (max -min)
     */

    }

