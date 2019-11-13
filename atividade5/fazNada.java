

public class fazNada implements Runnable {

    @Override
    public void run() {
       System.out.println("Começou");
        try {
        Thread.sleep(2000);  
       } catch (Exception e) {
           //TODO: handle exception
       } 
    }

   
}