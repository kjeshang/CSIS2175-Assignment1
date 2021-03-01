import java.util.Scanner;
import java.time.LocalDate;

/**
 * @param Utilizes Person and Account classes for input and output of account information
 */

public class ATMMachine {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String firstName, lastName;
		int year, month, dayOfMonth;
		LocalDate birthDate;
		int accountId; 
		double balance;
		Person[] person = new Person[1];
		Account[] account = new Account[person.length];
		
		// Enter Account Information
		for(int i = 0; i < person.length; i++) {
			System.out.println("Enter account holder information");
			System.out.println("Enter first name");
			firstName = input.next();
			System.out.println("Enter last name");
			lastName = input.next();
			System.out.println("Enter month of birth");
			month = input.nextInt();
			System.out.println("Enter day of birth");
			dayOfMonth = input.nextInt();
			System.out.println("Enter year of birth");
			year = input.nextInt();
			birthDate = LocalDate.of(year, month, dayOfMonth);
			person[i] = new Person(firstName, lastName, birthDate);
			System.out.println("Enter account id");
			accountId = input.nextInt();
			System.out.println("Enter account initial balance");
			balance = input.nextDouble();
			account[i] = new Account(accountId, balance, person[i]);
		}
		
		int id; // Account id given by ATM user
		int choice; // Main menu choice selection
		int index; // Index value that helps retrieve account holder information based on given account id
		// Refers to whether or not the user decides to use ATM machine (default = yes)
		boolean proceed = true;
		// Refers to whether or not the ATM machine managed to retrieve account holder information based on given account id (default = no)
		boolean found = false; 
		
		// ATM Machine
		while(proceed) {
			System.out.println("Welcome to ATM");
			System.out.println("Enter an id:");
			id = input.nextInt();
			index = accountIndex(id, account);
			if(id == account[index].getAccountId()) {
				found = true;
			}
			else {
				System.out.println("ID does not exist");
			}
			while(found == true) {
				mainMenu();
				System.out.println("Enter a choice: ");
				choice = input.nextInt();
				if(choice == 5) {
					System.out.println("Goodbye");
					proceed = false;
					break;
				}
				else {
					switch(choice) {
					case 1:
						System.out.println("The balance is " + account[index].getBalance());
						break;
					case 2:
						System.out.println("Enter the amount to withdraw ");
						double withdrawal = input.nextDouble();
						account[index].withdraw(withdrawal);
						break;
					case 3:
						System.out.println("Enter the amount to deposit ");
						double deposit = input.nextDouble();
						account[index].deposit(deposit);
						break;
					case 4:
						account[index].display();
						break;
					default:
						System.out.println("Invalid choice input");
						break;
					}
				}
			}
		}
		input.close();
		
	}
	
	// Main Menu options of ATM Machine
	public static void mainMenu() {
		System.out.println("MAIN MENU");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: account details");
		System.out.println("5: exit");
	}
	
	// Retrieve index of given account id from the account holder information database (i.e. array)
	public static int accountIndex(int id, Account[] account) {
		int index = 0;
		for(int i = 0; i < account.length; i++) {
			if(id == account[i].getAccountId()) {
				index = i;
				break;
			}
		}
		return index;
	}
}
