<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragment/header.jsp" />

<div class="container">

	<%--<c:choose>--%>
		<%--<c:when test="${userForm['new']}">--%>
			<%--<h1>Registration</h1>--%>
		<%--</c:when>--%>
		<%--<c:otherwise>--%>
			<%--<h1>Update User</h1>--%>
		<%--</c:otherwise>--%>
	<%--</c:choose>--%>
	<%--<br />--%>

	<spring:url value="/users" var="userActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="quantityForm" action="${userActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Quantity</label>
				<div class="col-sm-10">
					<form:input path="quantity" type="text" class="form-control " id="quantity" placeholder="Quantity" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragment/footer.jsp" />

</body>
</html>