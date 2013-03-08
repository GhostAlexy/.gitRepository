package controller.date.display.categoryProduct;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlerListProductCategory extends HttpServlet {
	String fieldName = null;
	String asccending = null;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> allFields = new ArrayList<String>();
		allFields.add("id");
		allFields.add("name");
		allFields.add("descriptionCateg");
		if (request.getParameter("fieldName") == null) {
			fieldName = "name";
		} else {
			fieldName = request.getParameter("fieldName");
		}
		if (request.getParameter("sorting") == null) {
			asccending = "";
		} else {
			asccending = request.getParameter("sorting");
		}
		int page = 1;
		int recordsPerPage = 5;
		ListProductCategoryExtractor categExtr = new ListProductCategoryExtractor();
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<ProductCategory> prodCategList = categExtr
				.getProductsCategoryGrouped((page - 1) * recordsPerPage,
						recordsPerPage, fieldName, asccending);
		int noOfRecords = categExtr.getNoOfRecords();
		/** Numarul total de pagini */
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		/**
		 * Pagina de start si anume pagina de la care se porneste paginarea.
		 * Daca pagina de la care pornesti-2 este mai mare decat 0 inseamna ca
		 * mai exista in partea stanga pagini si deci se afiseaza urmatoarele 2
		 * pagini
		 */
		int startPage = page - 2 > 0 ? page - 2 : 1;
		/**
		 * Daca pagina de sfarsit este mai mica decat numaru total de pagini de
		 * pot adauga 2 pagini in dreapta altfel paginarea (numaru de pagini)
		 * ramane neschimbat
		 */
		int endPage = startPage + 4 < noOfPages ? startPage + 4 : noOfPages;
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("productsCategory", prodCategList);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		request.setAttribute("asccending", asccending);
		request.setAttribute("sort", fieldName);
		request.setAttribute("allFields", allFields);
		RequestDispatcher view = request
				.getRequestDispatcher("/JSPfiles/ListProductsCategory.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
