class Box {

	double width;
	public static int numBoxes = 0; // static variable is declared and
									// initialized

	public Box() {
		width = 5.0;
		numBoxes++; // numBoxes is incremented to count number of objects.
	}

}