public class ACT12 {
    
    public static void main(String[] args){
        System.out.println("Entre el 1 y el 100, los numeros que son divisibles entre 2 y 3 son:");
        for (int i=1;i<=100;i++){
            if (i%2==0 || i%3==0){
                System.out.println(i);
            }
        }
    }
}
