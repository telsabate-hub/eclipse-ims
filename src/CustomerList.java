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
		for(int i = 0; i < this.customers.size(); i++) {
			if( this.customers.get(i).getId() == id ) {
				return this.customers.get(i);
			}
		}

		return null; 
	}
	
	public void removeCustomer(Customer cust) {
		this.customers.remove(cust);
	}
	
	public int getTotalNumOfCustomers() {
		return this.customers.size();
	}
	
}
