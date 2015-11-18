<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/" var="urlHome" />
<spring:url value="/cart" var="urlCart" />
<spring:url value="/orders" var="urlOrders" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />


<title>Joe's Online Food Store</title>

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Joe's Online Food Store</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${urlCart}">Shopping Cart</a></li>
				<li class="active"><a href="${urlOrders}">Orders</a></li>
			</ul>
		</div>
	</div>
</nav>
</head>