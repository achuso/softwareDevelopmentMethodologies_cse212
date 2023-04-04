/*******************************************
 * CSE 212 Section 3
 * Assignment 5
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

import java.util.Scanner;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ListIterator;

enum MenuOptions {
	
	NEW_RESERVATION("1.\tCreate new Reservation"),
	NEW_RESERVATION_WITH_ROOM_TYPE("2.\tCreate new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS("3.\tDisplay all Reservations"),
	DISPLAY_NR_OF_RESERVATIONS("4.\tDisplay the total number of reservations"),
	LIST_RESERVATIONS_FOR_SPECIFIC_CITY("5.\tList the reservations for a specific city"),
	REMOVE_RESERVATION_IN_SPECIFIC_CITY("6.\tRemove reservations in a specific city"),
	EXIT("7.\tExit");
	
	private final String menuPrompt;
	
	MenuOptions(String menuPromptConst) {
		this.menuPrompt = menuPromptConst;
	}
	
	public final String getPrompt() {return this.menuPrompt;}
	
}

public class Main {

	public static void main(String[] args) {
		
		// Array to contain Reservations, max size of 3
		Reservation[] ReservationsArray = new Reservation[3];
		
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
			System.out.printf("\n%s", MenuOptions.LIST_RESERVATIONS_FOR_SPECIFIC_CITY.getPrompt());
			System.out.printf("\n%s", MenuOptions.REMOVE_RESERVATION_IN_SPECIFIC_CITY.getPrompt());
			System.out.printf("\n%s\n", MenuOptions.EXIT.getPrompt());
			
			// Receive input 
			menuInput = scannerObj.nextInt();
			scannerObj.nextLine(); // to clear the escape characters in the Scanner
			
			// Decrement input to reference the menu enum constants accordingly in the switch-case
			switch( MenuOptions.values()[menuInput - 1] ) {
			
				case NEW_RESERVATION: // 1
					
					if(Reservation.totalNumOfReservations == 3) {
						System.out.printf("\nERROR: Reservation system is full, cannot create room.\n\n");
						break;
					}
	
					System.out.printf("\nHotel Name: ");
					hotelName = scannerObj.nextLine();
					
					System.out.printf("Reservation Month: ");
					reservationMonth = scannerObj.next();
									
					System.out.printf("Reservation Start: ");
					reservationStart = scannerObj.nextInt();
									
					System.out.printf("Reservation End: ");
					reservationEnd = scannerObj.nextInt();
									
					// Overloaded constructor without roomType parameter
					ReservationsArray[Reservation.totalNumOfReservations]  = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd);
					System.out.printf("\nReservation created!\n\n");
									
					break;
										
				case NEW_RESERVATION_WITH_ROOM_TYPE: // 2
					
					if(Reservation.totalNumOfReservations == 3) {
						System.out.printf("\nERROR: Reservation system is full, cannot create room.\n\n");
						break;
					}
					
					System.out.printf("\nROOM INFOS:\n\n");
					
					for(RoomTypes room: RoomTypes.values())
						System.out.printf(
								"Room Type: %s, Daily Cost: %d, Room Size: %d, Has Bath: %b \n",
								room.getRoomType(), room.getDailyCost(), room.getRoomSize(), room.getHasBath() );
									
					System.out.printf("\nHotel Name: ");
					hotelName = scannerObj.nextLine();
					
					System.out.printf("Room Type: ");
					roomType = scannerObj.nextLine();
					
					System.out.printf("Reservation Month: ");
					reservationMonth = scannerObj.next();
					
					System.out.printf("Reservation Start: ");
					reservationStart = scannerObj.nextInt();
					
					System.out.printf("Reservation End: ");
					reservationEnd = scannerObj.nextInt();
					
					// Overloaded constructor with roomType parameter
					// !!! The "equals" comparison asked in the instructions is handled in the overloaded Reservation constructor
					ReservationsArray[Reservation.totalNumOfReservations] =  new Reservation(roomType, hotelName, reservationMonth, reservationStart, reservationEnd);	
					System.out.printf("\nReservation created!\n\n");
					
					break;
					
				case DISPLAY_ALL_RESERVATIONS: // 3
					
					if(Reservation.totalNumOfReservations == 0)
						System.out.printf("\nERROR: No reservations created thus far.\n\n");
					
					else {
						System.out.println();
						for(int i = 0; i < Reservation.totalNumOfReservations; i++)
							ReservationsArray[i].displayInfo();
					}
					
					break;
				
				case DISPLAY_NR_OF_RESERVATIONS: // 4
					System.out.printf("\n%d reservations created so far.\n\n", Reservation.totalNumOfReservations);
					break;
					
				case LIST_RESERVATIONS_FOR_SPECIFIC_CITY: // 5
					
					if(Reservation.totalNumOfReservations == 0)
						System.out.printf("\nERROR: No reservations created thus far.\n\n");
					
					else {
						System.out.printf("\nType a city name for a reservation search: ");
						String citySearchInput = scannerObj.nextLine();
						
						List<Reservation> ReservationsArrayIntoList = Arrays.asList(ReservationsArray); // Array to List conversion

						// Using iterator to browse through the list until it doesn't have a next
						for(  ListIterator<Reservation> iterator = ReservationsArrayIntoList.listIterator(); iterator.hasNext(); ) { 
							
							Reservation reservationPlaceholder = iterator.next();
							
							if(reservationPlaceholder == null) break; // Safeguard for if ReservationArray has less than 3 elements.
							
							//Reservation reservationPlaceholder = iterator.next();
							String[] hotelCityPlaceholder = reservationPlaceholder.getHotelName().split(" "); // split the name into the hotel name and city name
							
							if( hotelCityPlaceholder[hotelCityPlaceholder.length - 1  ].equals(citySearchInput) ) // compare the hotelCityPlaceholder's last element (the city name) to the city name provided
								System.out.printf("%s\n", reservationPlaceholder.getHotelName());
						}
						
						ReservationsArrayIntoList = null;
						System.out.printf("\n");
					}
					
					break;
					
				case REMOVE_RESERVATION_IN_SPECIFIC_CITY: // 6
					
					if(Reservation.totalNumOfReservations == 0)
						System.out.printf("\nERROR: No reservations created thus far.\n\n");
					
					else {
						System.out.printf("\nType a city name for a reservation search: ");
						String citySearchInput = scannerObj.nextLine();
						
						List<Reservation> ReservationsArrayIntoList = new LinkedList<Reservation>(Arrays.asList(ReservationsArray)); // Array to List conversion

						// Using iterator to browse through the list until it doesn't have a next
						for(  ListIterator<Reservation> iterator = ReservationsArrayIntoList.listIterator(); iterator.hasNext(); ) {
							
							Reservation reservationPlaceholder = iterator.next();
							
							if(reservationPlaceholder == null) break; // Safeguard for if ReservationArray has less than 3 elements.
							
							String[] hotelCityPlaceholder = reservationPlaceholder.getHotelName().split(" "); // split the name into the hotel name and city name
							
							// See if there's room for a city name (length >= 1), and if so, then check if the last string there (presumably city name) matches with the city search input provided
							if( hotelCityPlaceholder.length >= 1 && hotelCityPlaceholder[ hotelCityPlaceholder.length - 1  ].equals(citySearchInput) ) {
								iterator.remove(); 
								Reservation.totalNumOfReservations--; // number of reservations is decremented
							}		
							
						}
						
						// Nullify the array and fill it with the contents of the list
						ReservationsArray = ReservationsArrayIntoList.toArray(ReservationsArray);
						ReservationsArrayIntoList = null;
			
						System.out.printf("\n");
					}
					
					break;
					
				case EXIT: // 7
					System.out.println("\nExiting..");
					break;
					
				default: // Invalid input
					System.out.println("\nERROR: Invalid input. Please try again..\n\n");
					break;
			}
			
		} while(menuInput != 7);	
		
	scannerObj.close();
		
	}

}
