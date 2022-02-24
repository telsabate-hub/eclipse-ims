import javax.swing.ImageIcon;

public class Product {
	private int id;
	private String name;
	private int price;
	private int quantity;
	private ImageIcon image;
	private String description;
	private String category;
	
	public Product(int id, String name, int price, int quantity, ImageIcon image, String description,
					String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.category = category;
	}
	
	public void updateProductDetails(String name, int price, int quantity, ImageIcon image, String description,
			String category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.category = category;
	}
}
