package function.use.project;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class FunctionToUse {

	public FunctionToUse() {
	}

	public boolean isNumber(String number) {
		if (number.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
			return true;
		} else {
			return false;
		}
	}

	public void addOnlyNumber(HttpServletRequest request,
			PreparedStatement pstmt, String name, int parameterIndex) {
		try {
			if (isNumber(request.getParameter(name))) {
				pstmt.setFloat(parameterIndex,
						Float.parseFloat(request.getParameter(name)));
			} else {
				pstmt.setFloat(parameterIndex, 0);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String implodeArray(ArrayList<?> inputArray, String glueString) {

		/** Output variable */
		String output = "";

		if (inputArray.size() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(inputArray.get(0));

			for (int i = 1; i < inputArray.size() - 1; i++) {
				sb.append(glueString);
				sb.append(inputArray.get(i));
			}
			sb.append(glueString);
			sb.append(inputArray.get(inputArray.size() - 1));

			output = sb.toString();
		}

		return output;
	}

	public String replaceString(String word) {
		switch (word) {
		case "id":
			return "id";
		case "nameProduct":
			return "Product Name";
		case "articleNumber":
			return "Article Number";
		case "description":
			return "Description";
		case "unitStock":
			return "Unit Stock";
		case "supplierPrice":
			return "Supplier Price";
		case "salesPrice":
			return "Sales Price";
		case "weight":
			return "Weight";
		case "id_categ":
			return "Category";
		case "image":
			return "Image";
		case "comment":
			return "Comment";
		default:
			return "nothing";
		}
	}
}