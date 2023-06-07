public class TestBox {
	
	public static void main(String args[]) {
		
		Box box1 = new Box();
		Box box2 = new Box();

		System.out.println("Number of objects = " + Box.numBoxes);
		System.out.println("Number of objects = " + box1.numBoxes);
		System.out.println("Number of objects = " + box2.numBoxes);

		Box.numBoxes = 10;
		Box box10 = new Box();
		System.out.println("Number of objects = " + box2.numBoxes);
		System.out.println("Number of objects = " + box10.numBoxes);
		// System.out.println("Width of the box = " + Box.width);
		
	}
	
}
