import java.util.Scanner;

public class ACT14 {
    
    public static void main(String[] args){
        System.out.println("Vamos a calcular una ecuacion de segundo grado");
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe el valor de la variable a:");
        int a=sc.nextInt();
        System.out.println("Escribe el valor de la variable b:");
        int b=sc.nextInt();
        System.out.println("Escribe el valor de la variable c:");
        int c=sc.nextInt();
        double discriminante=Math.pow(b, 2)-(4*a*c);
        System.out.println(">>"+discriminante);
        if (discriminante>0){
            double x1=((b*(-1))+Math.sqrt(discriminante))/(2*a);
            double x2=((b*(-1))-Math.sqrt(discriminante))/(2*a);
            System.out.println("El valor de x1 es "+x1+" y el valor de x2 es "+x2);
        }else{
            System.out.println("El discriminante es negativo");
        }
    }
}
