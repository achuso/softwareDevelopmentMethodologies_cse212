import java.util.Scanner;

/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-9
 ***************************/
import java.util.InputMismatchException;

public class Bills implements Calculable {
	
	private String type;
	private double amount;
	private String month;
	
	Bills(Scanner in) throws InputMismatchException {

		System.out.printf("\nType: ");
		this.setType(in.nextLine());

		while(true) {
			try {
				System.out.printf("Amount: ");
				this.setAmount(in.nextInt());
				break;
			}
			catch(InputMismatchException BillAmount_NotNumeral ) {
				System.out.printf("Bill Amount must be a numeric value!\n");
			}
			finally { in.nextLine(); } // Scanner is cleared for a retry
		}
		
		System.out.printf("Month: ");
		this.setMonth(in.nextLine());	
	}
	
	public double getCost() {return getAmount();}
	
	public void setType(String type) 		{this.type = type;}
	public void setAmount(double amount) 	{this.amount = amount;}
	public void setMonth(String month) 		{this.month = month;}
	
	public String getType() 	{return this.type;}
	public double getAmount() 	{return this.amount;}
	public String getMonth() 	{return this.month;}
	
}
