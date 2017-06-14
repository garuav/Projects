<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/customer/header.jsp"/>
<div class="container-fluid">
		<div class="row">
		<div class="col-md-3"><jsp:include page="/WEB-INF/jsp/customer/navlink.jsp" /></div>
		<div class="col-md-7">
		<div class="panel panel-default" >
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Complaint Log</h3>
						</div>
						<div class="table-responsive">
						<form:form action="complaintLog" method="post" modelAttribute="complaint">
							<table class="table">
							<tr>
									<td>Customer Name</td>
									<td><input type="text" class="input-sm" name="customerName" value="${loginSession.userId}" readonly></td>
									<td>Customer Id</td>
									<td><input type="text" class="input-sm" name="customerId" value="${loginSession.logId}"  readonly></td>
								</tr>
								<tr>
								<td>Ticket Id</td>
									<td><input type="text" class="input-sm" name="ticketId" value="${ticket.ticketId}" readonly></td>
									<td>Ticket Date</td>
									<td><input type="text" class="input-sm" name="ticketDate" value="${ticket.ticketDate}" readonly></td>
								</tr>
														
								<tr>
								<td>Equipment No</td>
									<td><input type="text" class="input-sm" name="equipmentNo"></td>
									<td>Complaint Details</td>
									<td><textarea name="complaintDetails"></textarea></td>
									
								</tr>
		</table>
		<input type="submit"  class="btn btn-primary btn-primary-spacing"> 
		<input type="reset" value="Clear" class="btn btn-primary btn-primary-spacing" >	
		</form:form>
		</div>
		<h3 style="color:green">${success}</h3>
<h3 style="color:red">${error}</h3>
		</div>
		</div>
		</div>
		<div class="col-md-2"></div>
		</div>
</div>
</body>
</html>