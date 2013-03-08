package controller.date.display.products;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import example.connection.to.database.DBInterog;
import function.use.project.FunctionToUse;

public class ControlerListProduct extends HttpServlet {

	private String fieldName = null;
	private String asccending = null;
	private LinkedHashMap<String, String> allFields;
	private LinkedHashMap<String, String> selected;
	private LinkedHashMap<String, String> predefinite;
	private static final long serialVersionUID = 1L;
	private ListProductExtractor exctr;
	private DBInterog interog;
	private FunctionToUse func;

	public void init() {
		exctr = new ListProductExtractor();
		interog = new DBInterog();
		func = new FunctionToUse();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		predefinite = new LinkedHashMap<String, String>();
		predefinite.put("id", "id");
		predefinite.put("nameProduct", "Product Name");
		predefinite.put("articleNumber", "Article Number");
		predefinite.put("unitStock", "Unit Stock");
		predefinite.put("salesPrice", "Sales Price");
		predefinite.put("description", "Description");
		predefinite.put("id_categ", "Category");
//		System.out.println(predefinite);
		allFields = new LinkedHashMap<String, String>();
		allFields.putAll(interog.getColumnNames("products"));
		selected = new LinkedHashMap<String, String>();

		if (session.getAttribute("selectedFields") != null) {
			selected = (LinkedHashMap<String, String>) session
					.getAttribute("selectedFields");
		} else {
			selected.putAll(predefinite);
		}

		if (request.getParameter("who") != null
				&& request.getParameter("status").equals("show")) {
			selected.put(request.getParameter("who"),
					func.replaceString(request.getParameter("who")));
		} else if (request.getParameter("who") != null
				&& request.getParameter("status").equals("hide")) {
			selected.remove(request.getParameter("who"));
		}
		if (request.getParameter("fieldName") == null) {
			fieldName = "nameProduct";
		} else {
			fieldName = request.getParameter("fieldName");
		}

		/**
		 * Verificarea tipului de sortare. In functie de parametrul returnat se
		 * seteaza valoarea lui asccending
		 */
		if (request.getParameter("sorting") == null) {
			asccending = "";
		} else {
			asccending = request.getParameter("sorting");
		}

		int page = 1;
		int recordsPerPage = 4;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		/**
		 * Lista de elemente de tip produs pentru afisare in grid
		 */
		ArrayList<Product> listProducts = exctr.getProductsGrouped((page - 1)
				* recordsPerPage, recordsPerPage, fieldName, selected,
				asccending);
		int noOfRecords = exctr.getNoOfRecords();

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

		/**
		 * Verific daca daca sesiunea este setata si setez atributul in cazul in
		 * care nu este setata
		 * 
		 */
		if (session.getAttribute("selectedFields") == null) {
			session.setAttribute("selectedFields", selected);
		}
		// Lista de campuri pentru tabel afisate pentru inceput
		request.setAttribute("predefinite", predefinite);
		// Toate campurile tabelei existente in DB
		request.setAttribute("allFields", allFields);
		// Numele campului dupa care se face sortarea
		request.setAttribute("sort", fieldName);
		// Pagina de la care se incepe paginarea
		request.setAttribute("startPage", startPage);
		// Numarul paginii la care se opreste paginarea
		request.setAttribute("endPage", endPage);
		// Obiect de tip Products pentru accesare atribute/metode pentru afisare
		// produselor
		request.setAttribute("products", listProducts);
		// Numarul total de pagini existente pentru paginare
		request.setAttribute("noOfPages", noOfPages);
		// Numarul paginii curente
		request.setAttribute("currentPage", page);
		// Tipul sortarii:ascendent/descendent
		request.setAttribute("asccending", asccending);

		/**
		 * In functie de parametrul trimis din Jquery controller-ul va
		 * directiona afisarea fie catre intreaga lista de produse fie doar
		 * pentru tabelul existent
		 */
		if (request.getParameter("accept") == null) {
			RequestDispatcher view = request
					.getRequestDispatcher("/JSPfiles/ListProducts.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request
					.getRequestDispatcher("/JSPfiles/ProductListAjax.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
