<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Master</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-body" >
						<div class="page-header ">
							<h3 align="center">Employee Master</h3>
						</div>
						<div class="table-responsive">
<table class="table">
	<tr><th>Employee Id</th>
	<th>Name </th>
	<th>House No.</th>
	<th>Society/Apartments</th>
	<th>Locality</th>
	<th>City</th>
	<th>State</th>
	<th>Location Name</th>
	<th>Date Of Birth</th>
	<th>Join Date</th>
	<th>Status</th>
	<th>User Id</th>
	<th>Employee Type</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>	
	<core:forEach items="${employeeList}" var="employeeList">
		<tr><td>${employeeList.empId}</td>
		<td>${employeeList.empName}</td>
		<td>${employeeList.houseNo}</td>
		<td>${employeeList.society}</td>
		<td>${employeeList.locality}</td>
		<td>${employeeList.city}</td>
		<td>${employeeList.state}</td>
		<td>${employeeList.locationName}</td>
		<td>${employeeList.dob}</td>
		<td>${employeeList.joinDate}</td>
		<td>${employeeList.status}</td>
		<td>${employeeList.userName}</td>
		<td>${employeeList.empType}</td>
		<td><a href="editEmployee?empId=${employeeList.empId}"><img src="resources/bootstrap/images/edit.png" width="25px" height="25px"></a></td>
		<td><a href="deleteEmployee?empId=${employeeList.empId}">Delete</a></td>
		
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