import java.util.Arrays;
import java.util.Scanner;

public class ACT1P1 {

    static Scanner sc= new Scanner(System.in);

    public static void leerNumeros() {
        System.out.println("Bienvenido al modulo de leer numeros.");
        int [] listaNumeros= new int[5];
        for (int i=0;i<5;i++){
            System.out.println("Escribe un numero entero:");
            int numero=sc.nextInt();
            listaNumeros[i]=numero;
        }
        for (int i=0;i<5;i++){
            System.out.print(listaNumeros[i]+" ");
        }
    }

    public static void LeerNumerosAlReves() {
        System.out.println("Bienvenido al modulo de leer numeros al reves.");
        int [] listaNumeros=new int[5];
        for (int i=0;i<5;i++){
            System.out.println("Escribe un numero entero:");
            int numero=sc.nextInt();
            listaNumeros[i]=numero;
        }
        for (int i=4;i>=0;i--){
            System.out.print(listaNumeros[i]+" ");
        }
    }

    public static void hacerMedias() {
        System.out.println("Bienvenido al modulo de hacer medias y contar ceros.");
        Double[] listaNumerosPositivos=new Double[0];
        Double[] listaNumerosNegativos=new Double[0];
        int ceros=0;
        for (int i=0;i<5;i++){
            System.out.println("Escribe un numero entero, positivo o negativo.");
            Double numero=sc.nextDouble();
            if (numero>=0){
                listaNumerosPositivos=Arrays.copyOf(listaNumerosPositivos, listaNumerosPositivos.length+1);
                listaNumerosPositivos[listaNumerosPositivos.length-1]=numero;
                if (numero==0){
                    ceros+=1;
                }
            }
            else {
                listaNumerosNegativos=Arrays.copyOf(listaNumerosNegativos, listaNumerosNegativos.length+1);
                listaNumerosNegativos[listaNumerosNegativos.length-1]=numero;
            }
        }
        Double sumaPositivos=0.0;
        for (int i=0;i<listaNumerosPositivos.length;i++){
            sumaPositivos+=listaNumerosPositivos[i];
        }
        Double sumaNegativos=0.0;
        for (int i=0;i<listaNumerosNegativos.length;i++){
            sumaNegativos+=listaNumerosNegativos[i];
        }
        Double mediaPositivos=sumaPositivos/listaNumerosPositivos.length;
        Double mediaNegativos=sumaNegativos/listaNumerosNegativos.length;
        System.out.println("La media de numeros positivos es: "+mediaPositivos);
        System.out.println("La media de numeros negativos es: "+mediaNegativos);
        System.out.println("La cantidad de ceros introducidos es: "+ceros);
    }
    public static void main(String[] args) {
        System.out.println("Bienvenido! escribe un numero del 1 al 9 para elegir uno de los diferentes modulos del programa. Escribe 0 para slir de este.");
        int numero=sc.nextInt();
        while (numero!=0){
            switch (numero) {
                case 1:
                leerNumeros();
                break;

                case 2:
                LeerNumerosAlReves();
                break;

                case 3:
                hacerMedias();
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
            System.out.println("");
            sc=new Scanner(System.in);
            System.out.println("Elige una nueva funcion(1-9) o sal del programa(0):");
            numero=sc.nextInt();
        }
    }
}
