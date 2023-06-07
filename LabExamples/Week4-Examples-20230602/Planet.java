
// SUPERCLASS
public class Planet {

	String name;
	String shape;
	double radius;
	short surfaceGravity;
	private long mass;
	private long volume;
	int satelliteCount = 0;
	boolean hasAtmosphere = false;
	
	public Planet() {
		
		this.shape = "Circle";
		
	}
	
	
	public long getMass() {
		return mass;
	}

	public void setMass(long mass) {
		this.mass = mass;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}
	
	
	public void calculateDensity() {
		
		double density = getMass() / getVolume();
		System.out.println("The density of " + this.name + " is = " + density);
		
	}
	
	public double orbitalSpeed() {
		
		return 0.0;
		
	}
	
	public String displayType() {
		
		return "Planet";
		
	}
}
