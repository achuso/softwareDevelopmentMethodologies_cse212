import java.util.List;
import java.util.concurrent.*;

public class MultithreadedStringSearch {
	
    private static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        // Create a list of strings to search
        List<String> strings = List.of("apple", "banana", "orange", "kiwi", "grape");

        // Create a thread pool executor with a fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // Create a concurrent result container to store the search results
        ConcurrentLinkedQueue<String> searchResults = new ConcurrentLinkedQueue<>();

        // Create a search query
        String searchQuery = "an";

        // Submit search tasks to the executor
        for (String str : strings) {
            executor.submit(() -> {
                if (str.contains(searchQuery)) {
                	// str.compareToIgnoreCase(searchQuery)
                    searchResults.add(str);
                }
            });
        }

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the search results
        System.out.println("Search results:");
        for (String result : searchResults) {
            System.out.println(result);
        }
    }
}
