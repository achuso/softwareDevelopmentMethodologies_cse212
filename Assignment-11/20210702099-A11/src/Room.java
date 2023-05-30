/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-11
 ***************************/

public class Room {
	
	private String roomType;
	private int dailyCost;
	private int roomSize;
	private Boolean hasBath;
	

	public void setCost(int x) {this.dailyCost = x;}
	public void setRoomSize(int size) { this.roomSize = size; }
	public void setRoomType(String type) { this.roomType = type; }
	public void setHasBath(Boolean bath) { this.hasBath = bath; }

	public int getCost() {return dailyCost;}
	public int getRoomSize() {return this.roomSize;}
	public String getRoomType() {return this.roomType;} 
	public Boolean getHasBath() {return this.hasBath;} 
	
	Room(String roomType, int dailyCost, int roomSize, Boolean hasBath) {
		
		setRoomType(roomType);
		
		setCost(dailyCost);
		
		setRoomSize(roomSize);
		
		setHasBath(hasBath);
		
	}
	
}
