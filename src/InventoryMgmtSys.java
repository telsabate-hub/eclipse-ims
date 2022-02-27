import java.util.Scanner;

public class InventoryMgmtSys {
	static Scanner in = new Scanner(System.in);
	static ProductList productList = new ProductList();
	
	public static void addNewProduct() {
		int price = 0, quantity = 0;
		
		System.out.println("Please enter the name of the product:");
		String productName = in.nextLine();
		
		price = getPriceFromUser(price);
		quantity = getQuantityFromUser(quantity);
		
		System.out.println("Please enter a description of the product:");
		String productDescription = in.nextLine();
		System.out.println("Please enter the category of the product:");
		String productCategory = in.nextLine();
		
		productList.addProduct(productName, price, quantity, null, productDescription, productCategory);
	}

	public static int getQuantityFromUser(int quantity) {
		boolean invalidInput;
		do {
			try {
				invalidInput = false;	

				System.out.println("Please enter the quantity of the product:");
				String productQuantity = in.nextLine();
				
				quantity = Integer.parseInt(productQuantity);
			
				if( quantity < 0 ) {
					System.out.println("Quantity cannot have a negative value!");
					invalidInput = true;
				}
				
			} catch( NumberFormatException e ) {
				System.out.println("Invalid product quantity!");
				invalidInput = true;
			}
		} while(invalidInput);
		return quantity;
	}

	public static int getPriceFromUser(int price) {
		boolean invalidInput;
		
		do {
			try {
				invalidInput = false;	

				System.out.println("Please enter the price of the product:");
				String productPrice = in.nextLine();
				
				price = Integer.parseInt(productPrice);
			
				if( price <= 0 ) {
					System.out.println("Price cannot have a negative value!");
					invalidInput = true;
				}
				
			} catch( NumberFormatException e ) {
				System.out.println("Invalid product price!");
				invalidInput = true;
			}
		} while(invalidInput);
		
		return price;
	}
	
	public static void editProduct() {
		System.out.println("Please enter the product id:");
		String productId = in.nextLine();
		String selectedMenu = "";
		Product selectedProduct = null;
		
		try {
			selectedProduct = productList.getProductById( Integer.parseInt(productId) );
		} catch(NumberFormatException e) {
		}
		
		if( selectedProduct != null ) {

			while( !selectedMenu.toUpperCase().equals("X") ) {
				
				System.out.println("\nPlease select from the menu option below:");
				System.out.println("[1] Edit Name");
				System.out.println("[2] Edit Price");
				System.out.println("[3] Edit Quantity");
				System.out.println("[4] Edit Image");
				System.out.println("[5] Edit Description");
				System.out.println("[6] Edit Category");
				System.out.println("[X] Cancel");
				
				selectedMenu = in.nextLine();
				
				switch( selectedMenu ) {
					case "1":
						System.out.println("Please enter the new name:");
						String newName = in.nextLine();
						
						selectedProduct.setName(newName);
						
						System.out.println("Successfully changed product name to " + selectedProduct.getName() + "!");
						
						break;
					case "2":
						int price = 0;
						price = getPriceFromUser(price);
						
						selectedProduct.setPrice(price);
						
						System.out.println("Successfully changed product price to " + selectedProduct.getPrice() + "!");
						
						break;
					case "3":
						int quantity = 0;
						quantity = getQuantityFromUser(quantity);
						
						selectedProduct.setQuantity(quantity);
						
						System.out.println("Successfully changed product quantity to " + selectedProduct.getQuantity() + "!");
						
						break;
					case "4":
						break;
					case "5":
						System.out.println("Please enter a description of the product:");
						String productDescription = in.nextLine();
						
						selectedProduct.setDescription(productDescription);
						
						System.out.println("Successfully changed product description to " + selectedProduct.getDescription() + "!");
						
						break;
					case "6":
						System.out.println("Please enter the category of the product:");
						String productCategory = in.nextLine();
						
						selectedProduct.setCategory(productCategory);
						
						System.out.println("Successfully changed product description to " + selectedProduct.getCategory() + "!");
						
						break;
					default:
						break;
				}
			}
			
			
		} else {
			System.out.println("Product not found!");
		}
	}
	
	public static void removeProduct() {
		System.out.println("Please enter the product id:");
		String productId = in.nextLine();
		Product selectedProduct = null;
		
		try {
			selectedProduct = productList.getProductById( Integer.parseInt(productId) );
		} catch(NumberFormatException e) {
		}
		
		if( selectedProduct != null ) {
			productList.removeProduct( Integer.parseInt(productId) );
			System.out.println("Remaining products: " + productList.getTotalNumOfProducts());
		} else {
			System.out.println("Product not found!");
		}
	}
	
	public static void searchProduct() {
		
	}
	
	public static void main(String args[]) {
		System.out.println("Starting Inventory Management System...");
		String selectedMenu = "";
		
		while( !selectedMenu.equals("q") ) {
			
			System.out.println("\nPlease select from the menu option below:");
			System.out.println("[1] Add New Product");
			System.out.println("[2] Edit Selected Product");
			System.out.println("[3] Remove Selected Product");
			System.out.println("[4] Search");
			System.out.println("[q] Quit");
			
			selectedMenu = in.nextLine();
			
			switch( selectedMenu ) {
				case "1":
					addNewProduct();
					break;
				case "2":
					editProduct();
					break;
				case "3":
					removeProduct();
					break;
				case "4":
					searchProduct();
					break;
				default:
					break;
			}
		}
		
		System.out.println("Thank you for using this app!");
	}

}
