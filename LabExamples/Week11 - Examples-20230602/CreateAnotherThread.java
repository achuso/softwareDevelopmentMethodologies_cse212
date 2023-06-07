
public class CreateAnotherThread implements Runnable{

    public static void main(String[] args) {
        CreateAnotherThread anotherThread = new CreateAnotherThread();
        Thread t1 = new Thread(anotherThread);
        
        t1.start();
        
        // If the class extends the Thread class, 
        // the thread can be run by creating an instance of the class 
        // and call its start() method

        System.out.println("Not running in a thread...");
    }
    
    @Override
    public void run() {
        for(int i = 0; i <= 5; i++)
            System.out.println("Running in thread " + i + "...");
    }

    //Difference?
    //MyClass extends OtherClass implements Runnable
}
