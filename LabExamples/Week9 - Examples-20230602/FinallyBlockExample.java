
public class FinallyBlockExample {

	public static void main(String[] args) {
        
		try {
            
			int result = divide(200, 0);
            System.out.println("Result: " + result);
        
		} catch(ArithmeticException e) {
            
			System.out.println("Exception caught: " + e);
        
		} catch(Exception en){
            
			System.out.println("Another exception caught: " + en);
        }
        
		finally {
            
			System.out.println("Finally block is executed");
        }
    }

    public static int divide(int numerator, int denominator){
        
    	try {
            
    		return numerator / denominator;
        
    	} catch (Exception e) {
            
    		System.out.println("Exception caugth in divide(): " + e);
            return -1;
        }

    }

}
