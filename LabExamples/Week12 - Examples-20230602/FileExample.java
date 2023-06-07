import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        // File path
        String filePath = "/Users/burcuselcuk/Downloads/example.txt";

        // Write to file
        writeToFile(filePath, "Hello, World!");

        // Read from file
        String content = readFromFile(filePath);
        System.out.println("File content: " + content);
    }

    public static void writeToFile(String filePath, String content) {
        try {
            File file = new File(filePath);

            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter(file);

            // Create a BufferedWriter object to write to the file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write content to the file
            bufferedWriter.write(content);

            // Close the resources
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File(filePath);

            // Create a FileReader object
            FileReader fileReader = new FileReader(file);

            // Create a BufferedReader object to read from the file
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

            // Close the resources
            bufferedReader.close();
            fileReader.close();

            System.out.println("Successfully read from the file: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }

        return content.toString();
    }
}
