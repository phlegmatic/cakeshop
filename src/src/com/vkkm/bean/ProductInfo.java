package src.com.vkkm.bean;

public class ProductInfo {
    private String productId;
	private String productCategory; //cake,wedding cake, kgwise, pastry
    private String name; //black forest etc
    private String description; //detail info
	private String SellingPrice ;//cost to customer
	private String ManufacturingCost ; //cost to company
	private int duration; //in days 
    private int availableQuantity; //
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSellingPrice() {
		return SellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		SellingPrice = sellingPrice;
	}
	public String getManufacturingCost() {
		return ManufacturingCost;
	}
	public void setManufacturingCost(String manufacturingCost) {
		ManufacturingCost = manufacturingCost;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
    
    
        
}
