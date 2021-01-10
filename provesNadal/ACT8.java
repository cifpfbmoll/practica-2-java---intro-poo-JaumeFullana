import java.util.Scanner;
public class ACT8{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un caracter:");
        char caracter=sc.next().charAt(0);
        int numero=(int)caracter;
        System.out.println("El caracter "+caracter+" representa al numero "+numero+" en ASCII.");
    }
}