import java.util.Date;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private int phoneNum;
	private String email;
	private int ordersCount;
	private float totalOrdersAmount;
	private Date lastOrderDate;
	
	public Customer(int id, String firstName, String lastName, int phoneNum) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
		
		this.setOrdersCount(0);
		this.setTotalOrdersAmount(0);
	}
	
	public Customer(int id, String firstName, String lastName, int phoneNum, String email) {
		this.id = id;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNum(phoneNum);
		this.setEmail(email);
	}
	
	public int getId() {
		return this.id;
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

	public int getOrdersCount() {
		return ordersCount;
	}

	public void setOrdersCount(int ordersCount) {
		this.ordersCount = ordersCount;
	}

	public float getTotalOrdersAmount() {
		return totalOrdersAmount;
	}

	public void setTotalOrdersAmount(float totalOrdersAmount) {
		this.totalOrdersAmount = totalOrdersAmount;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}
	
	public String toString() {
		String customerDetails = toStringNoEmail();
		
		if( this.email != null ) {
			customerDetails += this.email;
		}
		
		customerDetails += toStringOrderDetails();
		
		return customerDetails;
	}
	
	public String toStringNoEmail() {
		return "Customer id: " + this.id + "\nFirst Name: " + this.firstName + "\nLast Name: " + this.lastName +
				"\nTel: " + this.phoneNum + "\nEmail:";
	}
	
	public String toStringOrderDetails() {
		return "\nOrders Count: " + this.ordersCount + "\nTotal Orders Amount: " + this.totalOrdersAmount + 
				"\nLast Order Date: " + this.lastOrderDate;
	}
}
