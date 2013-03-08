<%@ include file="header.jsp"%>
<div class="formProduct">
	<p class="formText">Pentru a introduce o noua categorie de produse
		va rugam sa completati campurile urmatoare:</p>
	<form method="get" action="InsertCategoryProduct.aspx"
		name="insertProduct">
		<div>
			<label>Category name:(*)</label> <input id="1" name="CN"
				class="textBoxProduct" type="text" /><br />
			<div id="11" class="err"></div>
			<label>Description:</label>
			<textarea cols="50" rows="10" name="description" id="txtDescr"
				class="textAreaDescr"></textarea>
			<br />
			<div id="18" class="err"></div>
			<input name="insertCategProd" value="Insert" class="insertProduct"
				type="submit" /> <input name="cancelInsert" value="Cancel"
				class="cancelInsert" type="submit" />
		</div>
	</form>
</div>
<%@ include file="footer.jsp"%>