/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-6
 ***************************/

public abstract class Services {
	
	int customerID;
	
	abstract String getServiceType();
	abstract double calculateService();
	
	void setCustomerID(int customerID) { this.customerID = customerID; }
	int getCustomerID() { return this.customerID; }
	
}
