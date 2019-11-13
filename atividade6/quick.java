import java.util.concurrent.Callable;

public class quick implements Callable<vetor> {

    int[] vet;
    int ini;
    int fim;
    vetor vetor;

    public quick(int[] v) {
        this.vet = v;
        this.ini = 0;
        this.fim = this.vet.length - 1;
        this.vetor = new vetor();
    }

    @Override
    public vetor call() throws Exception {
        quickSort(this.vet, this.ini, this.fim);

        this.vetor.setNomeFunc("QuickSort");
        this.vetor.setVet(this.vet);
        return vetor;
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

}