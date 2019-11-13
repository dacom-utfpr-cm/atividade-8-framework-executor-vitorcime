import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class multiMatriz {

    int[][] matriz01;
    int[][] matriz02;
    int sizeXY;
    int[][] matrizResult;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;

    public multiMatriz(int[][] matriz01, int[][] matriz02, int sizeXY) {
        this.matriz01 = matriz01;
        this.matriz02 = matriz02;
        this.sizeXY = sizeXY;

        this.threadPool = Executors.newFixedThreadPool(sizeXY);
        this.listTarefas = new ArrayList<>();
    }

    public void multiMatriz() {

        for (int i = 0; i < this.sizeXY; i++) {
            for (int j = 0; j < this.sizeXY; j++) {

                multiplicacao tarefa = new multiplicacao(this.matriz01, this.matriz02, i, j, this.sizeXY);

                Future<Integer> future = this.threadPool.submit(tarefa);
                this.listTarefas.add(future);
            }
        }

        for (Future<Integer> ft : this.listTarefas) {
            while (!ft.isDone()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    
                }
            }
        }

        int countAux = 0;
        for (Future<Integer> ft : this.listTarefas) {
            try {
                System.out.print(" " + ft.get());
                countAux++;
                if (countAux >= this.sizeXY) {
                    System.out.println();
                    countAux = 0;
                }

            } catch (InterruptedException | ExecutionException ex) {
                
            }
        }
        
        
        this.threadPool.shutdown();
    }

}