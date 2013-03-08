package controller.date.display.products;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.date.display.categoryProduct.ListProductCategoryExtractor;
import controller.date.display.categoryProduct.ProductCategory;

public class ControlerEditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListProductExtractor editProdExtr;
	private ListProductCategoryExtractor editCategProdExtr;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchedId = request.getParameter("id");
		editProdExtr = new ListProductExtractor();
		editCategProdExtr = new ListProductCategoryExtractor();
		ArrayList<Product> prodList = editProdExtr
				.getOneProductElement(searchedId);
		ArrayList<ProductCategory> prodCategList = editCategProdExtr
				.getAllProductsCategoryElements();
		request.setAttribute("prodCategEdit", prodCategList);
		request.setAttribute("productEdit", prodList);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/EditProducts.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}