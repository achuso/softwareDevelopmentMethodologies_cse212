
public class Scope {
	
	private int x = 1;
	

	public void begin() {
		
		
		int x = 5; // method's local variable x shadows field x
		System.out.printf("local x in method in the beginning is %d\n", x);
		useLocalVariable(); // useLocalVariable() has local x
		
		//x = 6;
		useField(); // useField() uses class Scope's field x, x is not initialized in useField(), just called
		useLocalVariable(); // useLocalVariable reinitialized local x
		useField(); // class Scope's field x retains its value, previously assigned to 10
		useField();
		System.out.printf("\nlocal x in method begin is %d\n", x);
		
	}
	
	public void useLocalVariable() {
		
		int x = 25; // initialized each time useLocalVariable is called
		System.out.printf("\nlocal x on entering method useLocalVariable is %d\n", x);
		++x; // modifies this method's local variable x
		System.out.printf("local x before exiting method useLocalVariable is %d\n", x);
	}
	
	public void useField() {
		
		System.out.printf("\nfield x on entering method useField is %d\n", x);
		x *= 10; // modifies class Scope's field x
		System.out.printf("field x before exiting method useField is %d\n", x);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	
	public static void main(String[] args) {
		Scope scope = new Scope();
		scope.begin();
		
		
	}
}
