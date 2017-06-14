<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Master</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />" rel="stylesheet">

</head>
<body>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
<div class="container-fluid">
		<div class="row">
		<div class="col-md-4">
		<div class="list-group">
  <p class="list-group-item active">
    Master
  </p>
  <a href="modelMas" class="list-group-item">Model Master</a>
  <a href="employeeMaster" class="list-group-item">Employee Master</a>
  <a href="productMas" class="list-group-item">Product Master</a>
  <a href="spareMas" class="list-group-item">Spare Master</a>
  <a href="customerMaster" class="list-group-item">Customer Master</a>
  <a href="locationMas" class="list-group-item">Location Master</a>
  <a href="unitMas" class="list-group-item">Unit Master</a>
</div>
						</div>
								<div class="col-md-4">
		<div class="list-group">
  <p class="list-group-item active">
    Transaction
  </p>
  <a href="#" class="list-group-item">Spare Requirement</a>
  <a href="warrantyTrack" class="list-group-item">Warranty Tracking</a>
 </div>
						</div>
								<div class="col-md-4">
		<div class="list-group">
  <p class="list-group-item active">
    Report
  </p>
  <a href="#" class="list-group-item">Utilization Report</a>
  <a href="#" class="list-group-item">Customer Feedback</a>
</div>
						</div>	
		</div>
</div>

<jsp:include page="/WEB-INF/jsp/admin/footer.jsp"/>
</body>
</html>