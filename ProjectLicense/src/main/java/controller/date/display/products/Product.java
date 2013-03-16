package controller.date.display.products;

public class Product {

	private int id;
	private String nameProduct;
	private String articleNuber;
	private String description;
	private String unitStock;
	private float supplierPrice;
	private float salesPrice;
	private float weight;
	private int idCateg;
	private String image;
	private String comment;
	private String categoryName;
	private String inventoryName;

	public Product() {
	}

	public Product(int id, String nameProduct, String articleNuber,
			String description, String unitStock, float supplierPrice,
			float salesPrice, float weight, int idCateg, String image,
			String comment, String categoryName, String inventoryName) {
		this.id = id;
		this.nameProduct = nameProduct;
		this.articleNuber = articleNuber;
		this.description = description;
		this.unitStock = unitStock;
		this.supplierPrice = supplierPrice;
		this.salesPrice = salesPrice;
		this.weight = weight;
		this.idCateg = idCateg;
		this.image = image;
		this.comment = comment;
		this.categoryName = categoryName;
		this.inventoryName = inventoryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getArticleNuber() {
		return articleNuber;
	}

	public void setArticleNuber(String articleNuber) {
		this.articleNuber = articleNuber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitStock() {
		return unitStock;
	}

	public void setUnitStock(String unitStock) {
		this.unitStock = unitStock;
	}

	public float getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(float supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public float getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(float salesPrice) {
		this.salesPrice = salesPrice;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(int idCateg) {
		this.idCateg = idCateg;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public Object getAttributeValue(String attrValue) {
		switch (attrValue) {
		case "id":
			return getId();
		case "nameProduct":
			return getNameProduct();
		case "articleNumber":
			return getArticleNuber();
		case "description":
			return getDescription();
		case "unitStock":
			return getUnitStock();
		case "supplierPrice":
			return getSupplierPrice();
		case "salesPrice":
			return getSalesPrice();
		case "weight":
			return getWeight();
		case "id_categ":
			return getCategoryName();
		case "image":
			return getImage();
		case "comment":
			return getComment();
		case "name":
			return getNameProduct();
		case "inventoryName":
			return getInventoryName();
		default:
			return "Afara ploua!!";
		}
	}

}
