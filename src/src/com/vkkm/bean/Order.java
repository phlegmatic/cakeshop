package src.com.vkkm.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OrderInfo")
public class Order {
	
	private int orderId;
	private User user;
	private int amount;
	private String orderDate;
	private String DeliveryDate;
	private String paymentMode; //net banking,credit,debit,cashondelivery
	private String deliveryTime; //delivery time mentioned by customer, default any
	private String orderStatus; //placed, confirmed,delivered
	private Address address;
	private Set<OrderProductDetails> orderProducts = new HashSet<OrderProductDetails>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
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
	
	@ManyToOne
    @JoinColumn(name = "userid")
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
	
	public void setAddress(Address address) {
		this.address = address;
	}
	@ManyToOne
    @JoinColumn(name = "addressId")
	public Address getAddress() {
		return address;
	}
	public void setOrderProducts(Set<OrderProductDetails> orderProducts) {
		this.orderProducts = orderProducts;
	}
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "pk.orders",cascade=CascadeType.ALL)
	public Set<OrderProductDetails> getOrderProducts() {
		return orderProducts;
	}

}
