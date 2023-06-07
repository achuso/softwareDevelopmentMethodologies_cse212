
public class RaceCondition extends Thread {
    
	public static int count = 0;

    public static void main(String[] args) {
        RaceCondition thread = new RaceCondition();
        
        //thread.run();
        thread.start();

        System.out.println(count);
        count++;
        System.out.println(count);
    }

    public void run() {
        count+=3;
    }
}


/*
* two threads t1 t2
* two threads try to access the "count" var at the same time
* read val of count and increment it by 0 -> 1 -> 2
* 0 -> 2
 */

