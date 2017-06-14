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
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/engineer/header.jsp"/>
<div class="container-fluid">
<div class="row">
<div class="col-md-3"><jsp:include page="/WEB-INF/jsp/engineer/navlink.jsp" /></div>
<div class="col-md-8">
<div class="panel panel-default">
					<div class="panel-body" >
						<div class="page-header ">
							<h3 align="center">Complaint Login View</h3>
						</div>
						<div class="table-responsive">
<table class="table">
	<tr><th>Ticket Id</th>
	<th>Ticket Date </th>
	<th>Customer Name</th>
	<th>House No</th>
	<th>Society/Apartments</th>
	<th>Locality</th>
	<th>City</th>
	<th>Equipment No</th>
	<th>Complaint Details</th>
	</tr>	
	
	</table>
	</div>

</div>
<div class="col-md-1"></div>
</div>
</div>
</div>
</div>
</body>
</html>