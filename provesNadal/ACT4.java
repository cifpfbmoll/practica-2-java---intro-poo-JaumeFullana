import java.util.Scanner;
public class ACT4 {
    public static void main(String[] args){
        Scanner scNombre=new Scanner(System.in);
        System.out.println("Escribe tu nombre: ");
        String nombre=scNombre.nextLine();
        
        System.out.println("Hola "+nombre);
    }
}