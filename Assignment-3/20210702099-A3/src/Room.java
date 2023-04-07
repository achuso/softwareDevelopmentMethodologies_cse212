/*******************************************
 * CSE 212 Section 3
 * Assignment 3
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/


public class Room {
	
	String roomType;
	private int dailyCost;
	int roomSize;
	Boolean hasBath;
	
	// lower-case 'r' at the end to distinguish it easier from Reservation's dailyCost getter/setters that end with "R"
	public void setCost_r(int x) {this.dailyCost = x;}
	public int getCost_r() {return dailyCost;}
	
	// getters for the other variables
	public int getRoomSize() {return this.roomSize;}
	public String getRoomType() {return this.roomType;} // unused, may need for next assignment
	public Boolean getHasBath() {return this.hasBath;} // unused, may need for next assignment
	
	
	Room(String roomType, int dailyCost, int roomSize, Boolean hasBath) {
		
		this.roomType = roomType;
		
		setCost_r(dailyCost);
		
		this.roomSize = roomSize;
		
		this.hasBath = hasBath;
		
	}
	
}
