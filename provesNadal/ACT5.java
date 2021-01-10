import java.util.Scanner;
public class ACT5 {
    public static void main(String[] args){
        System.out.println("Vamos a calcular el area de un circulo!");
        Scanner scRadio=new Scanner(System.in);
        System.out.println("Necesito el radio del circulo en cm:");
        Double radio=scRadio.nextDouble();
        Double area=Math.PI*Math.pow(radio,2);
        System.out.println("El radio del circulo es de: "+area+" cm");
    }
}