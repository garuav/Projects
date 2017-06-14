<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
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
			<div class="col-md-6">

				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Assign Complaint</h3>
						</div>
						<div class="table-responsive">
							<form:form action="assign" method="post" modelAttribute="assignComplaint">
								<table class="table">
									<tr>
									<td>Ticket Id</td>
									<td><input type="text" class="input-sm" name="ticketId" value="${editComplaint.ticketId}" readonly></td>
									<td>Ticket Date</td>
									<td><input type="text" class="input-sm" name="ticketDate" value="${editComplaint.ticketDate}" readonly></td>
									</tr>
									<tr>
									<td>Complaint Details</td>
									<td><input type="text" class="input-sm" name="complaintDetails" value="${editComplaint.complaintDetails}" readonly></td>
									<td>Telecaller Id</td>
									<td><input type="text" class="input-sm" name="telecallerId"></td>
									</tr>
									<tr>
									<td>Engineer Name</td>
									<td><input type="text" class="input-sm" name="engineerName"></td>
									<td></td>
									<td></td>
									</tr>
									<tr>
									<td>Note</td>
									<td><textarea name="note" class="input-sm"></textarea></td>
									<td></td>
									<td></td>
									</tr>
								</table>
								<input type="submit" value="Assign" class="btn btn-info btn-primary-spacing"> 
		<input type="reset" value="Clear" class="btn btn-info btn-primary-spacing" >		
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>