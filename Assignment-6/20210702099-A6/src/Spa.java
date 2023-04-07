/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

public class Spa extends Services {

	private int days;
	double spaCost;
	
	Spa(int reservationID, int days, double spaCost) {
		this.reservationID = reservationID;
		this.days = days;
		this.spaCost = spaCost;
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
	// no setter for spaCost because it is fixed at 100TL/day
	
}

