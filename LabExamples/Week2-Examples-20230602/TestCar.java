public class TestCar {

	public static void main(String[] args) {

		// create Car objects
		System.out.println("Creating Car objects");
		Car myCar = new Car("Toyota", 2011);
		Car myOtherCar = new Car("Porsche", 2010);

		//myCar.year = 2012;
		//private access
		myCar.setYear(2012);
		myCar.brand = "BMW";

		// call the ToString() method for the Car objects
		System.out.println(myCar);
		System.out.println(myOtherCar);

	}

}
