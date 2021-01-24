import java.util.Scanner;

public class ACT33 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una palabra:");
        String palabra=sc.nextLine();
        System.out.println("Las letras 4 y 5 de esta palabra son: "+palabra.substring(3, 5));
    }
}
