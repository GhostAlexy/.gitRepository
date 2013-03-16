
package controller.date.display.categoryProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import example.connection.to.database.JDBCConnection;

public class ListProductCategoryExtractor {

	private JDBCConnection connObject;
	private Connection conn;
	private int noOfRecords;
	private String query;

	public ListProductCategoryExtractor() {
		connObject = JDBCConnection.getConnection();
		conn = connObject.getCon();
	}

	public ArrayList<ProductCategory> getAllProductsCategoryElements() {
		ArrayList<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		ResultSet resultQueryProd = null;
		String interog = "SELECT * FROM productCategory";
		Statement s = null;
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(interog);
			while (resultQueryProd.next()) {
				ProductCategory prodCat = new ProductCategory();

				prodCat.setId(resultQueryProd.getInt("id"));
				prodCat.setName(resultQueryProd.getString("name"));
				prodCat.setDescription(resultQueryProd
						.getString("descriptionCateg"));
				productCategoryList.add(prodCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productCategoryList;
	}

	public ArrayList<ProductCategory> getProductsCategoryGrouped(int offset,
			int noOfRecords, String fieldName, String asccending) {
		ArrayList<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		ResultSet resultQueryProd = null;
		Statement s = null;
		if (asccending == "") {
			query = "SELECT SQL_CALC_FOUND_ROWS * FROM productCategory order by "
					+ fieldName + " limit " + offset + ", " + noOfRecords;
		} else {
			query = "SELECT SQL_CALC_FOUND_ROWS * FROM productCategory order by "
					+ fieldName
					+ " "
					+ asccending
					+ " limit "
					+ offset
					+ ", "
					+ noOfRecords;
		}
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(query);
			while (resultQueryProd.next()) {
				ProductCategory prodCat = new ProductCategory();
				prodCat.setId(resultQueryProd.getInt("id"));
				prodCat.setName(resultQueryProd.getString("name"));
				prodCat.setDescription(resultQueryProd
						.getString("descriptionCateg"));
				productCategoryList.add(prodCat);
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
		return productCategoryList;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public ArrayList<ProductCategory> getOneProductCategoryElement(
			String searchedId) {
		ArrayList<ProductCategory> savedList = new ArrayList<ProductCategory>();
		ResultSet resultQueryProd = null;
		Statement s = null;
		String interog = "SELECT * FROM productcategory where id = "
				+ searchedId;
		try {
			s = conn.createStatement();
			resultQueryProd = s.executeQuery(interog);
			while (resultQueryProd.next()) {
				ProductCategory prodCat = new ProductCategory();

				prodCat.setId(resultQueryProd.getInt("id"));
				prodCat.setName(resultQueryProd.getString("name"));
				prodCat.setDescription(resultQueryProd
						.getString("descriptionCateg"));
				savedList.add(prodCat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return savedList;
	}
}
