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
        Double numerosPositivos=0.0;
        Double numerosNegativos=0.0;
        int cantidadPositivos=0;
        int cantidadNegativos=0;
        int ceros=0;
        for (int i=0;i<5;i++){
            System.out.println("Escribe un numero entero, positivo o negativo.");
            Double numero=sc.nextDouble();
            if (numero>=0){
                cantidadPositivos++;
                numerosPositivos+=numero;
                if (numero==0){
                    ceros++;
                }
            }
            else {
                cantidadNegativos++;
                numerosNegativos+=numero;
            }
        }
        Double mediaPositivos=numerosPositivos/cantidadPositivos;
        Double mediaNegativos=numerosNegativos/cantidadNegativos;
        System.out.println("La media de numeros positivos es: "+mediaPositivos);
        System.out.println("La media de numeros negativos es: "+mediaNegativos);
        System.out.println("La cantidad de ceros introducidos es: "+ceros);
    }

    public static int contarCaracteres(String texto) {
        String textoSinEspacios=texto.replace(" ", "");
        return textoSinEspacios.length();
    }

    public static String girarTexto(String texto) {
        String textoAlReves="";
        for (int i=texto.length()-1;i>=0;i--){
            textoAlReves+=texto.charAt(i);
        }
        return textoAlReves;
    }

    public static String quitarEspacios(String texto) {
        String textoSinEspacios=texto.replace(" ", "");
        return textoSinEspacios;
    }

    public static String concatenarTexto(String texto1, String texto2) {
        String textoConcatenado=texto1.concat(texto2);
        return textoConcatenado;
    }

    public static void cambiarVocales(String texto, String vocal) {
        texto=texto.replace("a", vocal);
        texto=texto.replace("e", vocal);
        texto=texto.replace("i", vocal);
        texto=texto.replace("o", vocal);
        texto=texto.replace("u", vocal);
        System.out.println(texto);
    }

    public static void codigoCaracteres(String texto) {
        for (int i=0;i<texto.length();i++){
            System.out.println("El codigo ASCII del caracter "+texto.charAt(i)+" es "+(int) texto.charAt(i));
        }
    }
    public static void main(String[] args) {
        System.out.println("Bienvenido! escribe un numero del 1 al 9 para elegir uno de los diferentes modulos del programa. Escribe 0 para slir de este.");
        int numero=sc.nextInt();
        sc.nextLine();
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
                System.out.println("Escribe una palabra o frase.");
                String texto4=sc.nextLine();
                int numeroCaracteres=contarCaracteres(texto4);
                System.out.println("El texto, sin contar espacios, contiene "+numeroCaracteres+" caracteres.");
                break;

                case 5:
                System.out.println("Escribe una palabra o frase.");
                String texto5=sc.nextLine();
                String textoGirado=girarTexto(texto5);
                System.out.println("El texto girado quedaria asi: "+textoGirado);
                break;

                case 6:
                System.out.println("Escribe una palabra o frase.");
                String texto6=sc.nextLine();
                String textoSinEspacios=quitarEspacios(texto6);
                System.out.println("El texto sin espacios quedaria asi: "+textoSinEspacios);
                break;

                case 7:
                System.out.println("Escribe una palabra o frase.");
                String texto7a=sc.nextLine();
                System.out.println("Escribe otra palabra o frase.");
                String texto7b=sc.nextLine();
                String textoConcatenado=concatenarTexto(texto7a, texto7b);
                System.out.println("Los dos textos concatenados quedan asi: "+textoConcatenado);
                break;

                case 8:
                System.out.println("Escribe una palabra o frase.");
                String texto8=sc.nextLine();
                System.out.println("Escribe una vocal.");
                String vocal=sc.nextLine();
                cambiarVocales(texto8, vocal);
                break;

                case 9:
                System.out.println("Escribe una palabra o frase.");
                String texto9=sc.nextLine();
                codigoCaracteres(texto9);
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
            sc.nextLine();
        }
    }
}
