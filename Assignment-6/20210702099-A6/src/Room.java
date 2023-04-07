/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

public class Room {
	
	private String roomType;
	private int dailyCost;
	private int roomSize;
	private Boolean hasBath;
	
	// Getter and Setter for dailyCost
	public void setCost(int x) {this.dailyCost = x;}
	public int getCost() {return dailyCost;}

	// Getters for every other instance variable
	public int getRoomSize() {return this.roomSize;}
	public String getRoomType() {return this.roomType;} 
	public Boolean getHasBath() {return this.hasBath;} 
	
	Room(String roomType, int dailyCost, int roomSize, Boolean hasBath) {
		
		this.roomType = roomType;
		
		setCost(dailyCost);
		
		this.roomSize = roomSize;
		
		this.hasBath = hasBath;
		
	}
	
}
