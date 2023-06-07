
public class OverloadTest {

	public static void main(String[] args) {
		Overload od = new Overload();
		double result;
		
		// Call all versions of test()
		od.test();
		od.test(10);
		od.test(10, 20);
		result = od.test(123.2);
		System.out.println("Result of od.test(123.2): " + result);

	}

}
