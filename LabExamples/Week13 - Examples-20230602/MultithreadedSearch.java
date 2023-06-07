import java.util.List;
import java.util.concurrent.*;

public class MultithreadedSearch {
	
    private static final int THREAD_POOL_SIZE = 4;
    //How many threads will be used?

    public static void main(String[] args) {
        // Create a list of numbers to search
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5); //5

        // Create a thread pool executor with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // Create a concurrent result container to store the search results
        ConcurrentLinkedQueue<Integer> searchResults = new ConcurrentLinkedQueue<>();
        //Something like a queue, works in FIFO but thread-safe

        // Create a search value
        int searchValue = 5;

        // Submit search tasks to the executor
        for (Integer number : numbers) {
        	// Send code (runnable task) to executor as an argument
            executor.submit(() -> {
                if (number == searchValue) {
                    searchResults.add(number);
                }
            });
        }

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        
        try {
        	// Wait until all threads terminate
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the search results
        System.out.println("Search results:");
        for (Integer result : searchResults) {
            System.out.println(result);
        }
    }
}
