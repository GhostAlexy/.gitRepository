/**
 * 
 */
package controler.date.management.inventory;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GhostAlexy
 * 
 */
public class ControlerEditInventoryLocation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InventoryExtractor editInventoryExtr;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchedId = request.getParameter("id");
		editInventoryExtr = new InventoryExtractor();
		ArrayList<Inventory> inventoryList = editInventoryExtr
				.getOneInventory(searchedId);
		request.setAttribute("inventoryEdit", inventoryList);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/EditInventory.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
