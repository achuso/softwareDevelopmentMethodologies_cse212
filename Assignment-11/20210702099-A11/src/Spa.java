/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-11
 ***************************/

public class Spa extends Services {

	private int days;
	private double spaCost;
	
	Spa(int days, int reservationID) {
		this.setDays(days);
		this.setReservationID(reservationID);
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
