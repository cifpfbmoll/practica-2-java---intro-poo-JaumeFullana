public class ACT22 {
    
    public static void main(String[] args){

        String frase="La lluvia en Sevilla es una maravilla";
        int numeroVocales=0;
        for (int i=0;i<frase.length();i++){
            char caracter=frase.charAt(i);
            String charStr=String.valueOf(caracter);
            if (charStr.equals("a") || charStr.equals("e") || charStr.equals("i") || charStr.equals("o") || charStr.equals("u") ){
                numeroVocales++;
            }
        }
        System.out.println("El numero de vocales en la frase es: "+numeroVocales);
    }
}
