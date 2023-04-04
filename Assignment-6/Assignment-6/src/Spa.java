
public class Spa extends Services {

	private int days;
	final double spaCost = 100;
	
	Spa(int customerID, int days) {
		this.customerID = customerID; // customerID from abstract class Services
		this.days = days;
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
	double getSpaCost() {return this.spaCost;}
	
	void setDays(int days) {this.days = days;}
	// no setter for spaCost because it is fixed at 100TL/day
	
}

