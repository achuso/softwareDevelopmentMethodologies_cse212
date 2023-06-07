package myAbstract;

class Triangle extends Figure { 
	
	Triangle(double a, double b) { 
	
		super(a, b); 

	} 
	
	// implements area for right triangle 
	double area() { 
	
		System.out.println("Inside Area for Triangle."); 
		return dim1 * dim2 / 2; 

	} 
	
	
	double circumference() {
		
		double powSum = Math.pow(dim1, 2) + Math.pow(dim2, 2);
		return Math.sqrt(powSum) * 2 + dim2;
		
		
	}
}