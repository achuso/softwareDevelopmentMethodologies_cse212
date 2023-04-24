/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-7
 ***************************/

public abstract class Services implements Calculable {
	
	int reservationID; // graph says customerID but text says reservationID, hope it's fine this way
	
	abstract String getServiceType();
	abstract double calculateService();
	
	void setReservationID(int reservationID) { this.reservationID = reservationID; }
	int getReservationID() { return this.reservationID; }
	
}
