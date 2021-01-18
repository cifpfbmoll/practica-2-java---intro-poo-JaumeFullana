import java.util.Scanner;

public class ACT28 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una frase:");
        String frase=sc.nextLine();
        String sinEspacios=frase.replace(" ", "");
        System.out.println(sinEspacios);
    }
}
