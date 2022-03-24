import java.util.Date;

public class Order {
	private int id;
	private Date date;
	private int customerId;
	
	public Order(int id, Date date, int customerId) {
		this.id = id;
		this.date = date;
		this.customerId = customerId;
	}
}
