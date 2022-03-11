import java.util.ArrayList;

public class CustomerList {
	private ArrayList<Customer> customers = new ArrayList<>();

	public void addCustomer(String firstName, String lastName, int phoneNum, String email) {
		int id = this.customers.size() + 1;
		
		if( email != null ) {
			this.customers.add( new Customer(id, firstName, lastName, phoneNum, email) );
		} else {
			this.customers.add( new Customer(id, firstName, lastName, phoneNum) );
		}
	}
	
	public Customer getCustomerById(int id) {
		try {
			return this.customers.get(id);
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
}
