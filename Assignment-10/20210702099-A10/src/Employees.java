/***************************
 * NAME: Onat Ribar
 * STUDENT NR: 20210702099
 * CSE 212 Assignment-10
 ***************************/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Employees implements Calculable {
	
	private String Name;
	private String Surname;
	private double monthlyPayment;
	private int ID;
	
	Employees(Scanner in) throws InputMismatchException {
		System.out.printf("\nName: ");
		this.setName(in.nextLine());
		
		System.out.printf("Surname: ");
		this.setSurname(in.nextLine());
		
		while(true) {
			try {
				System.out.printf("ID: ");
				this.setID(in.nextInt());
				break;
			}
			catch(InputMismatchException IDnotNumeral) {
				System.err.println("Employee ID should be an integer!");
			}
			finally { in.nextLine(); } // Clear scanner for next input, either in try-catch
		}
		
		while(true) {
			try {
				System.out.printf("Monthly Payment: ");
				this.setMonthlyPayment(in.nextDouble());
				break;
			}
			catch(InputMismatchException paymentNotNumeral) {
				System.err.println("Monthly Payment should be a numeric value!");
			}
			finally { in.nextLine(); }
		}
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
