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
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
<div class="container-fluid">
		<div class="row">
		<div class="col-md-4">
		<div class="list-group">
  <p class="list-group-item active">
    Menu
  </p>
  <a href="complaintLoginView" class="list-group-item">Complaint Login View</a>
  <a href="assignComplaint" class="list-group-item">Assign Complaint</a>
  <a href="#" class="list-group-item">Complaint Status</a>
  <a href="warrantyInfoTele" class="list-group-item">Warranty Information</a>
</div>
</div>
</div>
</div>

</body>
</html>