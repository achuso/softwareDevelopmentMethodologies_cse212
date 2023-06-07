
// SUBCLASS
public class Earth extends Planet {

	public Earth() {
		
		super();
		this.name = "Earth";
		this.radius = 6371.0;
		this.surfaceGravity = 10;
		this.setMass(5972190000000000000l);
		this.setVolume(1083206916846l);
		this.satelliteCount = 1;
		this.hasAtmosphere = true;
		
	}
	
	
	public double orbitalSpeed() {
		
		double orbitalSpeed = 29.7827;
		
		return orbitalSpeed;
		
	}
	
	public void displayInfo() {
		
		System.out.println("Name: " + this.name);
		System.out.println("Radius: " + this.radius);
		System.out.println("Surface Gravity: " + this.surfaceGravity);
		System.out.println("Mass: " + this.getMass());
		System.out.println("Volume: " + this.getVolume());
		System.out.println("Satellite Count: " + this.satelliteCount);
		System.out.println("Has Atmosphere?: " + this.hasAtmosphere);
		
	}
	
	public String displayType() {
		
		System.out.println("Display Type after super() call: " + super.displayType());
		return "Planet Earth";
		
	}
	
}
