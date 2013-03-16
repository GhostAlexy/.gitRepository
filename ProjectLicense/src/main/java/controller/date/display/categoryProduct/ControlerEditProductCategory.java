package controller.date.display.categoryProduct;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Puscu George Alexandru
 * 
 */

public class ControlerEditProductCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListProductCategoryExtractor editCategProdExtr;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchedId = request.getParameter("id");
		editCategProdExtr = new ListProductCategoryExtractor();
		ArrayList<ProductCategory> prodCategList = editCategProdExtr
				.getOneProductCategoryElement(searchedId);
		request.setAttribute("prodCategEdit", prodCategList);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/EditProductsCategory.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
