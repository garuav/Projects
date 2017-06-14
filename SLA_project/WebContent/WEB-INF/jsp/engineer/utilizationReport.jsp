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
							<h3 align="center">Utilization Report</h3>
						</div>
						<div class="table-responsive">
						<form:form action="#" method="post" modelAttribute="utilization">
						<table class="table">
						<tr>
						<td>Util Doc Id</td>
						<td><input type="text" class="input-sm" name="utilDocId"></td>
						<td></td>
						<td></td>
						</tr>
						<tr>
						<td>Engineer Name </td>
						<td><input type="text" class="input-sm" name="engName"></td>
						<td>Util Doc Date</td>
						<td><input type="text" class="input-sm" name="utilDocDate"></td>
						</tr>
						<tr>
						<td>Day Plan</td>
						<td><input type="text" class="input-sm" name="dayPlan"></td>
						<td>Status</td>
						<td><input type="text" class="input-sm" name="status"></td>
						</tr>
						<tr>
						<td>Visit Date</td>
						<td><input type="date" class="input-sm" name="visitDate"></td>
						<td>Visit TIme</td>
						<td><input type="text" class="input-sm" name="visitTime"></td>
						</tr>
						<tr>
						<td>Problem Defined</td>
						<td><input type="text" class="input-sm" name="problemDefine"></td>
						<td></td>
						<td></td>
						</tr>
						<tr>
						<td>Problem Found</td>
						<td><input type="text" class="input-sm" name="problemFound"></td>
						<td></td>
						<td></td>
						</tr>
						<tr>
						<td>Step Taken</td>
						<td><input type="text" class="input-sm" name="stepTaken"></td>
						<td>Reason</td>
						<td><input type="text" class="input-sm" name="reason"></td>
						</tr>
						</table>
						<hr>
						<input type="submit" value="Add"
									class="btn btn-info btn-primary-spacing">
								<input type="reset" value="Clear"
									class="btn btn-info btn-primary-spacing">
								<a href="utilizationReport" class="btn btn-info btn-primary-spacing">Show</a>
						</form:form>
						</div>
						<h3 style="color: green">${success}</h3>
						<h3 style="color: red">${error}</h3>
						</div>
						</div>


</div>
<div class="col-md-1"></div>
</div>
</div>
</body>
</html>