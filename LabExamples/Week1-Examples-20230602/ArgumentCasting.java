
public class ArgumentCasting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Compile-time error: possible loss of precision with  int z = 2.4;  
		int z = (int) 2.4; // Cast the double 2.4 to int; loss of precision: z = 2
		System.out.println("Value of z:" + z);


	}

}
