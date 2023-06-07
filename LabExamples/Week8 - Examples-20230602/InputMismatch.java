import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
	
    public static void main(String[] args) throws InputMismatchException{
    	
        Scanner scanner = new Scanner(System.in);
        
        
        try {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            System.out.println("You entered: " + num);
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
        scanner.close();
    }
}