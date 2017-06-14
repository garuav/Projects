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
	<style>
table
{font-size:12px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/admin/header.jsp" />

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"><jsp:include page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-10">
				
				<div class="panel panel-default">
				<div class="panel-body">
				
				<div class="page-header ">
								<h3 align="center">Warranty Tracking</h3>
							</div>
			<div class="table-responsive">
				<table class="table">
								<tr>
									<th>Customer Name</th>
									<th>Doc Id</th>
									<th>Doc Date</th>
									<th>City</th>
									<th>State</th>
									<th>Product Name</th>
									<th>Purchase Date</th>		
									<th>Dispatch Date</th>
									<th>Equipment Sr No</th>
									<th>Manufacturer Sr No</th>
									<th>Install Date</th>
									<th>New Warranty Date</th>
									<th>Gross Exp</th>
									<th>Expiry Date</th>
									<th>Edit</th>
									<th>Delete</th>
									</tr>
									
									<core:forEach items="${warranty}" var="warrantyList">
									<tr>
										<td>${warrantyList.customer}</td>
										<td>${warrantyList.docId}</td>
										<td>${warrantyList.docDate}</td>
										<td>${warrantyList.city}</td>
										<td>${warrantyList.state}</td>
										<td>${warrantyList.productName}</td>
										<td>${warrantyList.purchaseDate}</td>
										<td>${warrantyList.dispatchDate}</td>
										<td>${warrantyList.eqtSrNo}</td>
										<td>${warrantyList.mgrSrNo}</td>
										<td>${warrantyList.installDate}</td>
										<td>${warrantyList.newWarrenty}</td>
										<td>${warrantyList.grossExp}</td>
										<td>${warrantyList.expiryDate}</td>
										<td><a
											href="editWarranty?docId=${warrantyList.docId}"><img
												src="resources/bootstrap/images/edit.png" width="25px"
												height="25px"></a></td>
										<td><a
											href="deleteWarranty?docId=${warrantyList.docId}">Delete</a></td>
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