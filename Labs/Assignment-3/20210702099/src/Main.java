/*******************************************
 * CSE 212 Section 3
 * Assignment 3
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/


import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// Array to contain Reservations
		List<Reservation> ReservationsList = new ArrayList<Reservation>();
		
		// Scanner object
		Scanner scannerObj = new Scanner(System.in);
		
		// Input variable to navigate through while-loop
		int menuInput = 0;
		
		do {
			
			System.out.printf("1.\tCreate new Reservation"
					+ "\n2.\tDisplay all Reservations"
					+ "\n3.\tDisplay the total number of reservations"
					+ "\n0.\tExit\n"
					);
			
			menuInput = scannerObj.nextInt();
			
			switch(menuInput) {
			
			case 1: // Set up reservation- receiving and asking for input is done in the constructor. Otherwise passing variables to the constructor felt like an unreadable clutter.
				ReservationsList.add( new Reservation(scannerObj) );
				break;
				
			case 2: // Display reservations
				if(ReservationsList.size() == 0)
					System.out.printf("\nERROR: No reservations created, cannot display any.\n");
				
				else {
					for(Reservation x: ReservationsList)
						System.out.printf("\nReservation for a %s room in %s starts on %s %d"
								+ " and ends on %s %d. "
								+ "Reservation has a total cost of $%d.\n",
								x.getRoom().getRoomType(), x.getHotelName(), x.getReservationMonth(), x.getReservationStart(),
								x.getReservationMonth(), x.getReservationEnd(),
								x.calculateTotalPrice()							
								);
					}
				
				System.out.printf("\n");
				break;
			
			case 3: // Display number of reservations
				System.out.printf("\n%d reservations created so far.\n\n", ReservationsList.size());
				break;
				
			case 0: // Exit
				System.out.println("Exiting..");
				break;
				
			default:
				System.out.println("ERROR: Invalid input. Please try again..\n\n");
				break;
			}
			
		} while(menuInput != 0);	
		
	scannerObj.close();
		
	}

}
