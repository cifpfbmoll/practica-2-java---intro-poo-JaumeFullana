import java.util.Scanner;

public class ACT34 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una frase:");
        String frase=sc.nextLine();
        String[] lista=frase.split(" ");
        System.out.println("Las palabras de la frase son:");
        for (int i=0;i<lista.length;i++){
            System.out.println(lista[i]);
        }
    }
}
