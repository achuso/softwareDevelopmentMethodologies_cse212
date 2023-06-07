
public class MyThreadTest {

    public static void main(String[] args) {

        // Create a new instance of MyThread
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();

        // Calling the start() method
        thread.start();
        thread2.start();

        // Calling the run() method
        //thread.run();
        //thread2.run();
        //no benefits of multithreading
    }
}
