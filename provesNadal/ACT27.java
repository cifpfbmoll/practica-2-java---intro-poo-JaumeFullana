import java.util.Scanner;

public class ACT27 {
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un numero, para parar escribe -1:");
        int numero=sc.nextInt();
        int contador=1;
        while (numero!=-1){
            System.out.println("Escribe otro numero, para parar escribe -1:");
            numero=sc.nextInt();
            contador++;
        }
        if (contador==1){
            System.out.println("Has escrito "+contador+" numero");
        }else{
            System.out.println("Has escrito "+contador+" numeros");
        }
    }
}
