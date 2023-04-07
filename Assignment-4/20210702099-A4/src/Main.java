/*******************************************
 * CSE 212 Section 3
 * Assignment 4
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum MenuOptions {
	
	NEW_RESERVATION("1.\tCreate new Reservation"),
	NEW_RESERVATION_WITH_ROOM_TYPE("2.\tCreate new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS("3.\tDisplay all Reservations"),
	DISPLAY_NR_OF_RESERVATIONS("4.\tDisplay the total number of reservations"),
	EXIT("5.\tExit");
	
	private final String menuPrompt;
	
	MenuOptions(String menuPromptConst) {
		this.menuPrompt = menuPromptConst;
	}
	
	public final String getPrompt() {return this.menuPrompt;}
	
}

public class Main {

	public static void main(String[] args) {
		
		// Array to contain Reservations
		List<Reservation> ReservationsList = new ArrayList<Reservation>();
		
		// Scanner object
		Scanner scannerObj = new Scanner(System.in);
		
		// Input variable to navigate through while-loop
		int menuInput;
		
		// Inputs to pass to reservation & room constructors
		String hotelName, roomType, reservationMonth;
		int reservationStart, reservationEnd;	
		
		do {
			// Print out the menu with enums
			System.out.printf("%s", MenuOptions.NEW_RESERVATION.getPrompt());
			System.out.printf("\n%s", MenuOptions.NEW_RESERVATION_WITH_ROOM_TYPE.getPrompt());
			System.out.printf("\n%s", MenuOptions.DISPLAY_ALL_RESERVATIONS.getPrompt());
			System.out.printf("\n%s", MenuOptions.DISPLAY_NR_OF_RESERVATIONS.getPrompt());
			System.out.printf("\n%s\n", MenuOptions.EXIT.getPrompt());
			
			// Receive input 
			menuInput = scannerObj.nextInt();
			
			// Decrement input to reference the menu enum constants accordingly in the switch-case
			switch(MenuOptions.values()[menuInput - 1]) {
				
				case NEW_RESERVATION:  // 1 - Create reservation, default room type of Single
					System.out.printf("\nHotel Name: ");
					hotelName = scannerObj.next();
					
					System.out.printf("Reservation Month: ");
					reservationMonth = scannerObj.next();
					
					System.out.printf("Reservation Start: ");
					reservationStart = scannerObj.nextInt();
					
					System.out.printf("Reservation End: ");
					reservationEnd = scannerObj.nextInt();
					
					// Overloaded constructor without roomType parameter
					ReservationsList.add( new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd) );
					System.out.printf("\nReservation created!\n\n");
					
					break;
					
				case NEW_RESERVATION_WITH_ROOM_TYPE: // 2 - Create reservation with proper room type
					
					System.out.printf("\nROOM INFOS:\n\n");
					
					for(RoomTypes room: RoomTypes.values())
						System.out.printf(
								"Room Type: %s, Daily Cost: %d, Room Size: %d, Has Bath: %b \n",
								room.getRoomType(), room.getDailyCost(), room.getRoomSize(), room.getHasBath() );
					
					System.out.printf("\nHotel Name: ");
					hotelName = scannerObj.next();
					
					System.out.printf("Room Type: ");
					roomType = scannerObj.next();
					
					System.out.printf("Reservation Month: ");
					reservationMonth = scannerObj.next();
					
					System.out.printf("Reservation Start: ");
					reservationStart = scannerObj.nextInt();
					
					System.out.printf("Reservation End: ");
					reservationEnd = scannerObj.nextInt();
					
					// Overloaded constructor with roomType parameter
					ReservationsList.add( new Reservation(roomType, hotelName, reservationMonth, reservationStart, reservationEnd) );	
					System.out.printf("\nReservation created!\n\n");
					
					break;
					
				case DISPLAY_ALL_RESERVATIONS: // 3 - Display all the reservations
					
					if(Reservation.totalNumOfReservations == 0)
						System.out.printf("ERROR: No reservations created thus far.\n\n");
					
					else {
						for(Reservation x: ReservationsList)
							System.out.printf(
									"Reservation for a %s room in %s on %s %d"
									+ " and ends on %s %d. Reservation has a total cost of $%d.\n\n",
									x.getRoom().getRoomType(), x.getHotelName(), x.getReservationMonth(), x.getReservationStart(),
									x.getReservationMonth(), x.getReservationEnd(), x.calculateTotalPrice()
									);
					}
					
					break;
				
				case DISPLAY_NR_OF_RESERVATIONS: // 4 - Display number of reservations
					System.out.printf("\n%d reservations created so far.\n\n", Reservation.totalNumOfReservations);
					break;
					
				case EXIT: // 5 - Exit
					System.out.println("Exiting..");
					break;
					
				default: // Invalid input
					System.out.println("\nERROR: Invalid input. Please try again..\n\n");
					break;
			}
			
		} while(menuInput != 5);	
		
	scannerObj.close();
		
	}

}
