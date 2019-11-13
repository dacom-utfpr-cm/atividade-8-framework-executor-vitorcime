import java.util.concurrent.Callable;

public class bubble implements Callable<vetor> {

    int[] v;
    vetor vetor;

    public bubble(int[] vet) {
        this.v = vet;
        this.vetor = new vetor();
    }

    @Override
    public vetor call() throws Exception {

        for (int i = v.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1] > v[j]) {
                    int aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
        
        this.vetor.setNomeFunc("BubbleSort");
        this.vetor.setVet(this.v);
        return this.vetor;
    }

}