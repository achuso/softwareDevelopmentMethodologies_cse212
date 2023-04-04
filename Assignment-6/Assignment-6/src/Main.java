/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

enum MenuOptions {
	
	NEW_RESERVATION("1.\tCreate new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS("2.\tDisplay all Reservations"),
	LIST_RESERVATION_FOR_CITY("3.\tList the reservations for a specific city"),
	ADD_SERVICE_TO_RESERVATION("4.\tAdd extra services to a reservation"),
	CALCULATE_COST_FOR_EACH_SERVICE("5.\tCalculate total cost for each service"),
	DISPLAY_COST_OF_EVERY_CUSTOMER("6.\tDisplay the total cost of every customer"),
	EXIT("7.\tExit");
	
	private final String menuPrompt;
	
	MenuOptions(String menuPromptConst) {
		this.menuPrompt = menuPromptConst;
	}
	
	public final String getPrompt() {return this.menuPrompt;}
	
}

public class Main {

	public static void main(String[] args) {
		
		List<Reservation> ReservationArray = new ArrayList<Reservation>();
		
		int menuInput;
		Scanner scannerObj = new Scanner(System.in);
		
		do {
			// Print the menu
			for(MenuOptions x: MenuOptions.values())
				System.out.printf("%s\n", x.getPrompt());
			
			// Receive input
			menuInput = scannerObj.nextInt();
			// Clear the scanner
			scannerObj.nextLine();
			
			// Evaluate menuInput and lead to inputs
			switch( MenuOptions.values()[menuInput-1]) {
			
			case NEW_RESERVATION: // 1
				
				// Display the room options
				System.out.printf("\nROOM INFOS:\n\n");
				for(RoomTypes room: RoomTypes.values())
					System.out.printf(
							"Room Type: %s, Daily Cost: %d, Room Size: %d, Has Bath: %b \n",
							room.getRoomType(), room.getDailyCost(), room.getRoomSize(), room.getHasBath() );
								
				// Receive input for reservation creation
				System.out.printf("\nHotel Name: ");
				String hN = scannerObj.nextLine();
				
				System.out.printf("Room Type: ");
				String rT = scannerObj.nextLine();
				
				System.out.printf("Reservation Month: ");
				String rM = scannerObj.next();
				
				System.out.printf("Reservation Start: ");
				int rS = scannerObj.nextInt();
				
				System.out.printf("Reservation End: ");
				int rE = scannerObj.nextInt();
				
				// Pass values to Reservation const.
				ReservationArray.add( new Reservation(rT, hN, rM, rS, rE) );
				System.out.printf("\nReservation ID: %d is created!", ReservationArray.size());
				
				System.out.printf("\n\n");
				break;
			
			case DISPLAY_ALL_RESERVATIONS: // 2
				
				if(ReservationArray.size() == 0) {
					System.out.printf("\nERROR: No reservations created thus far.\n\n");
					break;
				}
				
				for(Reservation R: ReservationArray) {
					System.out.printf("\nReservation for a %s room in %s starts on "
							+ "%s %d and ends on "
							+ "%s %d. Reservation has a total cost of $%d.\n",
							R.getRoom().getRoomType(), R.getHotelName(),
							R.getReservationMonth(), R.getReservationStart(),
							R.getReservationMonth(), R.getReservationEnd(), (int) R.calculateService()
							);
				}
				
				System.out.printf("\n\n");
				break;

			case LIST_RESERVATION_FOR_CITY: // 3
				
				if(ReservationArray.size() == 0) {
					System.out.printf("\nERROR: No reservations created thus far.\n\n");
					break;
				}
				
				System.out.printf("\nType a city name for a reservation search: ");
				String cityName = scannerObj.nextLine();
				
				for(ListIterator<Reservation> iterator = ReservationArray.listIterator(); iterator.hasNext(); ) {
					
					String hotelNamePlaceholder = iterator.next().getHotelName();
					if( hotelNamePlaceholder.contains(cityName) ) // compare the hotelCityPlaceholder's last element (the city name) to the city name provided
						System.out.printf("%s\n", hotelNamePlaceholder);

				}
				
				System.out.printf("\n");
				break;
			
			case ADD_SERVICE_TO_RESERVATION: //4
				
				System.out.printf("\n\nPlease select one of the extra services from below:\n"
						+ "1.\tLaundry Service\n2.\tSpa Service\n");
				int ServiceInput = scannerObj.nextInt();
				
				System.out.printf("Type the reservation ID to credit this service");
				int reservationID = scannerObj.nextInt();
				
				if(ServiceInput == 1) {
					System.out.printf("");
				}
				else if(ServiceInput == 2) {
					
				}
				
				System.out.printf("\n");
				break;
				
			case EXIT: // 7
				System.out.printf("\n\nExiting...");
				break;
				
			}

			
		} while(menuInput != 7);
		
	}

}
