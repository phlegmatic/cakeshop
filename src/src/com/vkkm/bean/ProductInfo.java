package src.com.vkkm.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="ProductInfo")
public class ProductInfo {

	private int productId;
	private String productCategory; //cake,wedding cake, kgwise, pastry
	private String productName; //black forest etc
	private String description; //detail info
	private int SellingPrice ;//cost to customer
	private int ManufacturingCost ; //cost to company
	//private int duration;//in days
	//private Date createdDate; 
	private int availableQuantity; //
	private String filepath; //imagepath
	private Set<OrderProductDetails> orderProducts = new HashSet<OrderProductDetails>(0);


	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSellingPrice() {
		return SellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		SellingPrice = sellingPrice;
	}
	public int getManufacturingCost() {
		return ManufacturingCost;
	}
	public void setManufacturingCost(int manufacturingCost) {
		ManufacturingCost = manufacturingCost;
	}
	/*public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}*/
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setOrderProducts(Set<OrderProductDetails> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.products", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN}) 
	public Set<OrderProductDetails> getOrderProducts() {
		return orderProducts;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "productName",unique=true)
	public String getProductName() {
		return productName;
	}
	/*@Temporal(TemporalType.DATE)
	@Column(name = "createdOn", nullable = false, length = 10)
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}*/             
}
