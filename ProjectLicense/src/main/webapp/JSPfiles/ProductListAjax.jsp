<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<table id="table-design">
	<thead>
		<tr>
			<th><input type="checkbox" id="selectall" style="display: block" /></th>
			<%-- <c:forEach begin="1" end="${fn:length(selectedFields)-1}" var="i"> --%>
			<c:forEach begin="1" items="${selectedFields}" var="select">
				<th class="<c:out value="${select.key}"/>"><span><c:out
							value="${select.value}" /></span> <c:set var="tests" value="ASC" />
					<c:choose>
						<c:when test="${empty asccending}">
							<a
								href="ControlerListProduct.aspx?page=<c:out
						value="${currentPage}"/>&fieldName=<c:out
						value="${select.key}"/>&sorting=ASC"><img
								src="/ProjectLicense/Images/sort_both.png"
								alt="no picture found!!"></a>
						</c:when>
						<c:when test="${asccending eq tests}">
							<a
								href="ControlerListProduct.aspx?page=<c:out
						value="${currentPage}"/>&fieldName=<c:out
						value="${select.key}"/>&sorting=DESC"><img
								src="/ProjectLicense/Images/sort_asc.png"
								alt="no picture found!!"></a>
						</c:when>
						<c:otherwise>
							<a
								href="ControlerListProduct.aspx?page=<c:out
									value="${currentPage}"/>&fieldName=<c:out
									value="${select.key}"/>&sorting=ASC">
								<img src="/ProjectLicense/Images/sort_desc.png"
								alt="no picture found!!">
							</a>
						</c:otherwise>
					</c:choose></th>
			</c:forEach>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products}" var="prod">
			<tr id="bg_<c:out value="${prod.id}"/>">
				<td><input type="checkbox" class="case"
					id="<c:out value="${prod.id}"/>" name="id" style="display: block"
					value="<c:out value="${prod.nameProduct}"/>" /></td>
					<c:forEach begin="1" items="${selectedFields}" var="selecte">
			<%-- 	<c:forEach begin="1" end="${fn:length(selectedFields)-1}" var="i"> --%>
					<td class="<c:out value="${selecte.key}"/>">
					<c:out value="${prod.getAttributeValue(selecte.key)}"/></td>
				</c:forEach>

				<td style="width: 55px;"><a
					href="DeleteProduct.aspx?id=<c:out value="${prod.id}"/>"
					class="editButton"> <img
						src="/ProjectLicense/Images/editButton.png" class="imageStyle" />edit
				</a></td>
		</c:forEach>
	</tbody>
</table>