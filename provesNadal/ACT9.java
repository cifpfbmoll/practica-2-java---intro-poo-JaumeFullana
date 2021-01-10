import java.util.Scanner;
public class ACT9 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe el precio del producto en euros y te dire el precio final(sumar el IVA):");
        double precio=sc.nextDouble();
        double iva=(precio*21)/100;
        double precioFinal=precio+iva;
        System.out.println("El IVA de este producto es: "+iva+" y por tanto el precio final es: "+precioFinal);
    }
}