<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="formProduct">
	<p class="formText">Edit details for Inventory:</p>
	<form method="get" action="InsertInventory.aspx" name="insertInventory">
		<c:forEach items="${inventoryEdit}" var="inventory">
			<input name="id" type="hidden" value="${inventory.id}" />
			<label>Inventory name:(*)</label>
			<input id="1" name="IN" class="textBoxProduct" type="text"
				value="${inventory.inventoryName}" />
			<br />
			<div id="11" class="err"></div>
			<label>Inventory location:(*)</label>
			<input id="2" name="IL" class="textBoxProduct" type="text"
				value="${inventory.inventoryLocation}" />
			<br />
			<div id="12" class="err"></div>
			<label>Stock capacity:(*)</label>
			<input id="2" name="stockCapacity" class="textBoxProduct" type="text"
				value="${inventory.stockCapacity}" />
			<br />
			<div id="13" class="err"></div>
			<input name="updateInventory" value="Update" class="insertProduct"
				type="submit" />
			<input name="cancelInsert" value="Cancel" class="cancelInsert"
				type="submit" />
		</c:forEach>
	</form>
</div>
<%@ include file="footer.jsp"%>