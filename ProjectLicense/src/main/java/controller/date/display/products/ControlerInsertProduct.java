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

public class ControlerInsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ListProductCategoryExtractor categExtr = new ListProductCategoryExtractor();
		ArrayList<ProductCategory> prodCategList = categExtr
				.getAllProductsCategoryElements();
		request.setAttribute("productsCategory", prodCategList);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/InsertProducts.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
