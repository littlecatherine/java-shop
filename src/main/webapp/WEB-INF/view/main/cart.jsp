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
            <th>Uid</th>
            <th>Food_id</th>
            <th>Quantity</th>
        </tr>
        </thead>

            <tr>
                <td>${cart.user_id}</td>
                <td>${cart.food_id}</td>
                <td>${cart.quantity}</td>
            </tr>
    </table>

</div>

<jsp:include page="../fragment/footer.jsp" />

</body>
</html>