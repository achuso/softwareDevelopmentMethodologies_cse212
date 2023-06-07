public class Car implements LandVehicle {
    @Override
    public void start() {
        System.out.println("Starting the car");
    }

    @Override
    public void stop() {
        System.out.println("Stopping the car");
    }

    @Override
    public void drive() {
        System.out.println("Driving the car");
    }
}

