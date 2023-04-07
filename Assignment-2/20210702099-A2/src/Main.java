/*******************************************
 * CSE 212 Section 3
 * Name: Onat Ribar
 * Student number: 20210702099
 *******************************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scannerObj = new Scanner(System.in);
		
		Reservation reservationArray[] = new Reservation[25]; // Array size is arbitrary
		int reservedRooms = 0;
		
		int menuInput;
		
		do {
			System.out.printf("\n1.\tCreate new Reservation\n"
					+ "2.\tDisplay all Reservations\n"
					+ "0.\tExit\n");
			
			// Receive input for the menu and proceed with its switch/case
			switch(menuInput = scannerObj.nextInt()) {

				case 1:
				// Make a new reservation, place in array and increment the reservation count:
					reservationArray[reservedRooms++] = new Reservation(scannerObj);
					break;
			
				case 2:
				// Display every Reservation in array if it's non-empty:
					if(reservedRooms == 0)
						System.out.println("ERROR: No rooms have been reserved yet.");
					else {
						for(int i = 0; i < reservedRooms; i++)
							reservationArray[i].displayInfo();
						}
					break;
					
				case 0:
				// Exit:
					System.out.println("Exiting...");
					break;
					
				default:
				// Invalid input:
					System.out.println("ERROR: Invalid input. Please try again..");
					break;
			}
			
		} while(menuInput != 0);
	
		scannerObj.close();
	}

}
