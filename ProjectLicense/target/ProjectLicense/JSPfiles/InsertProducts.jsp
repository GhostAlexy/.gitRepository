<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<div class="formProduct">
	<p class="formText">Pentru a introduce un produs in WareHouse va
		rugam sa completati campurile urmatoare:</p>
	<form method="get" action="InsertProduct.aspx" name="insertProduct">
		<div>
			<label>Product name:(*)</label> <input id="1" name="PN"
				class="textBoxProduct" type="text" /><br />
			<div id="11" class="err"></div>
			<label>European Article Number:(*)</label> <input id="2" name="EAN"
				class="textBoxProduct" type="text" /><br />
			<div id="12" class="err"></div>
			<label>Description:</label>
			<textarea cols="50" rows="10" name="description" id="txtDescr"
				class="textAreaDescr"></textarea>
			<br /> 
			<div id="20" class="err"></div>
			<label>Unit stock:</label> <input id="4" name="unitStock"
				class="textBoxProduct" type="text" /><br />
			<div id="13" class="err"></div>
			<label>Supplier Price:</label> <input id="5" name="buyPrice"
				class="textBoxProduct" type="text" /><br />
			<div id="14" class="err"></div>
			<label>Sales Price:</label> <input id="6" name="salesPrice"
				class="textBoxProduct" type="text" /><br />
			<div id="15" class="err"></div>
			<label>Weight:</label> <input id="7" name="weight"
				class="textBoxProduct" type="text" /><br />
			<div id="16" class="err"></div>
			<label>Product Category:(*)</label>
			<div class="styled-select">
				<select name="category" class="textBoxProduct" id="8"
					style="width: 230px; height: 40px;">
					<c:forEach items="${productsCategory}" var="categ">
						<option>
							<c:out value="${categ.name}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<br />
			<div id="17" class="err"></div>
			<label>Image:</label> <input id="9" name="image"
				class="textBoxProduct" type="text" /><br />
			<div id="18" class="err"></div>
			<label>Comment:</label>
			<textarea cols="50" rows="10" name="comment" id="txtDescr"
				class="textAreaDescr"></textarea>
			<br />
			<div id="19" class="err"></div>
			<input name="insertProd" value="Insert" class="insertProduct"
				type="submit" /> <input name="cancelInsert" value="Cancel"
				class="cancelInsert" type="submit" />
		</div>
	</form>
</div>
<%@ include file="footer.jsp"%>