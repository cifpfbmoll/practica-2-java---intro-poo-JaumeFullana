import java.util.Scanner;
public class ACT6{
    public static void main(String[] args){
        System.out.println("Vamos a ver si el numero que me das dividido 2 da de resto 0, es a decir, que es par");
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero:");
        int numero=sc.nextInt();
        if (numero%2==0){
            System.out.println("El resto es 0! por tanto es par.");
        }
        else{
            System.out.println("El resto no es 0! por tanto este numero es impar.");
        }
    }
}