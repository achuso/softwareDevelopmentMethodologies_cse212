package myDowncasting;

public class TestMyDowncasting {

	
	public static void getAppointment(Animal a) {

		if ( a instanceof Cat) {

			Cat c = (Cat) a;
			c.goHunting();

		}

	}
	
	public static void main(String[] args) {
		
		Animal myCat=new Cat();
		
		getAppointment(myCat);
		
		
		
		
		// Upcasting
		Cat myCat1 = new Cat();
		
		myCat1.goHunting();
		
		Animal animal = myCat1;
		
//		animal.goHunting();
		
		
	}

}
