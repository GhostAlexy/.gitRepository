<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>

<div class="listProd">
	<div class="noProd">Details!!!!</div>
	<form method="get" action="DeleteProduct.aspx">
		<input name="addProd" value="Add" class="insertProduct" type="submit" />
		<input name="delProd" value="Delete " class="cancelInsert"
			type="submit" />
		<c:if test="${!empty products}">
			<div class="container--list">
				<%@ include file="ProductListAjax.jsp"%>
			</div>
		</c:if>
		<c:if test="${empty products}">
			<c:out value="No products in stock!!!" />
		</c:if>
	</form>
	<%@ include file="PaginationProducts.jsp"%>
	<div class="choseColumns">
		<input type="submit" id="showr"
			onclick="showHideDiv('showr','chooseColumnDiv');"
			value="Choose Columns" />
		<%@ include file="ChangeColumn.jsp"%>
	</div>
</div>
<%@ include file="footer.jsp"%>