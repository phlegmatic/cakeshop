package src.com.vkkm.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderProductDetailsPk implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Order orders;
	private ProductInfo products;

	public void setOrders(Order orders) {
		this.orders = orders;
	}
	
	@ManyToOne
	public Order getOrders() {
		return orders;
	}

	public boolean equals(Object o) {
		if (this== o) return true;
		if (o ==null|| getClass() != o.getClass()) return false;

		OrderProductDetailsPk that = (OrderProductDetailsPk) o;

		if (orders !=null?!orders.equals(that.orders) : that.orders !=null) return false;
		if (products !=null?!products.equals(that.products) : that.products !=null)return false;

		return true;
	}

	public int hashCode() {
		int result;
		result = (orders !=null? orders.hashCode() : 0);
		result =31* result + (products !=null? products.hashCode() : 0);
		return result;
	} 

	public void setProducts(ProductInfo products) {
 		this.products = products;
	}

	@ManyToOne
	public ProductInfo getProducts() {
		return products;
	}
}
