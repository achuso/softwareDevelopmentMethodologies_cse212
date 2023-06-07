package myAbstract;

//Using abstract methods and classes. 
public abstract class Figure { 
	
	double dim1; 
	double dim2; 
	
	Figure(double a, double b) { 
		
		this.dim1 = a; 
		this.dim2 = b; 
		
	} 
	
	//area is now an abstract method 
	abstract double area();
	
	
	double circumference() {
		
		return 0.0;
		
	}
	
}