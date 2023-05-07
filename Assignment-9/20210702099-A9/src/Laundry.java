/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Laundry extends Services {

	int clothingPieces;
	double laundryCost;
	
	Laundry(Scanner in) throws InputMismatchException {
		
		while(true) {
			try {
				System.out.printf("\nType the reservation ID to credit this service:\n");
				this.setReservationID(in.nextInt());
				break; // Loop breaks if no exceptions thrown
			}
			catch(InputMismatchException IDnotNumeral) {
				System.err.printf("Reservation ID must be a numeric value!");
			}
			finally { in.nextLine(); }
		}
		
		while(true) {
			try {
				System.out.printf("How many pieces of clothing?\n");
				this.setClothingPieces(in.nextInt());
				break;
			}
			catch(InputMismatchException ClothesNotNumeral) {
				System.err.println("Clothing count must be a numeric value!");
			}
			finally {in.nextLine();}
		}
		
		this.setLaundryCost(20);
	}
	
	@Override
	String getServiceType() {
		return "Laundry";
	}
	
	@Override
	double calculateService() {
		return getClothingPieces() * getLaundryCost();
	}
	
	int getClothingPieces() {return this.clothingPieces;}
	void setClothingPieces(int clothingPieces) {this.clothingPieces = clothingPieces;}
	
	double getLaundryCost() {return this.laundryCost;}
	void setLaundryCost(double laundryCost) {this.laundryCost = laundryCost;}
	
}

