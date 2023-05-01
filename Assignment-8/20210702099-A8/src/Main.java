/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-8
 ***************************/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

enum MenuOptions {
	
	NEW_RESERVATION("1.\tCreate new Reservation with Room Type"),
	DISPLAY_ALL_RESERVATIONS("2.\tDisplay all Reservations"),
	LIST_RESERVATION_FOR_CITY("3.\tList the reservations for a specific city"),
	ADD_SERVICE_TO_RESERVATION("4.\tAdd extra services to a reservation"),
	CALCULATE_COST_FOR_EACH_SERVICE("5.\tCalculate total cost for each service"),
	DISPLAY_COST_OF_EVERY_CUSTOMER("6.\tDisplay the total cost of every customer"),
	ADD_EMPLOYEE("7.\tAdd an Employee"),
	ADD_BILL("8\tAdd a Bill"),
	MONTHLY_BALANCE("9.\tGet Monthly Balance"),
	LIST_SERVICE_COST("10.\tList all Services sorted based on cost"),
	LIST_RESERVATION_NAME("11.\tList all Reservations sorted based on names"),
	EXIT("12.\tExit");
	
	private final String menuPrompt;
	
	MenuOptions(String menuPromptConst) {
		this.menuPrompt = menuPromptConst;
	}
	
	public final String getPrompt() {return this.menuPrompt;}
	
}

public class Main {

