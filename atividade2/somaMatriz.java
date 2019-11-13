import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class somaMatriz {
    int[][] matriz;
    int numThreads;
    int sizeX;
    int sizeY;
    ArrayList<Future<Integer>> listTarefas;
    ExecutorService threadPool;

    public somaMatriz(int[][] matriz, int numThreads, int sizeX, int sizeY) {
        this.matriz = matriz;
        this.numThreads = numThreads;
        this.listTarefas = new ArrayList<>();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.threadPool = Executors.newFixedThreadPool(numThreads);
    }

    public void sumMatriz() {
        int posicao_Linha = 0;
        int somaTotal = 0;

        while (posicao_Linha < this.sizeX) {
            matriz tarefa = new matriz(posicao_Linha, this.sizeY, this.matriz);
            Future<Integer> future = this.threadPool.submit(tarefa);

            this.listTarefas.add(future);
            posicao_Linha++;
        }

        for (Future<Integer> ft : this.listTarefas) {
            while (!ft.isDone()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
            }
        }

        for (Future<Integer> ft : this.listTarefas) {
            try {
                somaTotal += ft.get();
            } catch (InterruptedException | ExecutionException ex) {
                
            }
        }
        
        this.threadPool.shutdown();
        System.out.println("Total: "+somaTotal);
        
    }
    
    
    
    
    
    
}