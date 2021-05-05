
public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Begin banking.....");
        BankAccount ba1=new BankAccount(987,"sujit", 900000, 895, "India");
        BankAccount ba2=new BankAccount(599,"Sujit c Pednekar");
        BankAccount ba3=new BankAccount();
        ba1.ShowAccountDetails();
        ba2.ShowAccountDetails();
        ba3.ShowAccountDetails();
        //ba1.withdraw(10000);
       // ba1.ShowAccountDetails();
       // ba1.withdraw(1000000);
       // ba1.withdraw(890000);
        
        
	}

}

class BankAccount
{
	private int bankAccountNumber;
	private String bankAccountHolder;
	private double bankAccountBalance;
	private int bankAccountPinNumber;
	private String bankAccountHolderAddress;
	
	 BankAccount(int a, String b, double c,int d,String e) {
		 //this is a parameterized constructor
		bankAccountNumber=a;
		bankAccountHolder=b;
		bankAccountBalance=c;
		bankAccountPinNumber=d;
		bankAccountHolderAddress=e;
		
		
		
	}
	 BankAccount(int a, String b) {
		 //this is a parameterized constructor
		bankAccountNumber=a;
		bankAccountHolder=b;
		
		}
	 BankAccount(){
		 System.out.println("********Data not Available**********");
	 }
	
	void withdraw (double d) {
		System.out.println(bankAccountHolder+" is withdrawing");
		if(d<0) {
			System.out.println("cannot withdraw -ve ammount");
		}
		else if(d>bankAccountBalance) {
			System.out.println("insufficient balance...");
		}
		else if(d>bankAccountBalance-5000) {
			System.out.println("minimum balance needs to be maintained...");
		}
		else {
			System.out.println("withdrawing...."+d);
			bankAccountBalance=bankAccountBalance-d;
		}
	}
	void ShowAccountDetails(){
		System.out.println("Bank account Number         :  "+bankAccountNumber);
		System.out.println("Bank account holder         :  "+bankAccountHolder);
		System.out.println("Bank account Balance        :  "+bankAccountBalance);
		System.out.println("Bank account PIN Number     :  "+bankAccountPinNumber);
		System.out.println("Bank account Holder Address :  "+bankAccountHolderAddress);
		System.out.println("----------------------------------------------------------");
		
	}
	
}
