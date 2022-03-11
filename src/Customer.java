
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private int phoneNum;
	private String email;
	
	public Customer(int id, String firstName, String lastName, int phoneNum) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
	}
	
	public Customer(int id, String firstName, String lastName, int phoneNum, String email) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
		this.setEmail(email);
	}
	
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

	public int getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String customerDetails = toStringNoEmail();
		
		if( this.email != null ) {
			customerDetails += "\nEmail: " + this.email;
		}
		
		return customerDetails;
	}
	
	public String toStringNoEmail() {
		return "Customer id: " + this.id + "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName +
				"\nTel: " + this.phoneNum + "\nEmail:";
	}
}
