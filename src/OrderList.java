import java.util.ArrayList;
import java.util.Date;

public class OrderList {
	private ArrayList<Order> orders = new ArrayList<>();
	
	public void addOrder(int customerId) {
		int id = this.orders.size() + 1;
		
		this.orders.add( new Order(id, new Date(), customerId) );
	}
	
	public String toString() {
		String retStr = "No orders yet.";
		
		if( this.orders.size() > 0 ) {
			retStr = "Orders:\n";
			
			for(int i = 0; i < this.orders.size(); i++) {
				retStr += this.orders.get(i) + "\n";
			}
		}
		
		return retStr;
	}
}
