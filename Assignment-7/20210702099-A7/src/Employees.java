/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-7
 ***************************/

public class Employees implements Calculable {
	
	private String Name;
	private String Surname;
	private double monthlyPayment;
	private int ID;
	
	Employees(String n, String sN, double mP, int ID) {
		setName(n);
		setSurname(sN);
		setMonthlyPayment(mP);
		setID(ID);
	}
	
	@Override
	public double getCost() {return getMonthlyPayment();}
	
	public void setName(String n) 				{this.Name = n;}
	public void setSurname(String sN) 			{this.Surname = sN;}
	public void setMonthlyPayment(double mP) 	{this.monthlyPayment = mP;}
	public void setID(int ID)					{this.ID = ID;}
	
	public String getName() 			{return this.Name;}
	public String getSurname() 			{return this.Surname;}
	public double getMonthlyPayment() 	{return this.monthlyPayment;}
	public int getID() 					{return this.ID;}
}
