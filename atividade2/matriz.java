import java.util.concurrent.Callable;

public class matriz implements Callable<Integer> {

    int linha;
    int tamColuna;
    int[][] matriz;

    public matriz(int linha, int tamColuna, int[][] matriz) {
        this.linha = linha;
        this.tamColuna = tamColuna;
        this.matriz = matriz;   
    }
    
    @Override
    public Integer call() throws Exception {
        int somaColuna=0;

        for(int i=0;i<this.tamColuna;i++){
            somaColuna += this.matriz[this.linha][i]; 
        }
        
        return somaColuna;
    }
    
}