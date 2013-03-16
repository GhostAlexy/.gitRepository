<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="chooseColumnDiv">
	<div class="closeDiv">
		<a id="hide" href="javascript: "
			onclick="showHideDiv('hide', 'chooseColumnDiv')"><img
			src="Images/closeButton.png" alt="close img" width="18" height="18"></a>
	</div>
	<h1>Choose Columns</h1>
	
	<c:forEach begin="1" items="${allFields}" var="allFields">
		<input type="checkbox"
			<c:if test="${fn:contains(selectedFields, allFields.key)}">checked="checked"</c:if>
			id='controler<c:out value="${allFields.key}"/>'
			name='<c:out value="${allFields.key}"/>'
			onclick="fnShowHide('<c:out value="${allFields.key}"/>', 'controler<c:out value="${allFields.key}"/>','<c:out
						value="${currentPage}"/>');" />
		<label for="controler<c:out value="${allFields.key}"/>"><span></span>
			<c:out value="${allFields.value}" /></label>
		<br />
	</c:forEach>
	<%-- <c:forEach begin="2" end="${fn:length(allFields)-1}" var="i">
		<input type="checkbox"
			<c:if test="${fn:contains(selectedFields, allFields[i])}">checked="checked"</c:if>
			id='controler<c:out value="${allFields[i]}"/>'
			name='<c:out value="${allFields[i]}"/>'
			onclick="fnShowHide('<c:out value="${allFields[i]}"/>', 'controler<c:out value="${allFields[i]}"/>','<c:out
						value="${currentPage}"/>');" />
		<label for="controler<c:out value="${allFields[i]}"/>"><span></span>
			<c:out value="${fictiveName[i]}" /></label>
		<br />
	</c:forEach> --%>
</div>