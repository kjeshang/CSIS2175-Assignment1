import java.time.LocalDate;

/**
 * @param Contains basic information of the account holder
 */

public class Person {
	
	private String firstName;
	private String lastName;
	private LocalDate birthDate; // Date of Birth
	
	//public Person() {}
	
	// A constructor that accept parameters for each field
	public Person(String firstName, String lastName, LocalDate birthDate) {
		setFirstName(firstName);
		setLastName(lastName);
		setBirthDate(birthDate);
	}
	
	// Get and Set methods:
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate dateOfBirth) {
		this.birthDate = dateOfBirth;
	}
	
	// Display a person’s details.
	public void display() {
		System.out.println("first name: " + getFirstName());
		System.out.println("last name: " + getLastName());
		System.out.println("DOB: " + getBirthDate());
	}
	
	
	
}
