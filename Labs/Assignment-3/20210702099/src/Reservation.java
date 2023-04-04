/*******************************************
 * CSE 212 Section 3
 * Assignment 3
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

import java.util.Scanner;

public class Reservation {

	private Room room;
	
	private String hotelName;
	
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
	private int dailyCost;
	
	
	public Reservation(Scanner scannerObj) {
		
		// save the room variables for the Room constructor, set the rest using setters
		int r_dailyCost, r_roomSize;
		Boolean r_hasBath;
		String r_roomType;
		
		System.out.printf("\nHotel Name: ");
		setHotelName( scannerObj.next() );
		
		System.out.printf("Room Type: ");
		r_roomType = scannerObj.next();	
		
		System.out.printf("Reservation Month: ");
		setReservationMonth( scannerObj.next() );
		
		System.out.printf("Reservation Start: ");
		setReservationStart ( scannerObj.nextInt() );
		
		System.out.printf("Reservation End: ");
		setReservationEnd( scannerObj.nextInt() );
		
		System.out.printf("Daily Cost: ");
		r_dailyCost = scannerObj.nextInt(); // daily cost for room
		setDailyCost_R(r_dailyCost);		// daily cost for reservation
		
		System.out.printf("Has Bath: ");
		r_hasBath = scannerObj.nextBoolean();
		
		System.out.printf("Room Size: ");
		r_roomSize = scannerObj.nextInt();
		
		setRoom( new Room(r_roomType, r_dailyCost, r_roomSize, r_hasBath) );
		
		System.out.printf("\nReservation created!\n\n");

	}
	

	public int calculateTotalPrice() {
		
		switch(getReservationMonth()) {
		
			// Double cost if reservation in June/July/August
			case "June": case "July": case "August":
				return 2 * getDailyCost_R() * ( getReservationEnd() - getReservationStart() );
				
			// Otherwise regular prices apply
			default:
				return getDailyCost_R() * ( getReservationEnd() - getReservationStart() );
				
		}
		
	}
	
	
	// GETTERS FOR THE INSTANCE VARIABLES
	
	public Room getRoom() {return this.room;}
	
	public String getHotelName() {return this.hotelName;}
	
	public String getReservationMonth() {return this.reservationMonth;}	
	
	public int getReservationStart() {return this.reservationStart;}
	
	public int getReservationEnd() {return this.reservationEnd;}
	
	public int getDailyCost_R() {return dailyCost;} // capital 'R' at the end to distinguish it from room class setter
	

	// SETTERS FOR THE INSTANCE VARIABLES
	
	public void setRoom(Room room) { this.room = room;}
	
	public void setHotelName(String hN) {this.hotelName = hN;}
	
	public void setReservationMonth(String rM) {this.reservationMonth = rM;}	
	
	public void setReservationStart(int rS) {this.reservationStart = rS;}
	
	public void setReservationEnd(int rE) {this.reservationEnd = rE;}
	
	public void setDailyCost_R(int dC_R) {this.dailyCost = dC_R;}
	
	
}