/**
 * 
 */
package example.connection.to.database;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GhostAlexy
 * 
 */
@SuppressWarnings("serial")
public class DeleteInventory extends HttpServlet {

	DBInterog databaseInterog;

	public DeleteInventory() {
		databaseInterog = new DBInterog();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("delInventory") != null) {
			String selected[] = request.getParameterValues("id");
			if (selected != null && selected.length != 0) {
				for (int i = 0; i < selected.length; i++) {
					databaseInterog.deleteRow("inventory", "inventoryName",
							selected[i]);
				}
			}
			response.sendRedirect("ControlerListInventoryLocation.aspx");
		} else if (request.getParameter("addInventory") != null) {
			response.sendRedirect("ControlerInsertInventoryLocation.aspx");
		} else {
			response.sendRedirect("ControlerEditInventoryLocation.aspx?id="
					+ request.getParameter("id"));
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
