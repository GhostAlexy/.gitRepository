package example.connection.to.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertCategoryProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private JDBCConnection connObject;
	private DBInterog databaseInterog;
	private Connection conn;

	public InsertCategoryProduct() {
		connObject = JDBCConnection.getConnection();
		conn = connObject.getCon();
		databaseInterog = new DBInterog();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PreparedStatement pstmt, updatestmt = null;
		String insertInterog = "Insert into productcategory(name, descriptionCateg) values(?,?)";
		String updateInterog = "Update productcategory set name = ?, descriptionCateg = ? where id = "
				+ request.getParameter("id");
		String categoryName = databaseInterog.getRow("name", "productcategory",
				"name", request.getParameter("CN")).toString();
		if (request.getParameter("insertCategProd") != null) {
			try {
				if (request.getParameter("CN") == null) {
					System.out.println("Numele nu poate sa lipseasca!!!");
				} else if (request.getParameter("CN").equals(categoryName)) {
					System.out
							.println("Categoria de produse exista deja in baza de date!!!");
					response.sendRedirect("ControlerInsertProductCategory.aspx");
				} else {
					pstmt = conn.prepareStatement(insertInterog);
					pstmt.setString(1, request.getParameter("CN"));
					pstmt.setString(2, request.getParameter("description"));
					pstmt.executeUpdate();
					response.sendRedirect("ControlerListProductCategory.aspx");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("cancelInsert") != null) {
			response.sendRedirect("ControlerListProductCategory.aspx");
		}
		if (request.getParameter("updateCategProd") != null) {
			try {
				updatestmt = conn.prepareStatement(updateInterog);
				updatestmt.setString(1, request.getParameter("CN"));
				updatestmt.setString(2, request.getParameter("description"));
				updatestmt.executeUpdate();
				response.sendRedirect("ControlerListProductCategory.aspx");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
