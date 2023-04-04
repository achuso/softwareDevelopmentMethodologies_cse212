

/************************************
		CSE 212 Section 3
		Student ID: 20210702099
		Name: Onat Ribar
 ***********************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scannerObj = new Scanner(System.in);
		
		HotelReservationSystem GardenOfSun = new HotelReservationSystem(25);
		
		int menuInput; // for switch-case in do-while iteration
		int pcInput, priceInput; // variables for room creation
		
		do {
			
			System.out.printf(
					"\n" + "1.\tCreate new Standard Room\n"
					+ "2.\tDisplay all room information\n"
					+ "3.\tDisplay the total number of rooms\n"
					+ "0.\tExit\n");
			
			switch( menuInput = scannerObj.nextInt() ) {
				case 1:
					System.out.printf("Person Count: ");
					pcInput = scannerObj.nextInt();
					
					System.out.printf("Price: ");
					priceInput = scannerObj.nextInt();
					
					GardenOfSun.createStandardRoom(priceInput, pcInput);
					
					break;
					
				case 2:
					GardenOfSun.displayInfo();
					break;
					
				case 3:
					System.out.printf("%d rooms have been created thus far.\n", GardenOfSun.roomsCreated());
					break;
					
				case 0:
					System.out.println("Exiting...");
					break;
					
				default:
					System.out.println("ERROR: Irrelevant output. Please try again.");
					break;	
			}
			
		} while(menuInput != 0);	
		
		scannerObj.close();
	}
	
}
