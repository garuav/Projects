<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="<core:url value="/resources/bootstrap/js/jquery-3.1.1.min.js"/>"></script>
	<script
	src="<core:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
	<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
	<script>
	$(document).ready(function () {
		var url = (window.location).href; // You can also use document.URL
		var id = url.substring(url.lastIndexOf('=') + 1);
		alert(id);
		if(id!=null)
			{
				$("#customerName").hide();
				$("#name").hide();
			}
	
	
	});
	</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
	
	<div class="container-fluid" >
		<div class="row" >
			<div class="col-md-3" ><jsp:include
					page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-8" class="table-responsive">

				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Customer Master</h3>
						</div>
						<form:form action="CustomerRegstration" method="post"
							modelAttribute="customer">
							<table class="table">

								<tr>
									<td>Customer ID</td>
									<td><input type="text" class="input-sm"
										name="customerId" value="${customer.customerId}"></td>
									<td><div id="name">Customer Name</div></td>
									<td><input type="text" class="input-sm"
										name="customerName" id="customerName" value="${customer.customerName}"></td>
								</tr>
								<tr>
									<td>House No.</td>
									<td><input type="text" class="input-sm"
										name="houseNo" value="${customer.houseNo}"></td>
									<td>Address 2</td>
									<td><input type="text" class="input-sm"
										name="society" value="${customer.society}"></td>
								</tr>
								<tr>
									<td>Locality</td>
									<td><input type="text" class="input-sm"
										name="locality" value="${customer.locality}"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>City</td>
									<td><input type="text" class="input-sm" name="city"
										value="${customer.city}"></td>
									<td>State</td>
									<td><input type="text" class="input-sm" name="state"
										value="${customer.state}"></td>
								</tr>
								
								<tr>
									<td>Email</td>
									<td><input type="text" class="input-sm" name="email"
										value="${customer.email}"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>Phone No</td>
									<td><input type="text" class="input-sm" name="phoneNo"
										value="${customer.phoneNo}"></td>
									<td>Mobile</td>
									<td><input type="text" class="input-sm" name="mobile"
										value="${customer.mobile}"></td>
								</tr>
								<tr>
									<td>Fax</td>
									<td><input type="text" class="input-sm" name="fax"
										value="${customer.fax}"></td>
									<td>Customer Type</td>
									<td><select name="customerType">
					  <option value="" label="${customer.customerType} " />
					  <option value="Corporate">Corporate</option>
					  <option value="Individual">Individual</option>
					  </select></td>
								</tr>
							</table>
							<input type="submit" value="Save" class="btn btn-primary">
							<input type="reset" value="Clear" class="btn btn-primary">
								<a href="getCustomer" class="btn btn-primary btn-primary-spacing">Get Customer</a>		
						</form:form>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>