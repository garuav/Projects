<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model Master</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/admin/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-6">

				<div class="panel panel-default" style="background-color: #edefff">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Model Master</h3>
						</div>
						<div class="table-responsive">
							<form:form action="modelAdd" method="post"
								modelAttribute="modelMast">
								<table class="table">
									<tr>
										<td>Model Id:</td>
										<td><input type="text" name="modelId"
											class="input-sm" value="${model.modelId}" readonly></td>
									<tr>
										<td>Name :</td>
										<td><input type="text" name="modelName" value="${model.modelName}"
											class="input-sm"></td>
									</tr>
								</table>
								<hr>
								<input type="submit" value="Save"
									class="btn btn-primary btn-primary-spacing">
								<input type="reset" value="Clear"
									class="btn btn-primary btn-primary-spacing">
								<a href="getModel" class="btn btn-primary btn-primary-spacing">Show</a>
							</form:form>
						</div>
						<h3 style="color: green">${success}</h3>
						<h3 style="color: red">${error}</h3>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>