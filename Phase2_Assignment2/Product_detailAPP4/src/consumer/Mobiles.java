package consumer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mobiles implements Serializable{
	
	private String productId;
    private String productName;
    private double price;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Mobiles [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}

	
}
