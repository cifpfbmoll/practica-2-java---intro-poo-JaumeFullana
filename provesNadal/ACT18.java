import java.util.Scanner;

public class ACT18{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero entero");
        int numero1=sc.nextInt();
        System.out.println("Escribe otro numero diferente al primero");
        int numero2=sc.nextInt();
        while (numero1==numero2){
            System.out.println("Ese numero no es diferente al primero, porfavor escribe uno diferente");
            numero2=sc.nextInt();
        }
        if (numero1<numero2){
            System.out.println("Aqui estan 10 numeros aleatorios entre estos dos");
            for (int i=0;i<10;i++){
                System.out.println((int)Math.floor(Math.random()*(numero1-numero2)+numero2));
        } 
        } else {
            System.out.println("Aqui estan 10 numeros aleatorios entre estos dos");
            for (int i=0;i<10;i++){
                System.out.println((int)Math.floor(Math.random()*(numero2-numero1)+numero1));
            }
        }
    }
}