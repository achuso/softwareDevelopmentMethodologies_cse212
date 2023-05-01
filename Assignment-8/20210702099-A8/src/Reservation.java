/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-8
 ***************************/

public class Reservation extends Services implements Comparable<Reservation> {
	
	private String hotelName;
	private Room room;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
	static int totalNumberOfReservations = 0;
	
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

		setReservationID(++totalNumberOfReservations);
	}
	
	@Override
	String getServiceType() {
		return "Room booking";
	}
	
	@Override
	double calculateService() {
		switch( getReservationMonth().toLowerCase() ) {
		// Double cost if reservation in June/July/August
		case "june": case "july": case "august":
			return 2 * room.getCost() * ( getReservationEnd() - getReservationStart() );
			
		// Otherwise regular prices apply
		default:
			return room.getCost() * ( getReservationEnd() - getReservationStart() );
		}
	}
	
	void displayInfo() {
		System.out.printf("\nReservation for a %s room in %s starts on "
				+ "%s %d and ends on "
				+ "%s %d. Reservation has a total cost of $%.0f.\n",
				this.getRoom().getRoomType(), this.getHotelName(),
				this.getReservationMonth(), this.getReservationStart(),
				this.getReservationMonth(), this.getReservationEnd(), this.calculateService()
				);
	}
	
	@Override
	public int compareTo(Reservation R) {
		// If alphabetically of higher order than R, return 1. If equal, return 0. Otherwise, return -1. Same return values like in string compareTo()
		int comparison = this.getHotelName().compareTo(R.getHotelName());
		return (comparison >= 0) ? ( (comparison == 0) ? 0 : 1) : -1;
	}
	
	
	// GETTERS FOR THE INSTANCE VARIABLES
	
	public String getHotelName() { return this.hotelName; }
	
	public Room getRoom() { return this.room;}
	
	public String getReservationMonth() { return this.reservationMonth; }	
	
	public int getReservationStart() { return this.reservationStart; }
	
	public int getReservationEnd() { return this.reservationEnd; }
	
	// SETTERS FOR THE INSTANCE VARIABLES
	
	public void setHotelName(String hotelName) { this.hotelName = hotelName; }
	
	public void setRoom(Room room) { this.room = room;}
	
	public void setReservationMonth(String reservationMonth) { this.reservationMonth = reservationMonth; }	
	
	public void setReservationStart(int reservationStart) { this.reservationStart = reservationStart; }
	
	public void setReservationEnd(int reservationEnd) { this.reservationEnd = reservationEnd; }

}
