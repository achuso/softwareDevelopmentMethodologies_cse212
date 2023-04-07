/*******************************************
 * CSE 212 Section 3
 * Assignment 5
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

public class Reservation {

	private Room room;
	
	private String hotelName;
	
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
	private int dailyCost;
	
	static int totalNumOfReservations = 0;
	
	// Constructor for if roomType is not given (menuInput == 1)
	public Reservation(String hN, String rM, int rS, int rE) {
		
		setRoom( new RoomSubclasses.Single() );
		
		setHotelName(hN);
		setReservationMonth(rM);
		setReservationStart(rS);
		setReservationEnd(rE);
		setDailyCost( getRoom().getCost() );
		
	}
	
	// Constructor for if the roomType is given (menuInput == 2)
	public Reservation(String roomType, String hN, String rM, int rS, int rE) {
		
		// Create Room depending on given roomType using .equals()
		if(roomType.toLowerCase().equals("single"))
			room  = new RoomSubclasses.Single();
		else if(roomType.toLowerCase().equals("double"))
			room  = new RoomSubclasses.Double(); 
		else if(roomType.toLowerCase().equals("club"))
			room  = new RoomSubclasses.Club(); 
		else if(roomType.toLowerCase().equals("family"))
			room  = new RoomSubclasses.Family(); 
		else if(roomType.toLowerCase().equals("family with view"))
			room  = new RoomSubclasses.FamilyView(); 
		else if(roomType.toLowerCase().equals("suite"))
			room  = new RoomSubclasses.Suite();
		
		setHotelName(hN);
		setReservationMonth(rM);
		setReservationStart(rS);
		setReservationEnd(rE);
		setDailyCost( getRoom().getCost() );
		
		++totalNumOfReservations;
		
	}

	public int calculateTotalPrice() {
		switch( getReservationMonth() ) {
			// Double cost if reservation in June/July/August
			case "June": case "July": case "August":
				return 2 * getDailyCost() * ( getReservationEnd() - getReservationStart() );
				
			// Otherwise regular prices apply
			default:
				return getDailyCost() * ( getReservationEnd() - getReservationStart() );
		}
	}
	
	public void displayInfo() {
		System.out.printf(
				"Reservation for a %s room in %s starts on %s %d"
				+ " and ends on %s %d. Reservation has a total cost of $%d.\n\n",
				this.getRoom().getRoomType(), this.getHotelName(), this.getReservationMonth(), this.getReservationStart(),
				this.getReservationMonth(), this.getReservationEnd(), this.calculateTotalPrice()
				);
	}
	
	
	// GETTERS FOR THE INSTANCE VARIABLES
	
	public Room getRoom() {return this.room;}
	
	public String getHotelName() {return this.hotelName;}
	
	public String getReservationMonth() {return this.reservationMonth;}	
	
	public int getReservationStart() {return this.reservationStart;}
	
	public int getReservationEnd() {return this.reservationEnd;}
	
	public int getDailyCost() {return this.dailyCost;}
	

	// SETTERS FOR THE INSTANCE VARIABLES
	
	public void setRoom(Room room) { this.room = room;}
	
	public void setHotelName(String hN) {this.hotelName = hN;}
	
	public void setReservationMonth(String rM) {this.reservationMonth = rM;}	
	
	public void setReservationStart(int rS) {this.reservationStart = rS;}
	
	public void setReservationEnd(int rE) {this.reservationEnd = rE;}
	
	public void setDailyCost(int dC) {this.dailyCost = dC;}
	
	
}