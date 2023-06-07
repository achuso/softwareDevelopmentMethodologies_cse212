
public class Main {

	public static void main(String[] args) {
		
		
		Planet myPlanet = new Planet();
		System.out.println("Planet name: " + myPlanet.name);
		System.out.println("Planet has atmosphere?: " + myPlanet.hasAtmosphere);
		
		//myPlanet.displayInfo(); // parent class cannot reach the child's method
		
		
		System.out.println();
		Mars myMars = new Mars();
		System.out.println("Planet name: " + myMars.name);
		System.out.println("Mars mass: " + myMars.getMass());
		System.out.println("Mars volume: " + myMars.getVolume());
		myMars.calculateDensity();
		System.out.println("Mars orbital speed: " + myMars.orbitalSpeed());
		
		
		
		System.out.println();
		Mercury myMercury = new Mercury();
		System.out.println("Planet Name: " + myMercury.name);
		System.out.println("Mercury radius: " + myMercury.radius);
		System.out.println("Mercury satellite count: " + myMercury.satelliteCount);
		System.out.println("Has atmosphere?: " + myMercury.hasAtmosphere);
		myMercury.calculateDensity();
		System.out.println("Mercury orbital speed: " + myMercury.orbitalSpeed());
		
		
		
		System.out.println();
		Earth myEarth = new Earth();
		System.out.println("Planet name: " + myEarth.name);
		System.out.println("Shape: " + myEarth.shape);
		myEarth.calculateDensity();
		System.out.println("Earth orbital speed: " + myEarth.orbitalSpeed());
		
		System.out.println();
		myEarth.displayInfo();
		
		System.out.println();
		System.out.println("Display Type after modification: " + myEarth.displayType());
		

	}

}
