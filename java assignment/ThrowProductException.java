/*
 * The program creates new products.
 * If the price or product number of the product being created is invalid, the program throws a product exception.
 */
import javax.swing.*;

class ProductException extends Exception {
	// constructor receives String with product number and price
	public ProductException(String description) {
		// outputs message that Product object could not be created
		super(description);
	}
}

class Product {
	// initializes fields
	int productNum;
	double price;

	// constructor that takes in productNum and price
	public Product(int productNum, double price) throws ProductException {
		// tests if product number is 3 digits			
		if ((productNum < 100) || (productNum > 999)) {
			throw (new ProductException("Product object could not be created: product number #" + productNum + " is invalid.\n"));	
		} 
		
		// tests if price is between $0.01 and $1000
		if ((price < .01) || (price > 1000)) {
			throw (new ProductException("Product object could not be created: price $" + price + " is invalid.\n"));
		}
		// assigns values to product
		this.productNum = productNum;
		this.price = price;				
		System.out.println("Product object created successfully. Product number: " + this.productNum + ". Price: $" + this.price + ".\n");
	}
}

public class ThrowProductException {

	public static void main(String[] args) throws ProductException {

		// valid product objects
		try {
			Product product1 = new Product(451, 4.5);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}
		try {
			Product product2 = new Product(123, 1000);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}
		try {
			Product product3 = new Product(100, .01);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}

		// invalid product number (4 digits)
		try {
			Product invalidNum = new Product(1234, 23);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}

		// invalid price ($0)
		try {
			Product invalidPrice = new Product(123, 0);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}

		// invalid product number and price
		try {
			Product invalid = new Product(2, 1234);
		} catch (ProductException error) {
			System.out.println(error.getMessage());
		}

	}

}
