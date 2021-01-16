import java.util.Scanner;

public class ACT19{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero positivo entero:");
        int numero=sc.nextInt();
        while (numero<1){
            System.out.println("Ese numero no es positivo, tienes que escribir un 1 o un numero superior");
            numero=sc.nextInt();
        }
        int contador=0;
        for (int i=numero;i>0;i/=10){
            contador++;
        }
        if (contador==1){
            System.out.println("El numero "+numero+" tiene "+contador+" cifra");
        } else {
            System.out.println("El numero "+numero+" tiene "+contador+" cifras");
        }
    }
}