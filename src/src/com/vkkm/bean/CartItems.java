package src.com.vkkm.bean;

import java.util.List;

public class CartItems {
		 
		  
		   private int prodId;
		   private String prodName;
		   private User customer;
		   private int prodSellingPrice;
		   private int qtyOrdered;
		 
		    
		   public CartItems(int prodId,String prodName,int prodSellingPrice, User customer,
				int qtyOrdered) {
			super();
			
			this.setProdId(prodId);
			this.customer = customer;
			this.prodName =prodName;
			this.prodSellingPrice =prodSellingPrice;
			this.qtyOrdered = qtyOrdered;
		}

		public int getQtyOrdered() {
		      return qtyOrdered;
		   }
		 
		   public void setQtyOrdered(int qtyOrdered) {
		      this.qtyOrdered = qtyOrdered;
		   }

		

		public void setCustomer(User customer) {
			this.customer = customer;
		}

		public User getCustomer() {
			return customer;
		}

		public void setProdId(int prodId) {
			this.prodId = prodId;
		}

		public int getProdId() {
			return prodId;
		}

		public void setProdSellingPrice(int prodSellingPrice) {
			this.prodSellingPrice = prodSellingPrice;
		}

		public int getProdSellingPrice() {
			return prodSellingPrice;
		}

		public void setProdName(String prodName) {
			this.prodName = prodName;
		}

		public String getProdName() {
			return prodName;
		}

		
		
	
}
