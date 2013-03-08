<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="listProd">
	<div class="noProd">List Category of products!!</div>
	<form method="get" action="DeleteCategoryProduct.aspx">
		<input name="addCateg" value="Add" class="insertProduct" type="submit" />
		<input name="delCateg" value="Delete " class="cancelInsert"
			type="submit" />
		<c:if test="${!empty productsCategory}">
			<table id="table-design">
				<thead>
					<tr>
						<th><input type="checkbox" name="id" style="display: block;"
							id="selectall" /></th>
						<c:forEach begin="1" end="${fn:length(allFields)-1}" var="i">
							<th class="<c:out value="${allFields[i]}"/>"><span><c:out
										value="${allFields[i]}" /></span> <c:set var="tests" value="ASC" />
								<c:choose>
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
								</c:choose>
						</c:forEach>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productsCategory}" var="categ">
						<tr id="bg_<c:out value="${categ.id}"/>">
							<td><input type="checkbox" id="<c:out value="${categ.id}"/>"
								name="id" class="case" style="display: block;"
								value="<c:out value="${categ.name}"/>" /></td>
							<td><c:out value="${categ.name}" /></td>
							<td><c:out value="${categ.description}" /></td>
							<td style="width: 55px;"><a
								href="DeleteCategoryProduct.aspx?id=<c:out value="${categ.id}"/>"
								class="editButton"> <img
									src="/ProjectLicense/Images/editButton.png" class="imageStyle" />edit
							</a></td>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty productsCategory}">
			<c:out value="No products defined yet!!" />
		</c:if>
	</form>
	<%@ include file="PaginationCategoryProducts.jsp"%>
</div>
<%@ include file="footer.jsp"%>