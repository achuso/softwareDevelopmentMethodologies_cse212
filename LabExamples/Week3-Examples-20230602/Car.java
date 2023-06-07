
public class Car {

	private String brand;
	private String model;
	private CarClass type;
	
	public Car(String brand, String model, CarClass type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}
	
	public static void main(String[] args) {
		Car firstCar = new Car("Toyota", "Corolla", CarClass.SEDAN);
		Car secondCar = new Car("Bugatti", "Centodieci", CarClass.SPORTS);
		Car thirdCar = new Car("Ford", "Mustang", CarClass.MUSCLE);
		
		
		System.out.println(firstCar);
		System.out.println(secondCar);
		System.out.println(thirdCar);
		
	}
	
	@Override
	public String toString() {
		return "Car{" +
				"brand=" + brand + '\'' +
				"model=" + model + '\'' +
				"type=" + type +
				'}';
	}
}
