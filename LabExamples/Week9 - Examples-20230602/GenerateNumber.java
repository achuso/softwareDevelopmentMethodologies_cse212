
// importing class Random to generate a random number as input
import java.util.Random;

public class GenerateNumber {
	
    void func(int n)
    {
        try {
  
            // this will throw ArithmeticException if n is 0
            int x = 10 / n;
            int y[] = new int[n];
            y[x] = 10;
            
            System.out.println("x: " + x);
            System.out.println("n: " + n);
  
            // this will throw ArrayIndexOutOfBoundsException
            // if the value of x surpasses
            // the highest index of this array
            System.out.println("No exception was thrown");
        }
        
        catch (Exception e) {
        	
            if (e instanceof ArithmeticException)
                System.out.println("Can't divide by 0");
            
            if (e instanceof ArrayIndexOutOfBoundsException)
                System.out.println("This index doesn't exist in this array");
        }
    }
    
    public static void main(String a[])
    {
    	int generatedNumber = new Random().nextInt(10);
    	System.out.println("Generated number(n): " + generatedNumber);
        new GenerateNumber().func(generatedNumber);
    }
}