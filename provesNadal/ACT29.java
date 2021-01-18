import java.util.Scanner;

public class ACT29 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una frase, no escribas nada para parar el programa:");
        String frasePrincipal=sc.nextLine();
        String fraseConcatenada="";
        fraseConcatenada=fraseConcatenada.concat(frasePrincipal);
        while (!(frasePrincipal.equals(""))){
            System.out.println("Escribe una frase, no escribas nada para parar el programa:");
            frasePrincipal=sc.nextLine();
            fraseConcatenada+=frasePrincipal;
        }
        System.out.println("La cadena resultante seria:");
        System.out.println(fraseConcatenada);
    }
}
