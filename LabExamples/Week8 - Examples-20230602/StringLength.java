
public class StringLength {
	
    public static void main(String[] args) {
    	
        try {
            String str = null;
            System.out.println(str.length());
            
        } catch (NullPointerException e) {
            //e.printStackTrace();
            
            System.out.println("Null pointer exception!");
        }
    }
}