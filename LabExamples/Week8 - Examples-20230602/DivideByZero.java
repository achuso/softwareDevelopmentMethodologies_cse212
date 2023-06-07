
public class DivideByZero {

    public static void main(String[] args){
    	
        try {
            divideByZero();
        }
        catch(ArithmeticException e){
            System.out.println("You can't divide by 0!");
        	
        	
            //e.printStackTrace();
            
            
            //shows the sequence of method calls that led to the exception being thrown.


        }
        

        System.out.println("asdf");


    }
    //The stack trace shows that the exception occurred in the divideByZero() method, which was called by the main() method.
    // The line numbers where the exception occurred are also shown.
    // By examining the stack trace, you can identify the exact location where the exception occurred and take measures to handle it.
    private static void divideByZero() {
        int a = 20;
        int b = 0;
        int result = a / b;
        System.out.println(result);
    }
}
