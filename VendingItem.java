package vending;

public class VendingItem {

	private String kind;
	private int quantity;
	private double price;
	
	public VendingItem() {
		super();
	}

	public VendingItem(String kind, int quantity, double price) {
		super();
		this.kind = kind;
		this.quantity = quantity;
		this.price = price;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VendingItem [kind=" + kind + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
