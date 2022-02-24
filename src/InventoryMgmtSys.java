import java.util.Scanner;

public class InventoryMgmtSys {
	static Scanner in = new Scanner(System.in);
	static ProductList productList = new ProductList();
	
	public static void addNewProduct() {
		int price = 0, quantity = 0;
		boolean invalidInput = false;
		
		System.out.println("Please enter the name of the product:");
		String productName = in.nextLine();
		
		//price
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
		
		//quantity
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
		
		System.out.println("Please enter a description of the product:");
		String productDescription = in.nextLine();
		System.out.println("Please enter the category of the product:");
		String productCategory = in.nextLine();
		
		productList.addProduct(productName, price, quantity, null, productDescription, productCategory);
	}
	
	public static void main(String args[]) {
		System.out.println("Starting Inventory Management System...");
		String selectedMenu = "";
		
		while( !selectedMenu.equals("q") ) {
			
			System.out.println("Please select from the menu option below:");
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
					System.out.println("Edit product here...");
					break;
				case "3":
					System.out.println("Remove product here...");
					break;
				case "4":
					System.out.println("Search product here...");
					break;
				default:
					break;
			}
		}
		
		System.out.println("Thank you for using this app!");
	}
}
