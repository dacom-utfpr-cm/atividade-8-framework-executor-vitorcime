

import java.util.Random;

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        int sizeX = 1000;
        int sizeY = 1000;
        int[][] matriz = new int[sizeY][sizeY];
        Random random = new Random();

        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                matriz[i][j] = random.nextInt(999);
            }
    }
    somaMatriz ex02 = new somaMatriz(matriz, 10, sizeX, sizeY);
    ex02.sumMatriz();
}
}