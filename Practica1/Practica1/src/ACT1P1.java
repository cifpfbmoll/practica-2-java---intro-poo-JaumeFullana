import java.util.Scanner;

public class ACT1P1 {

    static Scanner sc= new Scanner(System.in);

    public static void leerNumeros() {
        int [] listaNumeros= new int[5];
        for (int i=0;i<5;i++){
            System.out.println("Escribe un numero entero:");
            int numero=sc.nextInt();
            listaNumeros[i]=numero;
        };
        for (int i=0;i<5;i++){
            System.out.print(listaNumeros[i]+" ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Bienvenido! escribe un numero del 1 al 9 para elegir una de las diferentes funciones del programa. Escribe 0 para slir de este.");
        int numero=sc.nextInt();
        while (numero!=0){
            switch (numero) {
                case 1:
                leerNumeros();
                break;

                case 2:
                ;
                break;

                case 3:
                ;
                break;

                case 4:
                ;
                break;

                case 5:
                ;
                break;

                case 6:
                ;
                break;

                case 7:
                ;
                break;

                case 8:
                ;
                break;

                case 9:
                ;
                break;

                case 0:
                System.out.println("Vale! hasta la proxima");
                break;

                default:
                System.out.println("ERROR: esa opcion no existe.");
            }
            sc=new Scanner(System.in);
            System.out.println("Elige una nueva funcion(1-9) o sal del programa(0):");
            numero=sc.nextInt();
        }
    }
}
