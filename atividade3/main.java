import java.util.Random;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        Random random = new Random();
        int sizeX = 5;
        int sizeY = 5;
        int[][] matriz = new int[sizeY][sizeY];
        
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                matriz[i][j] = random.nextInt(999);
            }
    }
    multiMatriz ex03 = new multiMatriz(matriz, matriz, sizeX);
    ex03.multiMatriz();
}

}