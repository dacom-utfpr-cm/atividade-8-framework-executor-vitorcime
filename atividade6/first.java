import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class first {

    Collection<Callable<vetor>> listTarefas;

    ExecutorService threadPool;
    int[] vet;

    public first(int[] vetorInt) {
        this.listTarefas = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(3);
        this.vet = vetorInt;
    }

    public void primeiro() {
        bubble bubb = new bubble(this.vet);
        heap heap = new heap(this.vet);
        quick quic = new quick(this.vet);

        this.listTarefas.add(bubb);
        this.listTarefas.add(heap);
        this.listTarefas.add(quic);

        vetor dados = null;

        while (dados == null) {
            try {
                dados = this.threadPool.invokeAny(this.listTarefas);
            } catch (InterruptedException | ExecutionException ex) {
                
            }
        }        
        System.out.println("Tipo de busca concluida mais rapido: " + dados.getNomeFunc());

        for (int i = 0; i < dados.getVet().length; i++) {
            System.out.print(" " + dados.getVet()[i]);
        }
        
        this.threadPool.shutdown();
    }

}