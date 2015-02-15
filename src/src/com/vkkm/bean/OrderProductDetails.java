package src.com.vkkm.bean;

import java.util.Date;

import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.AssociationOverride;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="OrderProductDetails")
@AssociationOverrides({
@AssociationOverride(name ="pk.orders", joinColumns = @JoinColumn(name ="orderId")),
@AssociationOverride(name ="pk.products", joinColumns = @JoinColumn(name ="productId"))
}) 
public class OrderProductDetails {
	
		private OrderProductDetailsPk pk =new OrderProductDetailsPk();
		private int quantity;
	   // private Date createdOn;

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		 public boolean equals(Object o) {
			 if (this== o) return true;
			 if (o ==null|| getClass() != o.getClass()) return false;
			  
			 OrderProductDetails that = (OrderProductDetails) o;
			  
			 if (getPk() !=null?!getPk().equals(that.getPk()) : that.getPk() !=null) return false;
			  
			 return true;
			 }
			  
			 public int hashCode() {
			 return (getPk() !=null? getPk().hashCode() : 0);
			 } 

		public int getQuantity() {
			return quantity;
		}
		
		/*public void setCreatedDate(Date createdDate) {
			this.createdOn = createdDate;
		}

		//to save current timestamp of placed order
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="createdOn", nullable = false,
		    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
		public Date getCreatedDate() {
			return createdOn;
		}
*/
		public void setPk(OrderProductDetailsPk pk) {
			this.pk = pk;
		}
		
		@EmbeddedId
		public OrderProductDetailsPk getPk() {
			return pk;
		}
		
		 @Transient
		 public ProductInfo getProducts() {
		 return getPk().getProducts();
		 }
		  
		 public void setProducts(ProductInfo products) {
		 getPk().setProducts(products);
		 } 
		
		 @Transient
		 public Order getOrders() {
			 return getPk().getOrders();
		 }
		  
		 public void setOrders(Order orders) {
		 getPk().setOrders(orders);
		 }

}
