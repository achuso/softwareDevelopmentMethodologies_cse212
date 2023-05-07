/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation extends Services implements Comparable<Reservation> {
	
	private String hotelName;
	private Room room;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
	static int totalNumberOfReservations = 0;
	
	public Reservation(Scanner in) throws RoomTypeException, InputMismatchException {
		
		// Display the room options
		System.out.printf("\nROOM INFOS:\n\n");
		for(RoomTypes room: RoomTypes.values())
			System.out.printf("Room Type: %s, Daily Cost: %d, Room Size: %d, Has Bath: %b \n",
					room.getRoomType(), room.getDailyCost(), room.getRoomSize(), room.getHasBath() );
						
		// Receive input for reservation creation
		System.out.printf("\nHotel Name: ");
		this.setHotelName(in.nextLine());
		
		String rT; // String placeholder for roomType to be put in constructor
		while(true) {
			try {
				System.out.printf("Room Type: ");
				rT = in.nextLine();
				RoomTypeException.checkRoomType(rT);
				
				if(rT.compareToIgnoreCase(RoomTypes.SINGLE.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.Single());
				else if (rT.compareToIgnoreCase(RoomTypes.DOUBLE.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.Double());
				else if (rT.compareToIgnoreCase(RoomTypes.CLUB.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.Club());
				else if (rT.compareToIgnoreCase(RoomTypes.FAMILY.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.Family());
				else if (rT.compareToIgnoreCase(RoomTypes.FAMILY_WITH_VIEW.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.FamilyView());
				else if (rT.compareToIgnoreCase(RoomTypes.SUITE.getRoomType()) == 0)
					this.setRoom(new RoomSubclasses.Suite());
				
				break;
			} 
			catch(RoomTypeException rte){
				System.err.printf("%s\n", rte);
			} 
		}
			
		
		System.out.printf("Reservation Month: ");
		this.setReservationMonth(in.nextLine());
		
		while(true) {
			try {
				System.out.printf("Reservation Start: ");
				this.setReservationStart(in.nextInt());
				break;
			}
			catch(InputMismatchException ime) {
				System.err.printf("Reservation Start must be a numeric value!\n");
			}
			finally { in.nextLine(); }
		}
		
		while(true) {
			try {
				System.out.printf("Reservation End: ");
				this.setReservationEnd(in.nextInt());
				break;
			}
			catch(InputMismatchException ime) {
				System.err.printf("Reservation End must be a numeric value!\n");
			}
			finally { in.nextLine(); }
		}

		setReservationID(++totalNumberOfReservations);
		System.out.printf("\nReservation ID: %d is created!\n\n", Reservation.totalNumberOfReservations);
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
