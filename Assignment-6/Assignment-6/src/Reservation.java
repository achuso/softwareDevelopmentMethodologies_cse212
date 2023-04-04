/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

public class Reservation extends Services {
	
	private String hotelName;
	private Room room;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
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

	}
	
	@Override
	String getServiceType() {
		return "Reservation";
	}
	
	@Override
	double calculateService() {
		switch( getReservationMonth() ) {
		// Double cost if reservation in June/July/August
		case "June": case "July": case "August":
			return 2 * room.getCost() * ( getReservationEnd() - getReservationStart() );
			
		// Otherwise regular prices apply
		default:
			return room.getCost() * ( getReservationEnd() - getReservationStart() );
		}
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
