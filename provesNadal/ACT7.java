import java.util.Scanner;
public class ACT7{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero:");
        int numero=sc.nextInt();
        char caracter=(char)numero;
        System.out.println("El caracter ASCII con el numero "+numero+" es: "+caracter);
    }
}