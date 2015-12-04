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

    <h1>All Foods</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Price</th>
            <th>Add to cart</th>
        </tr>
        </thead>

        <c:forEach var="food1" items="${foods1}">
            <tr>
                <td>${food1.image}</td>
                <td>${food1.name}</td>
                <td>${food1.price}</td>
                <td>
                    <spring:url value="/food/${food1.id}" var="foodUrl" />
                    <button class="btn btn-addtocart" onclick="location.href='${foodUrl}'">Add</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<jsp:include page="../fragment/footer.jsp" />

</body>
</html>