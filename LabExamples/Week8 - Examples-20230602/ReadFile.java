import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void readFile(String filename) throws IOException{
		
	    try(BufferedReader br = new BufferedReader(new FileReader(filename))){
	    	
	        String line;
	        
	        while((line = br.readLine()) != null){
	            System.out.println(line);
	        }
	        
	    }catch(IOException e){
	    	
	        System.out.println("No such file");
	        //e.printStackTrace();
	
	    }
	}
	
    public static void main(String[] args) throws IOException {
    	
        readFile("fn");
        
        System.out.println("asdf");
    }



}
