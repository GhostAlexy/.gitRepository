package example.connection.to.database;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCategoryProduct extends HttpServlet {

	DBInterog databaseInterog;

	public DeleteCategoryProduct() {
		databaseInterog = new DBInterog();
	}

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("delCateg") != null) {
			String selected[] = request.getParameterValues("id");
			if (selected != null && selected.length != 0) {
				for (int i = 0; i < selected.length; i++) {
					databaseInterog.deleteRow("productcategory", "name", selected[i]);
				}
			}
			response.sendRedirect("ControlerListProductCategory.aspx");
		} else if (request.getParameter("addCateg") != null) {
			response.sendRedirect("ControlerInsertProductCategory.aspx");
		}else{
			response.sendRedirect("ControlerEditProductCategory.aspx?id="
					+ request.getParameter("id"));
		}

	}

	public void doPos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
