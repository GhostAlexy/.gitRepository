<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>


<div class="formProduct">
	<p class="formText">Editare produse!!:</p>
	<form method="get" action="InsertProduct.aspx" name="insertProduct">
		<div>
			<c:forEach items="${productEdit}" var="prod">
				<input name="id" hidden="true" value="${prod.id}" />
				<label>Product name:(*)</label>
				<input id="1" name="PN" value="<c:out value="${prod.nameProduct}"/>"
					class="textBoxProduct" type="text" />
				<br />
				<div id="11" class="err"></div>
				<label>European Article Number:(*)</label>
				<input id="2" name="EAN"
					value="<c:out value="${prod.articleNuber}" />"
					class="textBoxProduct" type="text" />
				<br />
				<div id="12" class="err"></div>
				<label>Description:</label>
				<textarea cols="50" rows="10" name="description" id="txtDescr"
					class="textAreaDescr">${prod.description}"</textarea>
				<br />
				<div id="20" class="err"></div>
				<label>Unit stock:</label>
				<input id="4" name="unitStock"
					value="<c:out value="${prod.unitStock}" />" class="textBoxProduct"
					type="text" />
				<br />
				<div id="13" class="err"></div>
				<label>Supplier Price:</label>
				<input id="5" name="buyPrice"
					value="<c:out value="${prod.supplierPrice}" />"
					class="textBoxProduct" type="text" />
				<br />
				<div id="14" class="err"></div>
				<label>Sales Price:</label>
				<input id="6" name="salesPrice"
					value="<c:out value="${prod.salesPrice}" />" class="textBoxProduct"
					type="text" />
				<br />
				<div id="15" class="err"></div>
				<label>Inventory:(*)</label>
				<div class="styled-select">
					<select name="inventory" class="textBoxProduct" id="20"
						style="width: 230px; height: 40px;">
						<c:forEach items="${inventoryEdit}" var="invent">
							<option
								<c:if test="${prod.inventoryName == invent.inventoryName}"> selected="selected" </c:if>>
								<c:out value="${invent.inventoryName}" />
							</option>
						</c:forEach>
					</select>
				</div>
				<div id="21" class="err"></div>
				<label>Weight:</label>
				<input id="7" name="weight" value="<c:out value="${prod.weight}" />"
					class="textBoxProduct" type="text" />
				<br />
				<div id="16" class="err"></div>
				<label>Product Category:(*)</label>
				<div class="styled-select">
					<select name="category" class="textBoxProduct" id="8"
						style="width: 230px; height: 40px;">
						<c:forEach items="${prodCategEdit}" var="prodCateg">
							<option
								<c:if test="${prod.categoryName == prodCateg.name}"> selected="selected" </c:if>>
								<c:out value="${prodCateg.name}" />
							</option>
						</c:forEach>
					</select>
				</div>
				<br />
				<div id="17" class="err"></div>
				<label>Image:</label>
				<input id="9" name="image" value="<c:out value="${prod.image}" />"
					class="textBoxProduct" type="text" />
				<br />
				<div id="18" class="err"></div>
				<label>Comment:</label>
				<textarea cols="50" rows="10" name="comment" id="txtDescr"
					class="textAreaDescr">${prod.comment}"</textarea>
				<br />
				<input name="id_product"
					value="<c:out value="${prod.categoryName}" />" type="hidden" />
				<div id="19" class="err"></div>
				<input name="updateProd" value="Update" class="insertProduct"
					type="submit" />
				<input name="cancelInsert" value="Cancel" class="cancelInsert"
					type="submit" />
			</c:forEach>
		</div>
	</form>
</div>
<%@ include file="footer.jsp"%>