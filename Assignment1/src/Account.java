import java.time.LocalDate;

/**
 * @param Contains account information of the account holder, and utilizes information from the person class
 */

public class Account {
	
	private int accountId;
	private double balance; // Account balance
	private Person accountHolder;
	private LocalDate accountCreation; // Date of account creation
	private final double RATE = 0.045; // Annual interest rate (i.e. 4.5%)
	
	// A default constructor
	public Account() {
		setAccountId(1);
		setBalance(100);
		setAccountHolder(new Person("John", "Smith", LocalDate.of(1990, 1, 1)));
		setAccountCreation(LocalDate.now());
	}
	
	// A constructor that accept parameters for all required fields
	public Account(int accountId, double balance, Person accountHolder) {
		setAccountId(accountId);
		setBalance(balance);
		setAccountHolder(accountHolder);
		setAccountCreation(LocalDate.now());
	}
	
	// Get and Set methods:
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Person getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Person accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	public LocalDate getAccountCreation() {
		return accountCreation;
	}
	public void setAccountCreation(LocalDate accountCreation) {
		this.accountCreation = accountCreation;
	}
	
	// Display all the details.
	public void display() {
		System.out.println("Account holder information");
		getAccountHolder().display();
		System.out.println("id: " + getAccountId());
		System.out.println("balance: " + getBalance());
		System.out.println("Date: " + getAccountCreation());
	}
	
	// Calculate monthly interest rate
	public double calculateMInterestRate() {
		return this.RATE / 12;
	}
	// Calculate monthly interest
	public double calculateMInterest() {
		return getBalance() * calculateMInterestRate();
	}
	
	// Withdraw a specified amount from the account.
	public void withdraw(double withdrawal) {
		double newBalance = getBalance() - withdrawal;
		setBalance(newBalance);
	}
	
	// Deposit a specified amount to the account.
	public void deposit(double deposit) {
		double newBalance = getBalance() + deposit;
		setBalance(newBalance);
	}
	
	
}
