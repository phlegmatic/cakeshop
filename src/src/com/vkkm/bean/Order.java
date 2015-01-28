package src.com.vkkm.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@GeneratedValue
	private int orderId;
	
	@ManyToOne
    @JoinColumn(name = "userid")
	private User user;
	
	private int amount;
	private String orderDate;
	private String DeliveryDate;
	private String paymentMode; //net banking,credit,debit,cashondelivery
	private String deliveryTime; //delivery time mentioned by customer, default any
	private String orderStatus; //placed, confirmed,delivered
	private int orderedQuantity;//quantity placed
	
	@ManyToOne
    @JoinColumn(name = "addressId")
	private Address address;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="OrderDetails",
                joinColumns={@JoinColumn(name="orderId")},
                inverseJoinColumns={@JoinColumn(name="productId")})
    private Set<ProductInfo> orderDetails = new HashSet<ProductInfo>();
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderDetails(Set<ProductInfo> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Set<ProductInfo> getOrderDetails() {
		return orderDetails;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}

}
