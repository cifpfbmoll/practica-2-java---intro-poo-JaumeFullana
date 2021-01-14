import java.util.Scanner;

public class ACT15 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int numero;
        do{
            System.out.println("Escribe un numero que sea menor que 0:");
            numero=sc.nextInt();
        } while(numero<0);
        System.out.println(numero);
    }
}
