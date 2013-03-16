<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="header.jsp"%>

<div class="listProd">
	<div class="noProd">List of Inventory!!!</div>
	<form method="get" action="DeleteInventory.aspx">
		<input name="addInventory" value="Add" class="insertProduct"
			type="submit" /> <input name="delInventory" value="Delete "
			class="cancelInsert" type="submit" />
		<c:if test="${!empty inventory}">
			<table id="table-design">
				<thead>
					<tr>
						<th><input type="checkbox" name="id" style="display: block;"
							id="selectall" /></th>
						<c:forEach begin="1" end="${fn:length(allFields)-1}" var="i">
							<th class="<c:out value="${allFields[i]}"/>"><span><c:out
										value="${allFields[i]}" /></span> <c:set var="tests" value="ASC" />
								<%-- 	<c:choose>
									<c:when test="${empty asccending}">
										<a
											href="ControlerListProductCategory.aspx?page=<c:out
						value="${currentPage}"/>&fieldName=<c:out
						value="${allFields[i]}"/>&sorting=ASC"><img
											src="/ProjectLicense/Images/sort_both.png"
											alt="no picture found!!"></a>
									</c:when>
									<c:when test="${asccending eq tests}">
										<a
											href="ControlerListProductCategory.aspx?page=<c:out
						value="${currentPage}"/>&fieldName=<c:out
						value="${allFields[i]}"/>&sorting=DESC"><img
											src="/ProjectLicense/Images/sort_asc.png"
											alt="no picture found!!"></a>
									</c:when>
									<c:otherwise>
										<a
											href="ControlerListProductCategory.aspx?page=<c:out
									value="${currentPage}"/>&fieldName=<c:out
									value="${allFields[i]}"/>&sorting=ASC">
											<img src="/ProjectLicense/Images/sort_desc.png"
											alt="no picture found!!">
										</a>
									</c:otherwise>
								</c:choose> --%>
						</c:forEach>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inventory}" var="invent">
						<tr id="bg_<c:out value="${invent.id}"/>">
							<td><input type="checkbox"
								id="<c:out value="${invent.id}"/>" name="id" class="case"
								style="display: block;"
								value="<c:out value="${invent.inventoryName}"/>" /></td>
							<td><c:out value="${invent.inventoryName}" /></td>
							<td><c:out value="${invent.inventoryLocation}" /></td>
							<td><c:out value="${invent.stockCapacity}" /></td>
							<td style="width: 55px;"><a
								href="DeleteInventory.aspx?id=<c:out value="${invent.id}"/>"
								class="editButton"> <img
									src="/ProjectLicense/Images/editButton.png" class="imageStyle" />edit
							</a></td>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty inventory}">
			<c:out value="No products defined yet!!" />
		</c:if>
	</form>
</div>
<%@ include file="footer.jsp"%>