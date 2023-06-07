
public class ArgumentPromotion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 3.14 + 10; /* 10 is promoted to a double */
		double y = 12; /* 12 is promoted to a double then assigned */
		System.out.printf("%s","Value of x:"+x);
		System.out.println();
		System.out.printf("%s","Value of y:"+y);
		
		
		System.out.println();
		System.out.printf("%.04f", x);
		


	}

}
