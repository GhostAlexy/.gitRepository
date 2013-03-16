/**
 * 
 */
package controler.date.management.inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import example.connection.to.database.JDBCConnection;

/**
 * @author GhostAlexy
 * 
 */
public class InventoryExtractor {
	private JDBCConnection connObject;
	private Connection conn;

	public InventoryExtractor() {
		connObject = JDBCConnection.getConnection();
		conn = connObject.getCon();
	}

	/**
	 * Executa un select din baza de date pentru a extrage toate inregistrarile
	 * existente in tabela Inventory
	 * 
	 * @return o lista cu toate elementele existente in Inventory
	 */
	public ArrayList<Inventory> getAllInventoryElements() {
		ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
		ResultSet resultQueryProd = null;
		String interog = "SELECT * FROM inventory";
		Statement s = null;
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(interog);
			while (resultQueryProd.next()) {
				Inventory inventoryObj = new Inventory();
				inventoryObj.setId(resultQueryProd.getInt("id"));
				inventoryObj.setInventoryName(resultQueryProd
						.getString("inventoryName"));
				inventoryObj.setInventoryLocation(resultQueryProd
						.getString("inventoryLocation"));
				inventoryObj.setStockCapacity(resultQueryProd
						.getInt("stockCapacity"));
				inventoryList.add(inventoryObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inventoryList;
	}

	/**
	 * Executa extragerea din baza de date a unui anumit inventory cautat
	 * 
	 * @param searchedId
	 *            id-ul pentru care se face cautarea in tabela
	 * @return o lista ce contine un obiect de tip inventory
	 */
	public ArrayList<Inventory> getOneInventory(String searchedId) {
		ArrayList<Inventory> oneInventoryDetails = new ArrayList<Inventory>();
		ResultSet resultQueryProd = null;
		Statement s = null;
		String interog = "SELECT * FROM inventory where id = " + searchedId;
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(interog);
			while (resultQueryProd.next()) {
				Inventory invent = new Inventory();
				invent.setId(resultQueryProd.getInt("id"));
				invent.setInventoryName(resultQueryProd
						.getString("inventoryName"));
				invent.setInventoryLocation(resultQueryProd
						.getString("inventoryLocation"));
				invent.setStockCapacity(resultQueryProd.getInt("stockCapacity"));
				oneInventoryDetails.add(invent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oneInventoryDetails;
	}
}
