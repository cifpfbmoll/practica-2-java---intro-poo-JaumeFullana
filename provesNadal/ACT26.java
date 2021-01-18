import java.util.Scanner;

public class ACT26 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Inserta un numero entero mayor que 1");
        int num=sc.nextInt();
        while(num<2){
            System.out.println("Inserta un numero entero mayor que 1");
            num=sc.nextInt();
        }
        int suma=0;
        for(int contador=1;contador<=num;contador++){
            suma+=contador;
        } 
        System.out.println("La suma es: "+suma);
    }
}
