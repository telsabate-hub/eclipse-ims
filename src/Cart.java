import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Cart {
	private Hashtable<Integer, Integer> itemsCount = new Hashtable<Integer, Integer>();
	private Hashtable<Integer, Product> products = new Hashtable<Integer, Product>();
	private float totalAmount;
	
	public Cart() {
		this.totalAmount = 0;
	}
	
	public void addItem(Product product, int count) {
		int itemCount = count;
		int productId = product.getId();
		
		if( this.products.get(productId) != null ) {
			itemCount = this.itemsCount.get(productId) + count;
		} 
		
		this.products.put(productId, product);
		this.itemsCount.put(productId, itemCount);
		
		this.totalAmount += product.getPrice() * count;
	}
	
	public void removeItem(int productId) {
		try {
			this.products.remove(productId);
			this.itemsCount.remove(productId);
			
			updateTotalAmount();
			
		} catch(Exception e) {
			System.out.println("No such item in cart!");
		}
	}
	
	public void clear() {
		this.products.clear();
		this.itemsCount.clear();
		this.totalAmount = 0;
	}
	
	public void updateTotalAmount() {
		float total = 0;
		Enumeration<Integer> enu = this.itemsCount.keys();
		
		while (enu.hasMoreElements()) {
			int productId = enu.nextElement();
			
			total += this.products.get(productId).getPrice() * this.itemsCount.get(productId);
		}
		
		this.totalAmount = total;
	}
	
	public void editItem(Product product, int count) {
		int newCount = count;
		int productId = product.getId();
		int oldCount = this.itemsCount.get(productId);
		float oldSubtotal = product.getPrice() * oldCount;
		
		this.totalAmount -= oldSubtotal;
		
		this.itemsCount.put(productId, newCount);
		
		this.totalAmount += product.getPrice() * count;
	}
	
	public String toString() {
		String retStr = "Cart Items:";
		Enumeration<Integer> enu = this.itemsCount.keys();
		
		while (enu.hasMoreElements()) {
			int productId = enu.nextElement();
			retStr += "\n[" + productId + "] " + this.products.get(productId).getName() + "\t-\t" + 
						this.itemsCount.get(productId) + "\tSubtotal: " + this.products.get(productId).getPrice() * this.itemsCount.get(productId);
		}
		
		retStr += "\n\nTotal Amount = " + this.totalAmount;
		
		return retStr;
	}
	
	public int getTotalNumberOfItems() {
		return this.itemsCount.size();
	}
	
	public Hashtable<Integer, Integer> getItemsCount(){
		return this.itemsCount;
	}
	
}
