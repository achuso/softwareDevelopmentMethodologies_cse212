public class ExceptionThrowing {

    public static void main(String[] args) {
        int [] numbers = {0, 1, 2};

        try{
            System.out.println(numbers[3]);
            
        }catch(Exception e){
        	
        	//e.printStackTrace();
        	
            System.out.println("Out of bounds!");
        }
    }
}
