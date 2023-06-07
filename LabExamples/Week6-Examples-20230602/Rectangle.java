package myAbstract;

class Rectangle extends Figure { 
	
	Rectangle(double a, double b) { 
		
		super(a, b); 
		
	} 
	
	// implements area for rectangle 
	double area() { 
		
		System.out.println("Inside Area for Rectangle."); 
		return dim1 * dim2; 
		
	} 
	
	
	double circumference() {
		
		return dim1 * 2 + dim2 * 2;
		
		
	}
}