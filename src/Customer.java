
public class Customer {
	
	 private String accountNumber;
	    private int pin;
	    private String mobileNumber;
	    private double balance;

	    Customer() {
	    }

	    Customer(String accountNumber, int pin) {
	        this.accountNumber = accountNumber;
	        this.pin = pin;
	    }
	    
	    public void savemobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;

	    }

}


