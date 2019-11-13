import java.util.Random;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        Random random = new Random();
        
        int[] vetor = new int[1000];
        
        for(int i=0;i<1000;i++){
            vetor[i] = random.nextInt(5000);
        }
    
    searchBigger ex01 = new searchBigger(vetor, 10);
    ex01.findBigger();
}
}