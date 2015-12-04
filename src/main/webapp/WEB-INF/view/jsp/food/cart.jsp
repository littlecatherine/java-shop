<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

    <h1>My Cart</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Quantity</th>
        </tr>
        </thead>

        <%--<c:forEach var="food" items="${foods}">--%>
            <%--<tr>--%>
                <%--<td>${food.image}</td>--%>
                <%--<td>${food.name}</td>--%>
                <%--<td>${food.price}</td>--%>
                <%--<td>${cart.quantity}</td>--%>
                <%--<td>--%>
                    <%--<spring:url value="/food/${food.id}" var="foodUrl" />--%>
                    <%--<button class="btn btn-addtocart" onclick="location.href='${foodUrl}'">Add</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <c:forEach var="cart" items="${cart}">
            <tr>
                <td>${cart.quantity}</td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragment/footer.jsp" />

</body>
</html>