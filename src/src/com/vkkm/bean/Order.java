package src.com.vkkm.bean;

public class Order {
	private int orderId;
	private int productId;
	private int orderedQuantity;//quantity placed
	private int userId;
	private int amount;
	private String orderDate;
	private String DeliveryDate;
	private String paymentMode; //net banking,credit,debit,cashondelivery
	private String deliveryTime; //delivery time mentioned by customer, default any
	private String orderStatus; //placed, confirmed,delivered
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}

}
