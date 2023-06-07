
// SUBCLASS
public class Mercury extends Planet {

	public Mercury() {
		
		super(); 
		this.name = "Mercury";
		this.radius = 2439.7;
		this.surfaceGravity = 4;
		this.setMass(330104000000000000l);
		this.setVolume(60827208742l);
		this.satelliteCount = 0;
		this.hasAtmosphere = false;
		
	}
	
	
	public double orbitalSpeed() {
		
		double orbitalSpeed = 47.36;
		
		return orbitalSpeed;
		
	}
	
}
