import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

public class InventoryMgmtSys {
	static Scanner in = new Scanner(System.in);
	static ProductList productList = new ProductList();
	static CategoryList categoryList = new CategoryList();
	static CustomerList customerList = new CustomerList();
	static Cart cart = new Cart();
	static OrderList orderList = new OrderList();
	
	public static void addNewProduct() {
		int price = 0, quantity = 0;
		
		if( categoryList.getTotalNumOfCategories() <= 0 ) {
			System.out.println("Please add a category first before adding a product.");
			return;
		}
		
		System.out.println("Please enter the name of the product:");
		String productName = in.nextLine();
		
		price = getPriceFromUser(price);
		quantity = getQuantityFromUser(quantity);
		
		System.out.println("Please enter a description of the product:");
		String productDescription = in.nextLine();
		
		String productCategory = getCategoryFromUser();
		
		productList.addProduct(productName, price, quantity, null, productDescription, productCategory);
	}
	
	public static String getCategoryFromUser() {
		boolean invalidInput;
		String productCategory = null;
		
		do {
			try {
				invalidInput = false;	
	
				System.out.println("Please select from the product category from below:" + categoryList);
				String category = in.nextLine();
				
				productCategory = categoryList.getCategoryById( Integer.parseInt(category) );
			
				if( productCategory == null ) {
					System.out.println("Invalid category selected!");
					invalidInput = true;
				}
			} catch( NumberFormatException e ) {
				System.out.println("Invalid category selected!");
				invalidInput = true;
			}
			
		} while(invalidInput);
		
		return productCategory;
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
			productList.removeProduct( selectedProduct );
			System.out.println("Remaining products: " + productList.getTotalNumOfProducts());
		} else {
			System.out.println("Product not found!");
		}
	}
	
	public static void searchProduct() {
		Product selectedProduct = null;
		
		System.out.println("\nSearch By:");
		System.out.println("[1] Id");
		System.out.println("[2] Name");
		System.out.println("[3] Category");
		
		String selectedMenu = in.nextLine();
		
		switch( selectedMenu ) {
			case "1":
				System.out.println("Please enter the product id:");
				String productId = in.nextLine();
				
				try {
					selectedProduct = productList.getProductById( Integer.parseInt(productId) );
				} catch(NumberFormatException e) {
				}
				
				if( selectedProduct != null ) {
					System.out.println("\nProduct Details:\n " + selectedProduct);
				} else {
					System.out.println("Product not found!");
				}
				
				break;
			case "2":
				System.out.println("Please enter the product name:");
				String productName = in.nextLine();
				
				selectedProduct = productList.getProductByName( productName );
				
				if( selectedProduct != null ) {
					System.out.println("\nProduct Details:\n" + selectedProduct);
				} else {
					System.out.println("Product not found!");
				}
				
				break;
			case "3":
				System.out.println("Please enter the product category:");
				String category = in.nextLine();
				
				ArrayList<Product> productsInCategory = productList.getProductsByCategory(category);
				
				if( productsInCategory.size() > 0 ) {
					for( int i = 0; i < productsInCategory.size(); i++ ) {
						System.out.println( "\n" + productsInCategory.get(i) );
					}
				} else {
					System.out.println( "No products in that category!" );
				}
				
				break;
			default:
				System.out.println("Product not found!");
				break;
		}
	}
	
	public static void showProductMenu() {
		String selectedMenu = "";
			
		System.out.println("\nPlease select from the menu option below:");
		System.out.println("[1] Add New Product");
		System.out.println("[2] Edit Selected Product");
		System.out.println("[3] Remove Selected Product");
		System.out.println("[4] Search");
		
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
				System.out.println("Invalid menu option! Redirecting to main menu...");
				break;
		}

	}
	
	public static void showCategoryMenu() {
		String selectedMenu = "";
		
		System.out.println("\nPlease select from the menu option below:");
		System.out.println("[1] Insert New Category");
		System.out.println("[2] Update Selected Category");
		System.out.println("[3] Delete Selected Category");
		
		selectedMenu = in.nextLine();
		
		String categoryName;
		
		switch( selectedMenu ) {
			case "1":
				
				boolean invalidInput;
				
				do {
					invalidInput = false;
					
					System.out.println("Please enter the name of the category:");
					categoryName = in.nextLine();
					categoryName = categoryName.trim();
					
					var invalidName = categoryList.isExistingCategory(categoryName);
					
					if(invalidName) {
						invalidInput = true;
						System.out.println("Category name already exists!");
					}
					
					if( categoryName.equals("") ) {
						invalidInput = true;
						System.out.println("Invalid category name!");
					}
				
				} while( invalidInput );
					
				categoryList.addCategory(categoryName);
				System.out.println("Successfully added " + categoryName + " to the category list!");
					
				break;
			case "2":
				
				if( categoryList.getTotalNumOfCategories() > 0 ) {
					System.out.println("Select from the categories below:" + categoryList);
					String id = in.nextLine();
					String selectedCategory = null;
					
					try {
						int idInt = Integer.parseInt(id);
						selectedCategory = categoryList.getCategoryById( idInt );
						
						if( selectedCategory != null ) {
							System.out.println("Please enter the name of the category:");
							String newName = in.nextLine();
							
							categoryList.updateCategoryName(idInt, newName);
							
							System.out.println("Successfully updated category name!" + categoryList);
							
						} else {
							System.out.println("Invalid category id selected!");
						}
					} catch(NumberFormatException e) {
						System.out.println("Invalid category id selected!");
					}
					
				} else {
					System.out.println("No categories yet.");
				}

				break;
			case "3":
				
				if( categoryList.getTotalNumOfCategories() > 0 ) {
					System.out.println("Select from the categories below:" + categoryList);
					String id = in.nextLine();
					String selectedCategory = null;
					
					try {
						int idInt = Integer.parseInt(id);
						selectedCategory = categoryList.getCategoryById( idInt );
						
						if( selectedCategory != null ) {
							categoryList.deleteCategory(idInt);
							System.out.println("Successfully deleted category!" + categoryList);
						} else {
							System.out.println("Invalid category id selected!");
						}
					} catch(NumberFormatException e) {
						System.out.println("Invalid category id selected!");
					}
					
				} else {
					System.out.println("No categories yet.");
				}
				
				break;
			default:
				System.out.println("Invalid menu option! Redirecting to main menu...");
				break;
		}
	}
	
	public static void showCustomerMenu() {
		String selectedMenu = "";
		
		System.out.println("\nPlease select from the menu option below:");
		System.out.println("[1] Insert New Customer");
		System.out.println("[2] Edit Customer");
		System.out.println("[3] Remove Customer");
		System.out.println("[4] Search Customer");
		
		selectedMenu = in.nextLine();
		
		switch( selectedMenu ) {
			case "1":
				addNewCustomer();
				break;
			case "2":
				editCustomer();
				break;
			case "3":
				removeCustomer();
				break;
			case "4":
				searchCustomer();
				break;
			default:
				System.out.println("Invalid menu option! Redirecting to main menu...");
				break;
		}
	}
	
	public static void addNewCustomer() {
		String firstName = "", lastName = "", phoneNumStr = "", email = null;
		boolean isEmpty = false, isInvalid = false;
		int phoneNum = 0;
		
		//first name
		do {
			isEmpty = false;
			
			System.out.println("Please enter the first name of the customer:");
			firstName = in.nextLine();
			firstName = firstName.trim();
			
			if( firstName.equals("") ) {
				isEmpty = true;
				System.out.println("Invalid first name!");
			}
			
		} while( isEmpty );
		
		//last name
		do {
			isEmpty = false;
			
			System.out.println("Please enter the last name of the customer:");
			lastName = in.nextLine();
			lastName = lastName.trim();
			
			if( lastName.equals("") ) {
				isEmpty = true;
				System.out.println("Invalid last name!");
			}
			
		} while( isEmpty );

		//phone number
		do {
			try {
				isInvalid = false;
				
				System.out.println("Please enter the phone number of the customer:");
				phoneNumStr = in.nextLine();
				
				if( phoneNumStr.trim().equals("") ) {
					isInvalid = true;
					System.out.println("Invalid phone number!");
				} else {
					phoneNum = Integer.parseInt(phoneNumStr);
				}
				
			} catch(NumberFormatException e) {
				isInvalid = true;
				System.out.println("Invalid phone number!");
			}
			
		} while( isInvalid );
		
		//email
		System.out.println("Please enter the email of the customer:");
		email = in.nextLine();
		
		if( email.isEmpty() ) {
			email = null;
		}
		
		customerList.addCustomer(firstName, lastName, phoneNum, email);
	}
	
	public static void searchCustomer() {
		Customer customer = null;
		String customerId = null;
		
		System.out.println("Please enter the customer id:");
		customerId = in.nextLine();
		
		try {
			customer = customerList.getCustomerById( Integer.parseInt(customerId) );
		} catch(NumberFormatException e) {
		}
		
		if( customer != null ) {
			System.out.println("\nCustomer Details:\n" + customer);
		} else {
			System.out.println("Customer not found!");
		}
	}
	
	public static void editCustomer() {
		Customer customer = null;
		String customerId = null;
		String selectedMenu = "";
		
		System.out.println("Please enter the customer id:");
		customerId = in.nextLine();
		
		try {
			customer = customerList.getCustomerById( Integer.parseInt(customerId) );
		} catch(NumberFormatException e) {
		}
		
		if( customer != null ) {
			while( !selectedMenu.toUpperCase().equals("X") ) {
				
				System.out.println("\nPlease select from the menu option below:");
				System.out.println("[1] Edit First Name");
				System.out.println("[2] Edit Last Name");
				System.out.println("[3] Edit Phone Number");
				System.out.println("[4] Edit Email");
				System.out.println("[X] Cancel");
				
				selectedMenu = in.nextLine();
				
				switch( selectedMenu ) {
					case "1":
						System.out.println("Please enter the new first name:");
						String newName = in.nextLine();
						
						customer.setFirstName(newName);
						
						System.out.println("Successfully changed customer first name to " + customer.getFirstName() + "!");
						
						break;
					case "2":
						System.out.println("Please enter the new last name:");
						String newLastName = in.nextLine();
						
						customer.setLastName(newLastName);
						
						System.out.println("Successfully changed customer last name to " + customer.getLastName() + "!");
						
						break;
					case "3":
						System.out.println("Please enter the new phone number:");
						String newTelNum = in.nextLine();
						
						try {
							customer.setPhoneNum( Integer.parseInt(newTelNum) );
							
							System.out.println("Successfully changed customer phone number to " + customer.getPhoneNum() + "!");
						} catch(NumberFormatException e) {
							System.out.println("Invalid phone number entered!");
						}
							
						break;
					case "4":
						System.out.println("Please enter the new email addres:");
						String newEmail = in.nextLine();
						
						customer.setEmail(newEmail);
						
						System.out.println("Successfully changed customer email to " + customer.getEmail() + "!");
						break;
					default:
						break;
				}
			}

		} else {
			System.out.println("Customer not found!");
		}
	}
	
	public static void removeCustomer() {
		Customer customer = null;
		String customerId = null;
		
		System.out.println("Please enter the customer id:");
		customerId = in.nextLine();
		
		try {
			customer = customerList.getCustomerById( Integer.parseInt(customerId) );
		} catch(NumberFormatException e) {
		}
		
		if( customer != null ) {
			customerList.removeCustomer(customer);
			System.out.println("Remaining customers: " + customerList.getTotalNumOfCustomers());
		} else {
			System.out.println("Customer not found!");
		}
	}
	
	public static void showOrderMenu() {
		String selectedMenu = "";
		
		System.out.println("\nPlease select from the menu option below:");
		System.out.println("[1] Insert Order");
		System.out.println("[2] Show All Orders");
		
		selectedMenu = in.nextLine();
		
		switch( selectedMenu ) {
			case "1":
				showCartMenu();
				break;
			case "2":
				System.out.println(orderList);
				break;
			default:
				System.out.println("Invalid menu option! Redirecting to main menu...");
				break;
		}
	}
	
	public static void insertOrder() {
		ArrayList<Product> allProducts = productList.getAllProducts();
		String selectedProductId = "";
		Product selectedProduct = null;
		
		if( allProducts.size() > 0 ) {
			boolean validProductId = true;
			
			do {
				validProductId = true;
				
				System.out.println("\nPlease select from the products below:");
				
				for( int i=0; i < allProducts.size(); i++ ) {
					int productId = allProducts.get(i).getId();
					String productName = allProducts.get(i).getName();
					float productPrice = allProducts.get(i).getPrice();
					int productQuantity = allProducts.get(i).getQuantity();
					
					System.out.println("[" + productId + "] " + productName + "\nPrice: " + productPrice + 
							"\nQuantity: " + productQuantity );
				}
				
				selectedProductId = in.nextLine();
				
				try {
					selectedProduct = productList.getProductById(Integer.parseInt(selectedProductId));
				} catch(NumberFormatException e) {
				}
				
				if( selectedProduct != null ) {
					System.out.println("Please enter the number of ordered items:");
					
					try {
						int itemCount = Integer.parseInt(in.nextLine());
						
						if( itemCount > 0 ) {
							int selectedProductQuantity = selectedProduct.getQuantity();
							int itemCountInCart = cart.getNumberOfItem(selectedProduct.getId());
							
							if( selectedProductQuantity < itemCount + itemCountInCart ) {
								System.out.println("Not enough items on stock");
							} else {
								cart.addItem(selectedProduct, itemCount);
								System.out.println("Successfully added item to cart!");
							}
							
							System.out.println("\n" + cart);
							
						} else {
							validProductId = false;
							System.out.println("Invalid value entered!");
						}
						
					} catch(NumberFormatException e) {
						validProductId = false;
						System.out.println("Invalid value entered!");
					}
					
				} else {
					validProductId = false;
					System.out.println("Invalid product id entered!");
				}
			} while( !validProductId );
			
		} else {
			System.out.println("No products added yet!");
		}
	}
	
	public static void showCartMenu() {
		String selectedMenu = "";
		boolean isOrderPlaced = false;
		
		do {
			System.out.println("\nPlease select from the options below:");
			System.out.println("[1] Add Item");
			System.out.println("[2] Edit Item Quantity");
			System.out.println("[3] Remove Item");
			System.out.println("[4] Clear Cart");
			System.out.println("[5] Place Order");
			System.out.println("[X] Cancel");
			
			selectedMenu = in.nextLine();
			selectedMenu = selectedMenu.toLowerCase();
			
			switch( selectedMenu ) {
				case "1":
					insertOrder();
					break;
				case "2":
					editItem();
					break;
				case "3":
					removeItem();
					break;
				case "4":
					cart.clear();
					System.out.println("\n" + cart);
					break;
				case "5":
					placeOrder();
					isOrderPlaced = true;
					break;
				case "x":
					isOrderPlaced = true;
					break;
				default:
					System.out.println("Invalid menu option!");
					break;
			}
		} while(!isOrderPlaced);
	}
	
	public static void removeItem() {
		System.out.println("Please enter the product id:");
		String productId = in.nextLine();
		
		try {
			cart.removeItem(Integer.parseInt(productId));
			System.out.println("\n" + cart);
			
		} catch(Exception e) {
			System.out.println("Error removing item!");
		}
	}
	
	public static void editItem() {
		System.out.println("Please enter the product id:");
		String productId = in.nextLine();
		
		Product selectedProduct = null;
		
		try {
			selectedProduct = productList.getProductById(Integer.parseInt(productId));
		} catch(NumberFormatException e) {
		}
		
		if( selectedProduct != null ) {
			System.out.println("Please enter the number of ordered items:");
			
			try {
				int itemCount = Integer.parseInt(in.nextLine());
				
				if( itemCount > 0 ) {
					int selectedProductQuantity = selectedProduct.getQuantity();
					
					if( selectedProductQuantity < itemCount ) {
						System.out.println("Not enough items on stock");
					} else {
						cart.editItem(selectedProduct, itemCount);
						System.out.println("Successfully added item to cart!");
					}
					
					System.out.println("\n" + cart);
					
				} else {
					System.out.println("Invalid value entered!");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Invalid value entered!");
			}
			
		} else {
			System.out.println("Invalid product id entered!");
		}
	}
	
	public static void placeOrder() {
		boolean invalidInput;
		Customer customer = null;
		int numOfCustomers = customerList.getTotalNumOfCustomers();
		int itemsCount = cart.getTotalNumberOfItems();
		
		if( numOfCustomers <= 0 ) {
			System.out.println("No customers added yet. Please add customer first.");
			return;
		}
		
		if( itemsCount <= 0 ) {
			System.out.println("Cannot place order with empty cart.");
			showCartMenu();
			return;
		}
		
		do {
			try {
				invalidInput = false;	
	
				System.out.println("\nPlease enter the customer id for the order:\n" + customerList);
				String custId = in.nextLine();
				
				customer = customerList.getCustomerById( Integer.parseInt(custId) );
			
				if( customer == null ) {
					System.out.println("Invalid customer id entered!");
					invalidInput = true;
				} else {
					orderList.addOrder(Integer.parseInt(custId));
					System.out.println("Successfully placed order for " + customer.getFirstName() +
							" " + customer.getLastName());
					
					Hashtable<Integer, Integer> cartItems = cart.getItemsCount();
					
					for(Integer key : cartItems.keySet()) {
						Product product = productList.getProductById(key);
						int currentQty = product.getQuantity();
						
						product.setQuantity(currentQty - cartItems.get(key));
					}
					
					customer.setOrdersCount(customer.getOrdersCount() + 1);
					customer.setLastOrderDate(new Date());
					customer.setTotalOrdersAmount(customer.getTotalOrdersAmount() + cart.getTotalAmount());
					
					cart.clear();
				}
				
			} catch( NumberFormatException e ) {
				System.out.println("Invalid customer id entered!");
				invalidInput = true;
			}
			
		} while(invalidInput);
		
	}

	public static void main(String args[]) {
		System.out.println("Starting Inventory Management System...");
		String selectedMenu = "";
		
		while( !selectedMenu.equals("q") ) {
			
			System.out.println("\nPlease select from the menu option below:");
			System.out.println("[1] Product");
			System.out.println("[2] Category");
			System.out.println("[3] Customer");
			System.out.println("[4] Order");
			System.out.println("[q] Quit");
			
			selectedMenu = in.nextLine();
			
			switch( selectedMenu ) {
				case "1":
					showProductMenu();
					break;
				case "2":
					showCategoryMenu();
					break;
				case "3":
					showCustomerMenu();
					break;
				case "4":
					showOrderMenu();
					break;
				default:
					break;
			}
		}
		
		System.out.println("Thank you for using this app!");
	}

}
