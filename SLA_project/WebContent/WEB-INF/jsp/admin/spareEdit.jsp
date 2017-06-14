<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spare Master</title>
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
			<div class="col-md-6" class="table-responsive">

				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Spare Master</h3>
						</div>
						<form:form action="spareAdd" method="post" modelAttribute="spare">
							<table class="table">
								<tr>
									<td>Spare Id:</td>
									<td><input type="text" name="spareId" class="input-sm"
										value="${spare.spareId}"  readonly></td>
								</tr>
								<tr>
									<td>Spare Name :</td>
									<td><input type="text" name="spareName" class="input-sm" value="${spare.spareName}" ></td>
								</tr>
								<tr>
									<td>Rate :</td>
									<td><input type="text" name="rate" class="input-sm" value="${spare.rate}" ></td>
								</tr>
								<tr>
									<td>Unit :</td>
									<td><input type="text" name="unit" class="input-sm" value="${spare.unit}" ></td>
								</tr>
							</table>
							<hr>
							<input type="submit" value="Add"
								class="btn btn-primary btn-primary-spacing">
							<input type="reset" value="Clear"
								class="btn btn-primary btn-primary-spacing">
									<a href="getSpare" class="btn btn-primary btn-primary-spacing">Get Spare</a>		
						</form:form>
					</div>
					<h3 style="color: green">${success}</h3>
					<h3 style="color: red">${error}</h3>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>