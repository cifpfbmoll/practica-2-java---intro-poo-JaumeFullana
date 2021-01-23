import java.util.Scanner;

public class ACT30 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una frase:");
        String frase=sc.nextLine();
        System.out.println("Ahora escribe 1 si quieres que pase la frase a mayusculas o 2 si quieres que la pase a minusculas");
        int numero=sc.nextInt();
        if (numero==1){
            System.out.println(frase.toUpperCase());
        } else if (numero==2){
            System.out.println(frase.toLowerCase());
        } else {
            System.out.println("ERROR: Esta opcion no existe");
        }
    }
}
