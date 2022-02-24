import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ProductList {
	private ArrayList<Product> products = new ArrayList<>();
	
	public void addProduct(String name, int price, int quantity, ImageIcon image, String description,
					String category) {
		int id = this.products.size() + 1;
		this.products.add( new Product(id, name, price, quantity, image, description, category) );
	}
}
