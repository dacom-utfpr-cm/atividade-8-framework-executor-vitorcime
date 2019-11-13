import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class searchBigger {

    int[] vetor;
    int numThreads;

    ArrayList<Future<Integer>> tarefas;
    ExecutorService threadPool;

    public searchBigger(int[] vetor, int numThreads) {
        this.vetor = vetor;
        this.numThreads = numThreads;

        this.tarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(numThreads);

    }

    public void findBigger() {
        int first_Posi = 0;
        int last_Posi = this.vetor.length / this.numThreads;

        while (last_Posi <= this.vetor.length) {
            vetor tarefa = new vetor(first_Posi, last_Posi, this.vetor);

            Future<Integer> future = this.threadPool.submit(tarefa);
            this.tarefas.add(future);

            first_Posi = last_Posi;
            last_Posi += last_Posi;
        }

        for (Future<Integer> ft : this.tarefas) {
            while (!ft.isDone()) {
                System.out.print(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
            }
            System.out.println("");
        }

        int maxValue;
        try {
            maxValue = this.tarefas.get(0).get();
            for (Future<Integer> ft : this.tarefas) {
                if (maxValue < ft.get()) {
                    maxValue = ft.get();
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            
        }
        System.out.println("Maior Valor: "+maxValue);
        this.threadPool.shutdown();
    }

}