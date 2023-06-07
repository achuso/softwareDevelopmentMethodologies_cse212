import java.util.TreeSet;

public class Car implements Comparable<Car> {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Car otherCar) {
    	
        if (this.year < otherCar.year) {
            return -1;
            
        } else if (this.year > otherCar.year) {
            return 1;
            
        } else {
            int makeCompare = this.make.compareTo(otherCar.make);
            
            if (makeCompare != 0) {
                return makeCompare;
            } else {
                return this.model.compareTo(otherCar.model);
            }
        }
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }

    public static void main(String[] args) {
        // Create a new TreeSet of Car objects
        TreeSet<Car> carSet = new TreeSet<>();

        // Add some cars to the set
        carSet.add(new Car("Toyota", "Corolla", 2022));
        carSet.add(new Car("Honda", "Civic", 2021));
        carSet.add(new Car("Tesla", "Model S", 2020));
        carSet.add(new Car("Ford", "Mustang", 2019));
        
        // Duplicates will not be inserted
        carSet.add(new Car("Ford", "Mustang", 2019));

        // Print the cars in the set (sorted by year, make, and model)
        System.out.println("Cars in the set:");
        for (Car car : carSet) {
            System.out.println(car);
        }

        System.out.println("--------------");

        // Find the first and last cars in the set (sorted by year, make, and model)
        Car firstCar = carSet.first();
        Car lastCar = carSet.last();

        // Print the first and last cars in the set
        System.out.println("First car: " + firstCar);
        // Even though we have added it the last


        System.out.println("Last car: " + lastCar);
        // Even if it was the one to be added first
    }
}
