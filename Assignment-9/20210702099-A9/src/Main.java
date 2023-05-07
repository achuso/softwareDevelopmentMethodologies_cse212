/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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

	public static void main(String[] args) throws InputMismatchException, RoomTypeException {
		
		List<Calculable> CalculableArray = new ArrayList<Calculable>();
		
		int menuInput = 12;
		Scanner scannerObj = new Scanner(System.in);
			
		do {// Print the menu
			for(MenuOptions x: MenuOptions.values())
				System.out.printf("%s\n", x.getPrompt());
			
			try {
			// Receive input
			menuInput = scannerObj.nextInt();
			scannerObj.nextLine();

			
				// Evaluate menuInput and lead to inputs
				switch( MenuOptions.values()[menuInput-1]) {
				
				case NEW_RESERVATION: // 1
					
					CalculableArray.add( new Reservation(scannerObj) );
	
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
					
					if(ServiceInput == 1) // Laundry Service
						CalculableArray.add( new Laundry(scannerObj) );
	
					else if(ServiceInput == 2) // Spa Service
						CalculableArray.add( new Spa(scannerObj) );
					
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
					
					CalculableArray.add( new Employees(scannerObj) );
					System.out.println();
					break;
					
				case ADD_BILL: // 8
	
					CalculableArray.add( new Bills(scannerObj) );
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
					
					// Add the identified Services among Calculables to the temporary array.
					for(Calculable Service: CalculableArray)
						if(Service instanceof Services)
							TempServices.add((Services) Service);
					
					// Sorting in terms of cost in reverse so that it is in descending order.
					Collections.sort(TempServices, Collections.reverseOrder(new CostComparator()));
					
					for(Services S: TempServices) {
						System.out.printf("\n");
						S.displayServiceInfo();
					}
					
					TempServices = null;
					System.out.printf("\n\n");
					
					break;
				
				case LIST_RESERVATION_NAME: // 11
					ArrayList<Reservation> TempReservations = new ArrayList<Reservation>();
					
					// Add the identified Reservations among Calculables to the temporary array.
					for(Calculable R: CalculableArray)
						if(R instanceof Reservation)
							TempReservations.add((Reservation) R);
					
					// Sorting in ascending order, so alphabetically.
					Collections.sort(TempReservations);
					
					for(Reservation R: TempReservations) {
						System.out.printf("\nHotel Name: %s, ", R.getHotelName());
						R.displayServiceInfo();
					}
					
					System.out.printf("\n\n");
					
					break;
					
				case EXIT: // 12
					System.out.printf("\nExiting, Goodbye!");
					break;
						
				default:
					break;	
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.err.printf("\nYou entered an invalid menu option. Please try again..\n\n");
			}
			catch(InputMismatchException ime) {
				System.err.printf("\nYou entered an invalid menu option. Please try again..\n\n");
				scannerObj.nextLine();
				menuInput = 0; // Band-aid solution, but fits the menuInput for integer comparison with the menu exit value, in case it was fed a string and InputMismatchException was triggered
			}

		} while(menuInput != 12);
		
		scannerObj.close();
		
	}

}
