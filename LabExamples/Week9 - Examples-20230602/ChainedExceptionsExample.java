
public class ChainedExceptionsExample {

    public static void someMethod(){
        
    	int a = 10 / 0; //ArithmeticException triggered originally
        System.out.println(a);
    }

    public static void someOtherMethod() throws Exception {
        
    	try {
            someMethod();
            
    		
    		
    		/*
            // Creating an exception
            NumberFormatException ex = new NumberFormatException("Exception");
 
            // Setting a cause of the exception
            ex.initCause(new NullPointerException("This is actual cause of the exception"));
 
            // Throwing an exception with cause.
            throw ex;
            */
            
            
            
        }catch(ArithmeticException e){
            
        	throw new Exception("Exception in someOtherMethod() ", e);
        }
    }

    public static void main(String[] args) {
        
    	try{
            
        	someOtherMethod();
        
        }catch (Exception e){
            
        	System.out.println("Exception caught: " + e);
            System.out.println("\nOriginal cause: " + e.getCause());
        }
    }

}