	public static void main(String[] args) {
		
		List<Calculable> CalculableArray = new ArrayList<Calculable>();
		
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
				CalculableArray.add( new Reservation(rT, hN, rM, rS, rE) );
				System.out.printf("\nReservation ID: %d is created!", Reservation.totalNumberOfReservations);
				
				System.out.printf("\n\n");
				break;
			
			case DISPLAY_ALL_RESERVATIONS: // 2
				
				if(Reservation.totalNumberOfReservations == 0) {
					System.out.printf("\nERROR: No reservations created thus far.\n");
					break;
				}
				
				for(Calculable S: CalculableArray)
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
				
				for(ListIterator<Calculable> iterator = CalculableArray.listIterator(); iterator.hasNext(); ) {
					
					Calculable servicePlaceholder = iterator.next();
					
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
					CalculableArray.add( new Laundry(ReservationID, ClothingCount, 20) );
					
				}
				
				else if(ServiceInput == 2) { // Spa Service
					System.out.printf("How many days?\n");
					int SpaDays = scannerObj.nextInt();
					CalculableArray.add( new Spa(ReservationID, SpaDays, 100) );
				}
				
				else 
					System.out.printf("\n\nERROR: Invalid input. Please try 1 for laundry, 2 for spa services.\n");

				System.out.printf("\n");
				break;
				
			case CALCULATE_COST_FOR_EACH_SERVICE: //5
				
				System.out.println();
				
				if(CalculableArray.isEmpty()) 
					System.out.printf("ERROR: No reservations created.\n\n");

				else {
					for(ListIterator<Calculable> it = CalculableArray.listIterator(); it.hasNext(); ) {
					
						Calculable placeholderService = it.next();
						
						System.out.printf("The cost for the %s service of reservation ID %d: $%.2f\n",
									((Reservation) placeholderService).getServiceType(), ((Reservation) placeholderService).getReservationID(), ((Reservation) placeholderService).calculateService());
					}		
				}
				
				System.out.println();
			
				break;
				
			case DISPLAY_COST_OF_EVERY_CUSTOMER: // 6
				
				System.out.println();
				
				for(int i = 1; i <= Reservation.totalNumberOfReservations; i++) {
					
					double totalCostPerID = 0;
				
					for(ListIterator<Calculable> it1 = CalculableArray.listIterator(); it1.hasNext(); ) {
						
						Calculable placeHolder = it1.next();
						
						if( ((Services) placeHolder).getReservationID() == i)
							totalCostPerID += ((Services) placeHolder).calculateService();
							
					}
					
					System.out.printf("The total cost of all services of the reservation with ID %d is $%.2f\n", i, totalCostPerID);
					
				}
				
				System.out.println();
				break;
				
			case ADD_EMPLOYEE: // 7
				
				System.out.printf("\nName: ");
				String employeeName = scannerObj.nextLine();
				
				System.out.printf("Surname: ");
				String employeeSurname = scannerObj.nextLine();
				
				System.out.printf("ID: ");
				int employeeID = scannerObj.nextInt();
				
				System.out.printf("Monthly Payment: ");
				double employeeMonthlyPayment = scannerObj.nextDouble();
				
				scannerObj.nextLine(); // reset the scanner
				
				CalculableArray.add( new Employees(employeeName, employeeSurname, employeeMonthlyPayment, employeeID) );
				
				System.out.println();
				
				break;
				
			case ADD_BILL: // 8
				
				System.out.printf("\nType: ");
				String billType = scannerObj.nextLine();
				
				System.out.printf("Amount: ");
				double billAmount = scannerObj.nextDouble();
				
				scannerObj.nextLine(); // clear the scanner
				
				System.out.printf("Month: ");
				String billMonth = scannerObj.nextLine();
				
				CalculableArray.add( new Bills(billType, billAmount, billMonth) );
				
				System.out.println();
				
				break;
				
			case MONTHLY_BALANCE: // 9
				
				System.out.printf("\nEnter Month: ");
				String tempMonth = scannerObj.nextLine();
				
				double tempIncome = 0;
				double tempBillCosts = 0;
				double tempEmployeeCosts = 0;
				
				for(Calculable C: CalculableArray) {
					// Case for Reservations when it falls under the desired month
					if( C instanceof Reservation && ((Reservation) C).getReservationMonth().equalsIgnoreCase(tempMonth)) {
						
						int tempReservationID = ((Reservation) C).getReservationID();
						int tempReservationIndex = CalculableArray.indexOf(C);
						
						// For every reservation, iterate through the rest of the list for spa/laundry etc (additional service cant come before a reservation) 
						for(int i = tempReservationIndex; i < CalculableArray.size(); i++) {
							
							// If it's a Service other than Reservation and its reservation ID matches with the Reservation at hand, print it.
							if(CalculableArray.get(i) instanceof Services &&  ((Services) CalculableArray.get(i)).getReservationID() == tempReservationID ) {
								// Print out every Service associated with the Reservation at hand.
								System.out.printf("For reservation ID: %d, "
										+ "Service type: %s, "
										+ "Service Cost: %.2f\n", 
										((Services) CalculableArray.get(i)).getReservationID(), 
										((Services) CalculableArray.get(i)).getServiceType(), 
										((Services) CalculableArray.get(i)).getCost()
										);	
							
								tempIncome += (CalculableArray.get(i)).getCost();
							}
						}
					}
					
					// Case for Bills when it falls under the desired month
					else if(C instanceof Bills && ((Bills) C).getMonth().equalsIgnoreCase(tempMonth))
						tempBillCosts += C.getCost();
					
					// Case for Employees (added always)
					else if(C instanceof Employees) 
						tempEmployeeCosts += C.getCost();
					
				}
				
				System.out.printf("Total monthly income: %.2f\n"
						+ "Total monthly bills due: %.2f\n"
						+ "Total monthly employee cost: %.2f\n"
						+ "End of month balance: %.2f\n\n",
						tempIncome, tempBillCosts, tempEmployeeCosts, (tempIncome - (tempBillCosts + tempEmployeeCosts))
						);
				
				break;
			
			case LIST_SERVICE_COST: // 10
				ArrayList<Services> TempServices = new ArrayList<Services>();
				CostComparator comparatorObj = new CostComparator(); // instantiated CostComparator
				
				// Add the identified Services among Calculables to the temporary array
				for(Calculable Service: CalculableArray)
					if(Service instanceof Services)
						TempServices.add((Services) Service);
				
				// Bubble Sort with costs
				Boolean servicesArranged = false;
				while(!servicesArranged) {
					servicesArranged = true;
					for(int i = 0; i < TempServices.size() - 1; i++) // Access 2 elements at once. The i-th index can never be the last index
						if( comparatorObj.compare( TempServices.get(i), TempServices.get(i+1) ) == -1) {
							Collections.swap(TempServices, i, i+1);
							servicesArranged = false;
					}
				}
				
				for(Services S: TempServices) {
					System.out.printf("\n");
					S.displayServiceInfo();
				}
				
				System.out.printf("\n\n");
				
				break;
			
			case LIST_RESERVATION_NAME: // 11
				ArrayList<Reservation> TempReservations = new ArrayList<Reservation>();
				
				// Add the identified Reservations among Calculables to the temporary array
				for(Calculable R: CalculableArray)
					if(R instanceof Reservation)
						TempReservations.add((Reservation) R);
				
				// Bubble Sort with Strings (?)
				Boolean reservationsArranged = false;
				while(!reservationsArranged) {
					reservationsArranged = true;
					for(int i = 0; i < TempReservations.size() - 1; i++)
						// Compare names of i-th and (i+1)-th hotel names. If i is alphabeticallly bigger, it returns positive, otherwise it is negative, the case for which we need to swap.
						if( TempReservations.get(i).getHotelName().compareTo(TempReservations.get(i+1).getHotelName()) > 0 ) {
							Collections.swap(TempReservations, i, i+1);
							reservationsArranged = false;
					}
				}
				
				for(Reservation R: TempReservations) {
					System.out.printf("\n");
					System.out.printf("Hotel Name: %s, ", R.getHotelName());
					R.displayServiceInfo();
				}
				
				System.out.printf("\n\nn");
				
				break;
				
			case EXIT: // 12
				System.out.printf("\nExiting, Goodbye!");
				break;
				
				
			default:
				System.out.printf("\n\nInvalid input. Please try again...\n\n");
				break;
				
			}

			
		} while(menuInput != 12);
		
		scannerObj.close();
		
	}

}
