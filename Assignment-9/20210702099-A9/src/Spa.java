/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Spa extends Services {

	private int days;
	private double spaCost;
	
	Spa(Scanner in) {
		
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
				System.out.printf("How many days?\n");
				this.setDays(in.nextInt());
				break;
			}
			catch(InputMismatchException DaysNotNumeral) {
				System.err.println("Day count must be a numeric value!");
			}
			finally {in.nextLine();}
		}
		
		this.setSpaCost(100);
	}
	
	@Override
	String getServiceType() {
		return "Spa";
	}
	
	@Override
	double calculateService() {
		return getDays() * getSpaCost();
	}
	
	int getDays() {return this.days;}
	void setDays(int days) {this.days = days;}
	
	double getSpaCost() {return this.spaCost;}
	void setSpaCost(double spaCost) {this.spaCost = spaCost;}
	
}
