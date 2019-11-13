import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class agenda {
    ScheduledExecutorService executor;
    ScheduledFuture scheduleFuture;
    int timeSeconds;
    fazNada task;

    public agenda(int timeSeconds) {
        this.timeSeconds = timeSeconds;
        this.executor = Executors.newScheduledThreadPool(1);
        this.task = new fazNada();

        System.out.println("Tarefa Agendada para daqui " + timeSeconds + "s");
        this.scheduleFuture = this.executor.schedule(this.task, timeSeconds, TimeUnit.SECONDS);

        while (!this.scheduleFuture.isDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
        
        System.out.println("Acabou ;)");
        this.executor.shutdown();
    }
    
    
    
    
    
    
}