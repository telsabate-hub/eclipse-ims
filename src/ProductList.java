import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ProductList {
	private ArrayList<Product> products = new ArrayList<>();
	
	public void addProduct(String name, int price, int quantity, ImageIcon image, String description,
					String category) {
		int id = this.products.size() + 1;
		this.products.add( new Product(id, name, price, quantity, image, description, category) );
	}

	public Product getProductById(int id) {		
		for(int i = 0; i < this.products.size(); i++) {
			if( this.products.get(i).getId() == id ) {
				return this.products.get(i);
			}
		}

		return null; 
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public int getTotalNumOfProducts() {
		return this.products.size();
	}
	
	public Product getProductByName(String name) {
		for( int i = 0; i < this.products.size(); i++ ) {
			if( this.products.get(i).getName().toLowerCase().equals(name.toLowerCase().trim()) ) {
				return this.products.get(i);
			}
		}
		
		return null;
	}
	
	public ArrayList<Product> getProductsByCategory(String category){
		ArrayList<Product> productList = new ArrayList<>();
		
		for( int i = 0; i < this.products.size(); i++ ) {
			if( this.products.get(i).getCategory().toLowerCase().equals( category.toLowerCase().trim() ) ) {
				productList.add( this.products.get(i) );
			}
		}
		
		return productList;
	}
	
	public ArrayList<Product> getAllProducts(){
		return this.products;
	}
	
}
