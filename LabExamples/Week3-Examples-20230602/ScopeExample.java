
public class ScopeExample {
	
	private static int staticVariable = 1;
	
	// not static
	private int instanceVariable = 2;

	
	public void methodWithLocalScope() {
		int localVariable = 3;
		// No way to reach outside of this method
		
		//System.out.println("Static variable: " + staticVariable);
		//System.out.println("Instance variable: " + instanceVariable);
		//System.out.println("Local variable: " + localVariable);
	}
	
	
	public static void main(String[] args) {
		ScopeExample example = new ScopeExample();
		
		example.methodWithLocalScope();
		int a = example.instanceVariable;
		//System.out.println("Instance Variable: " + a);
		
		//System.out.println("Static variable: " + ScopeExample.staticVariable);
		
		//System.out.println("Local variable: " + example.localVariable);

		
		
		Scope s = new Scope();
		System.out.println("x: " + s.getX());
	}
	

}
