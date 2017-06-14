<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Master</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
			<jsp:include page="/WEB-INF/jsp/admin/navlink.jsp"/>
			</div>
			<div class="col-md-6" class="table-responsive">

				<div class="panel panel-default" >
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Product Master</h3>
						</div>
						<form:form action="productAdd" method="post" modelAttribute="product">
						<table class="table">
						<tr>
						<td>Product Id: </td>
						<td><input type="text" name="productId" class="input-sm" value="${product.productId}" readonly></td>
						</tr>
						<tr>
						<td>Product Name : </td>
						<td><input type="text" name="productName" class="input-sm" value="${product.productName}"></td>
						</tr>
						<tr>
						<td>Phase : </td>
						<td><input type="text" name="phase" class="input-sm" value="${product.phase}"></td>
						</tr>
						<tr>
						<td>Warranty : </td>
						<td><input type="text" name="warranty" class="input-sm" value="${product.warranty}"></td>
						</tr>
						<tr>
						<td>Model Name : </td>
						<td><select name="modelName">
					  <option value="" label="${product.modelName}"  />
					  <core:forEach items="${modelList}" var="modelDetails">
					  <option value="${modelDetails.modelName}" >${modelDetails.modelName}</option>
					  </core:forEach>
					  </select></td>
						</tr>
						</table><hr>
						<input type="submit" value="Save" class="btn btn-primary btn-primary-spacing" >
						<input type="reset" value="Clear" class="btn btn-primary btn-primary-spacing" >
						<a href="getProduct" class="btn btn-primary btn-primary-spacing">Show</a>
					
						</form:form>
						</div>
						<h3 style="color:green">${success}</h3>
  						<h3 style="color:red">${error}</h3>
						</div>
						</div>
						<div class="col-md-3"></div>
						</div>
						</div>
		</body>
</html>