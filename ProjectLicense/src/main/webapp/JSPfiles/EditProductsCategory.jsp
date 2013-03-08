<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="formProduct">
	<p class="formText">Editare Produse!!!</p>
	<form method="get" action="InsertCategoryProduct.aspx"
		name="updateProductCategory">
		<div>
			<c:forEach items="${prodCategEdit}" var="prodCateg">
				<input name="id" type="hidden" value="${prodCateg.id}" />
				<label>Category name:(*)</label>
				<input id="1" name="CN" class="textBoxProduct" type="text"
					value="${prodCateg.name}" />
				<br />
				<div id="11" class="err"></div>
				<label>Description:</label>
				<textarea cols="50" rows="10" name="description" id="txtDescr"
					class="textAreaDescr">${prodCateg.description}</textarea>
				<br />
				<div id="18" class="err"></div>
				<input name="updateCategProd" value="Update" class="insertProduct"
					type="submit" />
				<input name="cancelInsert" value="Cancel" class="cancelInsert"
					type="submit" />
			</c:forEach>
		</div>
	</form>
</div>
<%@ include file="footer.jsp"%>