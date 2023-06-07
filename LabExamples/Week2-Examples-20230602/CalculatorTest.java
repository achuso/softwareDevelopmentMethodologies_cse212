public class CalculatorTest {

    public static void main(String[] args) {
        System.out.println(Calculator.add(2, 3));
        System.out.println(Calculator.add(2, 3, 4));
        System.out.println(Calculator.add(2.11, 3.22));


        int i = Calculator.add(4, 5);
        System.out.println(i);
    }
}
