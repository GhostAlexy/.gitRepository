<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="formProduct">
	<p class="formText">Pentru a defini un nou Inventory trebuie
		completate campurile de mai jos:</p>
	<form method="get" action="InsertInventory.aspx" name="insertInventory">
		<label>Inventory name:(*)</label> <input id="1" name="IN"
			class="textBoxProduct" type="text" /><br />
		<div id="11" class="err"></div>
		<label>Inventory location:(*)</label> <input id="2" name="IL"
			class="textBoxProduct" type="text" /><br />
		<div id="12" class="err"></div>
		<label>Stock capacity:(*)</label> <input id="2" name="stocCapacity"
			class="textBoxProduct" type="text" /><br />
		<div id="13" class="err"></div>
		<input name="insertInventory" value="Insert" class="insertProduct"
			type="submit" /> <input name="cancelInsert" value="Cancel"
			class="cancelInsert" type="submit" />
	</form>
</div>
<%@ include file="footer.jsp"%>