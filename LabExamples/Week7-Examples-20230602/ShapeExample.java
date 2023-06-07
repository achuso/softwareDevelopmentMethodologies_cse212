public class ShapeExample {
    public static void main(String[] args) {
        // This line of code will result in a compilation error
        //Shape shape = new Shape();

        Circle circle = new Circle(5.0);
        double area = circle.getArea();
        System.out.println("Area of circle with radius " + circle.getRadius() + " is " + area);
    }
}