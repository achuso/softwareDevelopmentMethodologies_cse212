public class Car {

	// declare the fields
	public String brand;
	private int year;

	// define a constructor
	public Car(String brand, int year) {
		this.brand = brand;
		this.year = year;
		//declared variables are initialized
	}

	public void setYear(int year) {
		this.year = year;
	}

	// override the toString() method
	public String toString() {
		return "Brand is " + brand + ".\nBought in " + year;
	}


}