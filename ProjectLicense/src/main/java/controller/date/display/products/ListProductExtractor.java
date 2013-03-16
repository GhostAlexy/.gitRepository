package controller.date.display.products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import example.connection.to.database.DBInterog;
import example.connection.to.database.JDBCConnection;
import function.use.project.FunctionToUse;

public class ListProductExtractor {

	private JDBCConnection connObject;
	private DBInterog interog;
	private Connection conn;
	public static FunctionToUse func;
	private int noOfRecords;
	private String query;

	public ListProductExtractor() {
		connObject = JDBCConnection.getConnection();
		interog = new DBInterog();
		func = new FunctionToUse();
		conn = connObject.getCon();
	}

	public ArrayList<Product> getProductsGrouped(int offset, int noOfRecords,
			String fieldName, LinkedHashMap<String, String> selectMapFields,
			String asccending) {
		ArrayList<String> selectedFields = new ArrayList<String>(
				selectMapFields.keySet());
		ArrayList<Product> savedList = new ArrayList<Product>();
		ResultSet resultQueryProd = null;
		Statement s = null;
		String selectField = func.implodeArray(selectedFields, ",");
		if (asccending == null) {
			query = "Select SQL_CALC_FOUND_ROWS p."
					+ selectField
					+ ", pc.name"
					+ " from products p, productCategory pc where p.id_categ = pc.id order by "
					+ fieldName + " limit " + offset + ", " + noOfRecords;
		} else {
			query = "Select SQL_CALC_FOUND_ROWS p."
					+ selectField
					+ ", pc.name"
					+ " from products p, productCategory pc where p.id_categ = pc.id order by "
					+ fieldName + " " + asccending + " limit " + offset + ", "
					+ noOfRecords;
		}
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(query);
			while (resultQueryProd.next()) {
				Product product = new Product();
				for (int i = 0; i < selectedFields.size(); i++) {
					String name = selectedFields.get(i);
					switch (name) {
					case "id":
						product.setId(resultQueryProd.getInt("id"));
						break;
					case "nameProduct":
						product.setNameProduct(resultQueryProd
								.getString("nameProduct"));
						break;
					case "articleNumber":
						product.setArticleNuber(resultQueryProd
								.getString("articleNumber"));
						break;
					case "description":
						product.setDescription(resultQueryProd
								.getString("description"));
						break;
					case "unitStock":
						product.setUnitStock(resultQueryProd
								.getString("unitStock"));
						break;
					case "supplierPrice":
						product.setSupplierPrice(resultQueryProd
								.getFloat("supplierPrice"));
						break;
					case "salesPrice":
						product.setSalesPrice(resultQueryProd
								.getFloat("salesPrice"));
						break;
					case "weight":
						product.setWeight(resultQueryProd.getInt("weight"));
						break;
					case "id_categ":
						product.setCategoryName(resultQueryProd
								.getString("name"));
						break;
					case "image":
						product.setImage(resultQueryProd.getString("image"));
						break;
					case "comment":
						product.setComment(resultQueryProd.getString("comment"));
						break;
					case "name":
						product.setCategoryName(resultQueryProd
								.getString("name"));
						break;
					default:
						break;
					}
				}
				savedList.add(product);
			}
			resultQueryProd.close();

			resultQueryProd = s.executeQuery("SELECT FOUND_ROWS()");
			if (resultQueryProd.next())
				this.noOfRecords = resultQueryProd.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null)
					s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return savedList;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public ArrayList<Product> getOneProductElement(String searchedId) {
		ArrayList<Product> savedList = new ArrayList<Product>();
		ResultSet resultQueryProd = null;
		Statement s = null;
		String idCategory = interog.getRow("id_categ", "products", "id",
				searchedId).toString();
		String nameCategory = interog.getRow("name", "productcategory", "id",
				idCategory).toString();
		
		String idInventory = interog.getRow("id_inventory",
				"products_inventory", "id_product", searchedId).toString();
		String nameInventory = interog.getRow("inventoryName", "inventory",
				"id", idInventory).toString();
		String interog = "SELECT * FROM products where id = " + searchedId;
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(interog);
			while (resultQueryProd.next()) {
				savedList.add(new Product(resultQueryProd.getInt("id"),
						resultQueryProd.getString("nameProduct"),
						resultQueryProd.getString("articleNumber"),
						resultQueryProd.getString("description"),
						resultQueryProd.getString("unitStock"), resultQueryProd
								.getFloat("SupplierPrice"), resultQueryProd
								.getFloat("salesPrice"), resultQueryProd
								.getInt("weight"), resultQueryProd
								.getInt("id_categ"), resultQueryProd
								.getString("image"), resultQueryProd
								.getString("comment"), nameCategory,
						nameInventory));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return savedList;
	}
	// public static void main(String[] args) {
	// ListProductExtractor prod = new ListProductExtractor();
	// HashMap<String, String> predefinite = new HashMap<String, String>();
	// predefinite.put("id", "id");
	// predefinite.put("nameProduct", "Product Name");
	// predefinite.put("articleNumber", "Article Number");
	// predefinite.put("unitStock", "Unit Stock");
	// predefinite.put("salesPrice", "Sales Price");
	// predefinite.put("description", "Description");
	// ArrayList<Product> released = prod.getProductsGrouped(5, 4,
	// "nameProduct", predefinite, "ASC");
	// }
}
