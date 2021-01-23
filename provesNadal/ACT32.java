import java.util.Scanner;

public class ACT32 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe una palabra:");
        String palabra1=sc.next();
        System.out.println("Escribe otra palabra, igual o diferente:");
        String palabra2=sc.next();
        if(palabra1.equals(palabra2)){
            System.out.println("La palabra "+palabra1+" y la palabra "+palabra2+" son iguales");
        } else {
            System.out.println("La palabra "+palabra1+" y la palabra "+palabra2+" son diferentes");
        }
    }
}
