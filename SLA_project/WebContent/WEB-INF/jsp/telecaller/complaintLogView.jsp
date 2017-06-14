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
	<jsp:include page="/WEB-INF/jsp/telecaller/header.jsp" />
	<div class="container-fluid">
		<div class="row">

			<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/telecaller/navlink.jsp" /></div>

			<div class="col-md-8">
				<div class="table-responsive">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="page-header ">
								<h3 align="center">Complaint Log View</h3>
							</div>
						</div>		
					<table class="table">
	<tr><th>Customer Name</th>
	<th>Ticket Id </th>
	<th>Ticket Date</th>
	<th>Equipment No</th>
	<th>Complaint Details </th>
	<th></th>
	</tr>
	<core:forEach items="${complaintList}" var="compList">
		<tr><td>${compList.customerName}</td>
		<td>${compList.ticketId}</td>
		<td>${compList.ticketDate}</td>
		<td>${compList.equipmentNo}</td>
		<td>${compList.complaintDetails}</td>
		<td><a href="assign?ticketId=${compList.ticketId}">Assign </a></td>
		</tr>
		</core:forEach>
	</table>
	</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>