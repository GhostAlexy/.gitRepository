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
@SuppressWarnings("serial")
public class ControlerListInventoryLocation extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> allFields = new ArrayList<String>();
		allFields.add("id");
		allFields.add("inventoryName");
		allFields.add("inventoryLocation");
		allFields.add("stockCapacity");
		InventoryExtractor inventExtr = new InventoryExtractor();
		ArrayList<Inventory> inventoryFields = inventExtr
				.getAllInventoryElements();
		request.setAttribute("inventory", inventoryFields);
		request.setAttribute("allFields", allFields);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/ListInventory.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	};
}
