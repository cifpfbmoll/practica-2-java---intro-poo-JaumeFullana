import java.util.Scanner;

public class ACT25 {
    
    public static void main(String[] args) {
        
        System.out.println("Bienvenidos a nuestra calculadora!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero:");
        int numero1=sc.nextInt();
        System.out.println("Escribe otro numero:");
        int numero2=sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el simbolo de la operacion que deseas realizar:");
        String simbolo=sc.next();
        switch (simbolo){
            case "+":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(numero1+numero2));
            break;
            case "-":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(numero1-numero2));
            break;
            case "*":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(numero1*numero2));
            break;
            case "/":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(numero1/numero2));
            break;
            case "^":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(Math.pow(numero1, numero2)));
            break;
            case "%":
            System.out.println("El resultado de "+numero1+simbolo+numero2+" es igual a: "+(numero1%numero2));
            break;
        }
    }
}
