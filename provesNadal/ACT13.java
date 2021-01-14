import java.util.Scanner;

public class ACT13 {
    
    static Scanner sc=new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Quantas ventas has realizado?");
        int numeroVentas=sc.nextInt();
        int cantidadVentas=0;
        for (int i=1;i<=numeroVentas;i++){
            System.out.println("De cuanto dinero ha sido la venta?");
            cantidadVentas+=sc.nextInt();
        }
        System.out.println("El dinero total de las ventas es: "+cantidadVentas);
    }
}
