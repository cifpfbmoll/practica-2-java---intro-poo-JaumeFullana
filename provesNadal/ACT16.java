import java.util.Scanner;

public class ACT16 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String contraseña="Mallorca20";
        String input;
        Boolean acierto=false;
        int intentos=0;
        do {
            System.out.println("Escribe La contraseña:");
            input=sc.next();
            if (input.equals(contraseña)){
                System.out.println("Enhorabuena!");
                acierto=true;}
            intentos++;
        } while(intentos!=3 && !acierto);
        if (intentos==3 && !acierto){
            System.out.println("Lo sentimos, pero no tiene mas oportunidades");
        }
    }
}
