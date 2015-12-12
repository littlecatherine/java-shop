<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragment/header.jsp" />

<body>

<div class="container">

    <%-- NO NEED YET --%>
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Foods</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Food Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach var="cart" items="${cartitem}">
            <tr>
                <td>${cart.food_name}</td>
                <td>${cart.food_price}</td>
                <td>
                    <input type="text" name="id1" value="${cart.quantity}" />
                </td>
                <td>
                    <spring:url value="/users/${user.id}/update" var="updateUrl" />
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                    <button class="btn btn-success" onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragment/footer.jsp" />

</body>
</html>