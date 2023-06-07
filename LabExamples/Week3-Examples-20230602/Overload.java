
public class Overload {
	
	void test() {
		System.out.println("No parameters");
	}
	
	// Overload test method for one integer parameter and it returns void
	void test(int a) {
		System.out.println("a: " + a);
	}
	
	// Overload test method for two integer parameter and it returns void
	void test(int a, int b) {
		System.out.println("a: " + a + " b: " + b);
	}
	
	// Overload test method for a double parameter and it returns double
	double test(double a) {
		System.out.println("double a: " + a);
		return a * a;
	}
}
