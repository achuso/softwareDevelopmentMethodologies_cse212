package myAbstract;

class AbstractAreas { 

	public static void main(String args[]) { 
		
		//Figure f = new Figure(10, 10); // illegal now 
		Rectangle r = new Rectangle(9, 5); 
		Triangle t = new Triangle(10, 8); 
		
		
		
		Figure figrf; // this is OK, no object is created 
		//figrf = new Rectangle(9,5);
		
		
		figrf = r; 
		System.out.println("Area is " + figrf.area());
		System.out.println("Circumference is " + figrf.circumference());
		
		System.out.println(figrf instanceof Figure); 
		System.out.println(figrf instanceof Rectangle); 
		System.out.println(figrf instanceof Triangle); 
		
		
		figrf = t; 
		System.out.println("Area is " + figrf.area());
		System.out.println("Circumference is " + figrf.circumference());
		
		System.out.println(figrf instanceof Figure); 
		System.out.println(figrf instanceof Rectangle); 
		System.out.println(figrf instanceof Triangle);
		
	} 
}