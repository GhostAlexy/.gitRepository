package example.connection.to.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DBInterog {

	private JDBCConnection connObject;
	private Connection conn;

	public DBInterog() {
		connObject = JDBCConnection.getConnection();
		conn = connObject.getCon();
	}

	public StringBuffer getRow(String fieldName, String tableName, String id,
			String name) {
		StringBuffer buff = new StringBuffer();
		ResultSet resultQuery = null;
		Statement s = null;
		try {
			s = conn.createStatement();
			resultQuery = s.executeQuery("SELECT " + fieldName + " FROM "
					+ tableName + " where " + id + "='" + name + "'");
			while (resultQuery.next()) {
				buff.append(resultQuery.getString(fieldName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buff;
	}

	public void deleteRow(String tableName, String id, String name) {
		Statement s = null;
		int valDelete = 1;
		try {
			s = conn.createStatement();
			valDelete = s.executeUpdate("DELETE FROM " + tableName + " where "
					+ id + "='" + name + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (valDelete != 0) {
			System.out.println("Build Successfully");
		} else {
			System.out.println("Error to delete");
		}
	}

	/**
	 * Returneaza o lista ale carei elemente sunt numele campurilor dintr-o
	 * tabela
	 */
	public HashMap<String, String> getColumnNames(String tableName) {
		LinkedHashMap<String, String> allColumnsName = new LinkedHashMap<String, String>();
		ArrayList<String> nameFromDB = new ArrayList<String>();
		ArrayList<String> fictiveName = new ArrayList<String>();
		fictiveName.add("id");
		fictiveName.add("Product Name");
		fictiveName.add("Article Number");
		fictiveName.add("Description");
		fictiveName.add("Unit Stock");
		fictiveName.add("Supplier Price");
		fictiveName.add("Sales Price");
		fictiveName.add("Weight");
		fictiveName.add("Category");
		fictiveName.add("Image");
		fictiveName.add("Comment");
		Statement s = null;
		ResultSet rs = null;
		ResultSetMetaData rsMetaData = null;
		int numberOfColumns = 0;
		try {
			s = conn.createStatement();
			rs = s.executeQuery("SELECT * from " + tableName);
			rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();

			// get the column names; column indexes start from 1
			for (int i = 1; i < numberOfColumns + 1; i++) {
				nameFromDB.add(rsMetaData.getColumnName(i));
			}
			for (int i = 0; i < nameFromDB.size(); i++) {
				allColumnsName.put(nameFromDB.get(i), fictiveName.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allColumnsName;
	}

	public int getNumberColumn(String tableName) {
		Statement s = null;
		ResultSet resultQuery = null;
		int sizeNumber = 0;
		try {
			s = conn.createStatement();
			resultQuery = s.executeQuery("SELECT count(id) FROM " + tableName);
			resultQuery.next();
			sizeNumber = resultQuery.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sizeNumber;
	}

//	public static void main(String[] args) {
//		// DBInterog interog = new DBInterog();
//		// System.out.println(interog.getColumnNames("products")+"\n");
//		// System.out.println(interog.getColumnNames("productcategory"));
//		LinkedHashMap<String, String> predefinite = new LinkedHashMap<String, String>();
//		predefinite.put("0", "Nume");
//		predefinite.put("1", "Product Name");
//		predefinite.put("2", "Article Number");
//		predefinite.put("3", "Unit Stock");
//		predefinite.put("4", "Sales Price");
//		predefinite.put("5", "Description");
//		predefinite.put("6", "Category");
//		System.out.println(predefinite);
//	}

}
