
public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance){
        
    	balance = initialBalance;
    }

    public void withdraw(double amount) throws NotEnoughFundsException{
        
    	if(balance < amount){
            
    		throw new NotEnoughFundsException("Insufficient funds");
        }
        
    	balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public static void main(String[] args) {
        
    	BankAccount account = new BankAccount(500.00);
        
    	try{
            
    		account.withdraw(800.00);
        
    	}catch (NotEnoughFundsException n){
            
    		//n.printStackTrace();
    		System.out.println("Exception caught " + n);
        }
    }
}
