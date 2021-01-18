public class ACT24 {
    
    public static void main(String[] args){

        String frase="La lluvia en Sevilla es una maravilla";
        for (int i=0;i<frase.length();i++){
            char caracter=frase.charAt(i);
            int codigoASCII=(int)caracter;
            System.out.print(codigoASCII+" ");
        }
    }
}
