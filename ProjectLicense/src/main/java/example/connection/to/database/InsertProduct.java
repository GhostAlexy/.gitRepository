package example.connection.to.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.use.project.FunctionToUse;

public class InsertProduct extends HttpServlet {
	private JDBCConnection conn = JDBCConnection.getConnection();
	private Connection con;
	private FunctionToUse func;
	private DBInterog databaseInterog;
	private int idInventoryUsed;

	public InsertProduct() {
		con = conn.getCon();
		func = new FunctionToUse();
		databaseInterog = new DBInterog();
	}

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PreparedStatement pstmt = null;

		String insertInterog = "Insert into products(nameProduct,articleNumber,description,unitStock,supplierPrice,salesPrice,weight,id_categ,image,comment) values(?,?,?,?,?,?,?,?,?,?)";
		String updateInterog = "Update products set nameProduct = ?, articleNumber = ?, description = ?, unitStock = ?, supplierPrice = ?, salesPrice = ?, weight = ?, id_categ = ?, image = ?, comment = ? where id = "
				+ request.getParameter("id");

		int idNumber = Integer.parseInt(databaseInterog.getRow("id",
				"productcategory", "name", request.getParameter("category"))
				.toString());

		String name = databaseInterog.getRow("nameProduct", "products",
				"nameProduct", request.getParameter("PN")).toString();

		String articleNumber = databaseInterog.getRow("articleNumber",
				"products", "articleNumber", request.getParameter("EAN"))
				.toString();

		if (request.getParameter("insertProd") != null) {
			try {

				if (request.getParameter("PN") == null
						&& name.equals(request.getParameter("PN"))
						|| articleNumber.equals(request.getParameter("EAN"))) {
					System.out
							.println("Numele sau codul de bare exista deja in baza de date!!!");
					response.sendRedirect("ControlerInsertProduct.aspx");
				} else {
					// insert date from formular into Database
					pstmt = con.prepareStatement(insertInterog);
					pstmt.setString(1, request.getParameter("PN"));
					pstmt.setString(2, request.getParameter("EAN"));
					pstmt.setString(3, request.getParameter("description"));
					pstmt.setString(4, request.getParameter("unitStock"));
					func.addOnlyNumber(request, pstmt, "buyPrice", 5);
					func.addOnlyNumber(request, pstmt, "salesPrice", 6);
					func.addOnlyNumber(request, pstmt, "weight", 7);
					pstmt.setInt(8, idNumber);
					pstmt.setString(9, request.getParameter("image"));
					pstmt.setString(10, request.getParameter("comment"));
					pstmt.executeUpdate();
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/**
			 * Retin id-ul ultimei inregistrari adaugate
			 */
			int idLastInsert = Integer.parseInt(databaseInterog.getRow("id",
					"products", "nameProduct", request.getParameter("PN"))
					.toString());
			/**
			 * Retin id-ul inventoriului in care a fost adaugat produsul
			 */
			idInventoryUsed = Integer.parseInt(databaseInterog.getRow("id",
					"inventory", "inventoryName",
					request.getParameter("inventory")).toString());

			String insertLinkTable = "Insert into products_inventory(id_product,id_inventory)values(?,?)";
			try {
				pstmt = con.prepareStatement(insertLinkTable);
				pstmt.setInt(1, idLastInsert);
				pstmt.setInt(2, idInventoryUsed);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Sql sintax error: " + e);
			}
			response.sendRedirect("ControlerListProduct.aspx");
		}

		if (request.getParameter("cancelInsert") != null) {
			response.sendRedirect("ControlerListProduct.aspx");
		}
		if (request.getParameter("updateProd") != null) {
			try {
				pstmt = con.prepareStatement(updateInterog);
				pstmt.setString(1, request.getParameter("PN"));
				pstmt.setString(2, request.getParameter("EAN"));
				pstmt.setString(3, request.getParameter("description"));
				pstmt.setString(4, request.getParameter("unitStock"));
				func.addOnlyNumber(request, pstmt, "buyPrice", 5);
				func.addOnlyNumber(request, pstmt, "salesPrice", 6);
				func.addOnlyNumber(request, pstmt, "weight", 7);
				pstmt.setInt(8, idNumber);
				pstmt.setString(9, request.getParameter("image"));
				pstmt.setString(10, request.getParameter("comment"));
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			idInventoryUsed = Integer.parseInt(databaseInterog.getRow("id",
					"inventory", "inventoryName",
					request.getParameter("inventory")).toString());
			String updateLinkTable = "Update products_inventory set id_inventory= ? where id_product="
					+ request.getParameter("id");
			try {
				pstmt = con.prepareStatement(updateLinkTable);
				pstmt.setInt(1, idInventoryUsed);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect("ControlerListProduct.aspx");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
