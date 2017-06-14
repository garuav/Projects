<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<core:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/admin/header.jsp" />

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"><jsp:include page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-8">
				
				<div class="panel panel-default">
				<div class="panel-body">
				<div class="page-header ">
								<h3 align="center">Customer Master</h3>
							</div>
			<div class="table-responsive">
				<table class="table">
								<tr>
									<th>Customer Id</th>
									<th>Name</th>
									<th>House No.</th>
									<th>Society/Apartments</th>
									<th>Locality</th>
									<th>City</th>
									<th>State</th>
									<th>User Name</th>
									<th>Email</th>
									<th>Phone No</th>
									<th>Mobile No</th>
									<th>Fax</th>
									<th>Customer Type</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
								<core:forEach items="${customerList}" var="customerList">
									<tr>
										<td>${customerList.customerId}</td>
										<td>${customerList.customerName}</td>
										<td>${customerList.houseNo}</td>
										<td>${customerList.society}</td>
										<td>${customerList.locality}</td>
										<td>${customerList.city}</td>
										<td>${customerList.state}</td>
										<td>${customerList.userName}</td>
										<td>${customerList.email}</td>
										<td>${customerList.phoneNo}</td>
										<td>${customerList.mobile}</td>
										<td>${customerList.fax}</td>
										<td>${customerList.customerType}</td>
										<td><a
											href="editCustomer?customerId=${customerList.customerId}"><img
												src="resources/bootstrap/images/edit.png" width="25px"
												height="25px"></a></td>
										<td><a
											href="deleteCustomer?customerId=${customerList.customerId}">Delete</a></td>
									</tr>
								</core:forEach>
							</table>			
							</div>
							<h3 style="color:green">${msg}</h3>
				</div>
				</div>
				
			</div>
			
		</div>
	</div>
</body>
</html>