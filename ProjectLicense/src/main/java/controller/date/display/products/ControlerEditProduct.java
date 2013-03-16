package controller.date.display.products;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.date.management.inventory.Inventory;
import controler.date.management.inventory.InventoryExtractor;
import controller.date.display.categoryProduct.ListProductCategoryExtractor;
import controller.date.display.categoryProduct.ProductCategory;

public class ControlerEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListProductExtractor editProdExtr;
	private ListProductCategoryExtractor editCategProdExtr;
	private InventoryExtractor editInventoryExtr;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchedId = request.getParameter("id");
		editProdExtr = new ListProductExtractor();
		editCategProdExtr = new ListProductCategoryExtractor();
		editInventoryExtr = new InventoryExtractor();
		ArrayList<Product> prodList = editProdExtr
				.getOneProductElement(searchedId);
		ArrayList<ProductCategory> prodCategList = editCategProdExtr
				.getAllProductsCategoryElements();
		ArrayList<Inventory> inventoryList = editInventoryExtr
				.getAllInventoryElements();
		System.out.println("Lista de categorii este: " + prodCategList);
		System.out.println("Lista de inventory este: " + inventoryList);
		request.setAttribute("prodCategEdit", prodCategList);
		request.setAttribute("productEdit", prodList);
		request.setAttribute("inventoryEdit", inventoryList);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/EditProducts.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}