
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFinallyExample {

    public static void main(String[] args) throws FileNotFoundException  {
        
    	BufferedReader reader = null;
    	
    	// finding the current folder - the files must be under the project folder, not src
    	System.out.println("Current folder: " + System.getProperty("user.dir"));
    	
    	try{
            
    		String strCurrentLine;
    		File myFile = new File("cse212.txt");
    		
    		if (myFile.exists())
    		    System.out.println("File exists");
    		
    		else
    			System.out.println("File does not exist");
    		
    		reader = new BufferedReader(new FileReader("cse212.txt"));
    		
    		// read the file line by line
    		while((strCurrentLine = reader.readLine()) != null) {
    			
    			System.out.println(strCurrentLine);
    		}
    		
            //read data from txt file
        
    	}catch (IOException e){
            
    		System.out.println("FileNotFoundException: " + e.getMessage());
    		//e.printStackTrace();
    		
    	}
    	
    	finally {
            
    		if(reader != null){
                
    			try{
                    
    				reader.close();
                
    			} catch (IOException e) {
                    
    				System.out.println("Exc: " + e);
                }
            }
    		
    		else {
    			
    			System.out.println("File not found");
    		}
    		
    		
        }
    }

}
