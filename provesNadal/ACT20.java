import java.util.Scanner;

public class ACT20{

    public static void main(String[] args){

        System.out.println("Bienvenido al calculador de numeros primos");
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero entero:");
        int numero=sc.nextInt();
        if (numero<2){
            System.out.println("El numero "+numero+" no es primo");
        } else {
            int i=2;
            while (numero%i!=0){
                i++;
            }
            if (numero==i){
                System.out.println("El numero "+numero+" es primo");
            } else {
                System.out.println("El numero "+numero+" no es primo");
            }
        }
    }
}
