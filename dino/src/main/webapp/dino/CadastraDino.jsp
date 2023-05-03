<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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

<body>
		
	<jsp:include page="../component/navbar.jsp" />

	<div class="container">
		<div class="row">
			<div class="col">
				<h2>Cadastro Dinossauro</h2>
				<form
					action="${pageContext.request.contextPath}/dino?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Espécie</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="specie">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Dieta</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="diet">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Habitat</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="habitat">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Período</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="period">
						</div>
					</div>
					
					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Descrição</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="description">
						</div>
					</div>

					<input class="btn btn-primary" type="submit" value="Gravar" />
				</form>
			</div>
		</div>
	</div>
	</body>
</html>