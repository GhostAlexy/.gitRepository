/**
 * 
 */
package example.connection.to.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GhostAlexy
 * 
 */
@SuppressWarnings("serial")
public class InsertInventory extends HttpServlet {

	private JDBCConnection conn = JDBCConnection.getConnection();
	private Connection con;
	private DBInterog databaseInterog;

	public InsertInventory() {
		con = conn.getCon();
		databaseInterog = new DBInterog();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PreparedStatement pstmt = null;
		String insertInterog = "Insert into inventory(inventoryName,inventoryLocation,stockCapacity) values(?,?,?)";
		String updateInterog = "Update inventory set inventoryName = ?, inventoryLocation = ?, stockCapacity= ? where id = "
				+ request.getParameter("id");
		/**
		 * Se retine in inventoryName ceea ce se afla in baza de date in fieldul
		 * cu numele inventoryName
		 */
		String inventoryName = databaseInterog.getRow("inventoryName",
				"inventory", "inventoryName", request.getParameter("IN"))
				.toString();
		/**
		 * Se retine in inventoryLocation ceea ce se afla in baza de date la
		 * fieldul cu numele inventoryLocation
		 */
		String inventoryLocation = databaseInterog.getRow("inventoryLocation",
				"inventory", "inventoryLocation", request.getParameter("IL"))
				.toString();
		if (request.getParameter("insertInventory") != null) {
			try {
				if (request.getParameter("IN") == null
						&& request.getParameter("IL") == null
						|| inventoryName.equals(request.getParameter("IN"))
						|| inventoryLocation.equals(request.getParameter("IL"))) {
					System.out
							.println("Numele sau adresa exista deja in baza de date!!");
					response.sendRedirect("ControlerInsertInventoryLocation.aspx");
				} else {
					pstmt = con.prepareStatement(insertInterog);
					pstmt.setString(1, request.getParameter("IN"));
					pstmt.setString(2, request.getParameter("IL"));
					pstmt.setInt(3, Integer.parseInt(request
							.getParameter("stockCapacity")));
					pstmt.executeUpdate();
					pstmt.close();
					response.sendRedirect("ControlerListInventoryLocation.aspx");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("cancelInsert") != null) {
			response.sendRedirect("ControlerListInventoryLocation.aspx");
		}
		if (request.getParameter("updateInventory") != null) {
			try {
				pstmt = con.prepareStatement(updateInterog);
				pstmt.setString(1, request.getParameter("IN"));
				pstmt.setString(2, request.getParameter("IL"));
				pstmt.setInt(3,
						Integer.parseInt(request.getParameter("stockCapacity")));
				pstmt.executeUpdate();
				pstmt.close();
				response.sendRedirect("ControlerListInventoryLocation.aspx");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
