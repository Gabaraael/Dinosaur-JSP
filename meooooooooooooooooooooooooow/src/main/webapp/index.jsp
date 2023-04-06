<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dinosauria</title>
<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>


<body class="bg-dark">
	<jsp:include page="/component/navbar.jsp" />
	<h2 class="text-info" align="center">Seja bem vindo ao dinosauria</h2>
	<jsp:include page="/component/footer.jsp" />
</body>

<c:if test="${userSubmitForm}">
	<script>
		alert("Usuário Cadastrado");			
	</script>
</c:if>

</html>