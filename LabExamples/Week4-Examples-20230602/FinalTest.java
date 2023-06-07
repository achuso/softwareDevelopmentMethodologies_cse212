
 public class FinalTest { // when a class is declared as final, it cannot be extended by a subclass

	public static void main(String[] args) {
		
		final int hourInDay = 24;
		System.out.println("Hours in a day: " + hourInDay);
		
		//hourInDay += 1; // when a variable is declared as final, its value cannot be changed once it has been initialized
		
		FinalTest t = new FinalTest();
		System.out.println(t.displayValue());
		
	}
	
	
	
	final int displayValue() {
		return 15;
	}

}




class Final extends FinalTest { 
	
	/*
	final int displayValue() { // when a method is declared as final, it cannot be overridden by a subclass
		return 10;
	}
	*/
}



