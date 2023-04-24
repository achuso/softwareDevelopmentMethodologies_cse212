/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-7
 ***************************/

public class Bills implements Calculable{
	
	private String type;
	private double amount;
	private String month;
	
	Bills(String type, double amount, String month) {
		setType(type);
		setAmount(amount);
		setMonth(month);
	}
	
	public double getCost() {return getAmount();}
	
	public void setType(String type) 		{this.type = type;}
	public void setAmount(double amount) 	{this.amount = amount;}
	public void setMonth(String month) 		{this.month = month;}
	
	public String getType() 	{return this.type;}
	public double getAmount() 	{return this.amount;}
	public String getMonth() 	{return this.month;}
	
}
