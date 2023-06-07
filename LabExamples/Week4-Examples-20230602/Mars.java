
// SUBCLASS
public class Mars extends Planet {

	public Mars() {
		
		super();
		this.name = "Mars";
		this.radius = 3389.5;
		this.surfaceGravity = 4;
		this.setMass(641693000000000000l);
		this.setVolume(163115609799l);
		this.satelliteCount = 2;
		this.hasAtmosphere = true;
		
	}
	
	
	public double orbitalSpeed() {
		
		double orbitalSpeed = 24.07;
		
		return orbitalSpeed;
		
	}
}
