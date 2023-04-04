/*******************************************
 * CSE 212 Section 3
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

import java.util.Scanner;

public class Reservation {

	private String hotelName;
	private String reservationMonth;
	
	private int reservationStart;
	private int reservationEnd;
	
	private int dailyCost;
	
	
	public Reservation(Scanner reservationInput) { // I used a scanner parameter because allocating one in the method and closing it apparently affects the input stream entirely, causing problems with the scanner on main with error "java.util.NoSuchElementException".
		
		System.out.printf("\nHotel Name: ");
		this.hotelName = reservationInput.next();
		
		System.out.printf("Reservation Month: ");
		this.reservationMonth = reservationInput.next();
		
		while(true) {
			/* 
			 * Ask for reservation dates and check the values. If one of the following conditions are met, ask for input again:
			 * 1) Reservation ends before it starts (reservationEnd < reservationStart)
			 * 2) Reservation time exceeds the maximum time of 30 days (reservationEnd - reservationStart >= 30)
			 * 3) End date of the reservation exceeds how long a month can be (reservationEnd > 31), assume all months are 31 days long. e.g. Jan 32nd doesn't exist
			 * 4) Reservation dates cannot be smaller than 1.
			*/
			System.out.printf("Reservation Start: ");
			this.reservationStart = reservationInput.nextInt();
			
			System.out.printf("Reservation End: ");
			this.reservationEnd = reservationInput.nextInt();
			
			// Ask for new date inputs (iterate loop again) if they're invalid, otherwise quit the loop move on.
			if(this.reservationEnd < this.reservationStart || this.reservationEnd - this.reservationStart >= 30 || this.reservationEnd > 31 || this.reservationEnd < 1 || this.reservationStart < 1)
				System.out.println("ERROR: Reservation days are invalid. Please try again..");
			else break;	
		}
		
		System.out.printf("Daily Cost: ");
		this.dailyCost = reservationInput.nextInt();
		
		System.out.printf("\nReservation created!\n");
		
	}

	// GETTER METHODS FOR THE DISPLAYINFO() METHOD
	public String getHotelName() {return hotelName;}
	public String getReservationMonth() {return reservationMonth;}
	public int getReservationStart() {return reservationStart;}
	public int getReservationEnd() {return reservationEnd;}
	public int getDailyCost() {return reservationEnd;}

	
	public void displayInfo() {
		System.out.printf("\nReservation for %s starts on %s %d and ends on "
				+ "%s %d. Reservation has a total cost of $%d.\n",
				getHotelName(), getReservationMonth(), getReservationStart(),
				getReservationMonth(), getReservationEnd(), calculateTotalPrice());
	}
	
	
	public int calculateTotalPrice() {
		return dailyCost * (reservationEnd - reservationStart);
	}
	
}