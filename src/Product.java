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
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setImage(image);
		this.setDescription(description);
		this.setCategory(category);
	}
	
	public void updateProductDetails(String name, int price, int quantity, ImageIcon image, String description,
			String category) {
		this.name = name;
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setImage(image);
		this.setDescription(description);
		this.setCategory(category);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
