/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

import java.util.Scanner;
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
		
		List<Services> ServicesArray = new ArrayList<Services>();
		
		int menuInput;
		Scanner scannerObj = new Scanner(System.in);
		
		do {// Print the menu
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
					System.out.printf("Room Type: %s, Daily Cost: %d, Room Size: %d, Has Bath: %b \n",
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
				// Comparison of roomType with .equals() method is handled in Reservation constructor
				ServicesArray.add( new Reservation(rT, hN, rM, rS, rE) );
				System.out.printf("\nReservation ID: %d is created!", Reservation.totalNumberOfReservations);
				
				System.out.printf("\n\n");
				break;
			
			case DISPLAY_ALL_RESERVATIONS: // 2
				
				if(Reservation.totalNumberOfReservations == 0) {
					System.out.printf("\nERROR: No reservations created thus far.\n");
					break;
				}
				
				for(Services S: ServicesArray)
					if(S instanceof Reservation)
						((Reservation) S).displayInfo();
				
				System.out.printf("\n");
				break;

			case LIST_RESERVATION_FOR_CITY: // 3
				
				if(Reservation.totalNumberOfReservations == 0) {
					System.out.printf("\nERROR: No reservations created thus far.\n\n");
					break;
				}
				
				System.out.printf("\nType a city name for a reservation search: ");
				String cityName = scannerObj.nextLine();
				
				for(ListIterator<Services> iterator = ServicesArray.listIterator(); iterator.hasNext(); ) {
					
					Services servicePlaceholder = iterator.next();
					
					if( servicePlaceholder instanceof Reservation  // if the service in question is actually a reservation...
							&& ((Reservation) servicePlaceholder).getHotelName().contains(cityName) ) // AND IF SO, if it is also of the city that we desire...
							System.out.printf("%s\n", ((Reservation) servicePlaceholder).getHotelName() ); // print the hotel name.
					
				}
				
				System.out.printf("\n");
				break;
			
			case ADD_SERVICE_TO_RESERVATION: //4
				
				System.out.printf("\nPlease select one of the extra services from below:\n"
						+ "1.\tLaundry Service\n2.\tSpa Service\n");
				int ServiceInput = scannerObj.nextInt();
				
				System.out.printf("\nType the reservation ID to credit this service:\n");
				int ReservationID = scannerObj.nextInt();
				
				if(ServiceInput == 1) { // Laundry Service
					System.out.printf("How many pieces of clothing?\n");
					int ClothingCount = scannerObj.nextInt();
					ServicesArray.add( new Laundry(ReservationID, ClothingCount, 20) );
					
				}
				
				else if(ServiceInput == 2) { // Spa Service
					System.out.printf("How many days?\n");
					int SpaDays = scannerObj.nextInt();
					ServicesArray.add( new Spa(ReservationID, SpaDays, 100) );
				}
				
				else 
					System.out.printf("\n\nERROR: Invalid input. Please try 1 for laundry, 2 for spa services.\n");

				System.out.printf("\n");
				break;
				
			case CALCULATE_COST_FOR_EACH_SERVICE: //5
				
				System.out.println();
				
				if(ServicesArray.isEmpty()) 
					System.out.printf("ERROR: No reservations created.\n\n");

				else {
					for(ListIterator<Services> it = ServicesArray.listIterator(); it.hasNext(); ) {
					
						Services placeholderService = it.next();
						
						System.out.printf("The cost for the %s service of reservation ID %d: $%.2f\n",
									placeholderService.getServiceType(), placeholderService.getReservationID(), placeholderService.calculateService());
					}		
				}
				
				System.out.println();
			
				break;
				
			case DISPLAY_COST_OF_EVERY_CUSTOMER: // 6
				
				System.out.println();
				
				for(int i = 1; i <= Reservation.totalNumberOfReservations; i++) {
					
					double totalCostPerID = 0;
				
					for(ListIterator<Services> it1 = ServicesArray.listIterator(); it1.hasNext(); ) {
						
						Services placeHolder = it1.next();
						
						if(placeHolder.getReservationID() == i)
							totalCostPerID += placeHolder.calculateService();
							
					}
					
					System.out.printf("The total cost of all services of the reservation with ID %d is $%.2f\n", i, totalCostPerID);
					
				}
				
				System.out.println();
				break;
				
			case EXIT: // 7
				System.out.printf("\nExiting, Goodbye!");
				break;
				
		}

			
		} while(menuInput != 7);
		
		scannerObj.close();
		
	}

}
