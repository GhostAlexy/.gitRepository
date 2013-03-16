/**
 * 
 */
package controler.date.management.inventory;

/**
 * @author GhostAlexy
 * 
 */
public class Inventory {

	private int id;
	private String inventoryName;
	private String inventoryLocation;
	private int stockCapacity;

	/**
	 * 
	 */
	public Inventory() {

	}

	public Inventory(int id, String inventoryName, String inventoryLocation,
			int stockCapacity) {
		this.id = id;
		this.inventoryName = inventoryName;
		this.stockCapacity = stockCapacity;
		this.inventoryLocation = inventoryLocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(String inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}

	public int getStockCapacity() {
		return stockCapacity;
	}

	public void setStockCapacity(int stockCapacity) {
		this.stockCapacity = stockCapacity;
	}

}
