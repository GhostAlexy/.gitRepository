<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--For displaying Previous link except for the 1st page --%>
<ul class="tsc_pagination tsc_paginationA tsc_paginationA01">
	<%-- <li><a href="ControlerListProductCategory.aspx?page=1&fieldName=${sort}&sorting=${asccending}">First</a></li> --%>
	<c:if test="${currentPage != 1}">
		<li><a
			href="ControlerListProductCategory.aspx?page=1&fieldName=${sort}&sorting=${asccending}">First</a></li>
		<li><a
			href="ControlerListProductCategory.aspx?page=${currentPage - 1}&fieldName=${sort}&sorting=${asccending}">Previous</a></li>
	</c:if>
	<%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
	<c:forEach begin="${startPage}" end="${endPage}" var="i">
		<c:choose>
			<c:when test="${currentPage eq i}">
				<li><a class="current">${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a
					href="ControlerListProductCategory.aspx?page=${i}&fieldName=${sort}&sorting=${asccending}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<li><a
			href="ControlerListProductCategory.aspx?page=${currentPage + 1}&fieldName=${sort}&sorting=${asccending}">Next</a></li>
		<li><a
			href="ControlerListProductCategory.aspx?page=${noOfPages}&fieldName=${sort}&sorting=${asccending}">Last</a></li>

	</c:if>
	<%-- 	<li><a href="ControlerListProductCategory.aspx?page=${noOfPages}&fieldName=${sort}&sorting=${asccending}">Last</a></li>
 --%>
</ul>