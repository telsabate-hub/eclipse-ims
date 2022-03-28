import java.util.ArrayList;
import java.util.Date;

public class OrderList {
	private ArrayList<Order> orders = new ArrayList<>();
	
	public void addOrder(int customerId) {
		int id = this.orders.size() + 1;
		
		this.orders.add( new Order(id, new Date(), customerId) );
	}
}
