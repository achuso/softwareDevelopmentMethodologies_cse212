
public class CreateThread extends Thread{

    @Override
    public void run() {
    	
        for(int i = 0; i <= 5; i++)
            System.out.println("Running in thread " + i + "...");
    }

    public static void main(String[] args) {
    	
        CreateThread t1 = new CreateThread();
        
        t1.start();
        System.out.println("Not running in a thread...");

    }
}
