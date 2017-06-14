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
		<div class="row">
			<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
			<div class="col-md-8">

				<div class="panel panel-default" >
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Employee Master</h3>
						</div>
						<div class="table-responsive">
						<form:form action="employeeRegstration" method="post" modelAttribute="employee">
							<table class="table">
							<tr>
									<td>Employee ID</td>
									<td><input type="text" class="input-sm" name="empId" value="${employee.empId}" readonly></td>
									<td>Employee Name</td>
									<td><input type="text" class="input-sm" name="empName"></td>
								</tr>
							<tr>
									<td>House No.</td>
									<td><input type="text" class="input-sm" name="houseNo"></td>
									<td>Society/Apartments </td>
									<td><input type="text" class="input-sm" name="society"></td>
								</tr>
								<tr>
									<td>Locality</td>
									<td><input type="text" class="input-sm" name="locality"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>City</td>
									<td><input type="text" class="input-sm" name="city"></td>
									<td>State</td>
									<td><input type="text" class="input-sm" name="state"></td>
								</tr>
								<tr>
									<td>Location Name</td>
									<td><input type="text" class="input-sm" name="locationName"></td>
									<td></td>
									<td></td>
								</tr>

								<tr>
									<td>Date Of Birth</td>
									<td><input  type="date" class="input-sm" name="dob" ></td>

									<td>Join Date</td>
									<td><input type="date" class="input-sm" name="joinDate"></td>
								</tr>
								<tr>
									<td>Status</td>
									<td><input type="text" class="input-sm" name="status"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>User Id</td>
									<td><input type="text" class="input-sm" name="userName"></td>
									<td>Password</td>
									<td><input type="password" class="input-sm" name="password"></td>
								</tr>
								<tr>
									<td>Employee Type</td>
									<td><select name="empType">
					  <option value="" label="Select Employee Type " />
					  <option value="Admin">Admin</option>
					  <option value="Manager">Manager</option>
					  <option value="Telecaller">Telecaller</option>
					  <option value="Engineer">Engineer</option>
					  </select></td>
									<td></td>
									<td></td>
								</tr>
							
							
		
			</table>			
		<input type="submit" value="Add" class="btn btn-primary btn-primary-spacing"> 
		<input type="reset" value="Clear" class="btn btn-primary btn-primary-spacing" >						
<a href="getEmployee"  class="btn btn-primary btn-primary-spacing">Get Employee</a>
</form:form>
</div>
						
<h3 style="color:green">${success}</h3>
<h3 style="color:red">${error}</h3>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</div>
</body>
</html>