
public class SynchronizedRaceCondition extends Thread {
    
	public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
    	
        SynchronizedRaceCondition thread = new SynchronizedRaceCondition();
        thread.start();

        //use the synchronized keyword to lock on the SynchronizedRaceCondition class object
        //print the current value of the count variable.
        
        
	     // Only one thread can execute at a time. 
	     // SynchronizedRaceCondition.class is a reference to an object
	     // whose lock associates with the monitor. 
	     // The code is said to be synchronized on
	     // the monitor object
        
        synchronized(SynchronizedRaceCondition.class) {
        	// Access shared variables and other
        	// shared resources
        	
        	System.out.println("Second: " + count);
            count++;
            System.out.println("Second: " + count);
            //then increment the count variable and print the new value
        }
        
        // run()
        //thread.run();
        thread.join();
   
        synchronized(SynchronizedRaceCondition.class) {
        	System.out.println("Third: " + count);
        }
    }

    public void run() {
        
    	synchronized(SynchronizedRaceCondition.class) {
            count+=3;
            System.out.println("First: " + count);
        }
    }
    
}

