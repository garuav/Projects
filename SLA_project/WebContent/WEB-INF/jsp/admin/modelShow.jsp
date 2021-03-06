<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model Master</title>
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
							<h3 align="center">Model Master</h3>
						</div>
						<div class="table-responsive">
<table class="table" width="100%">
	<tr><th>Model Id</th>
	<th>Name </th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>	
	<core:forEach items="${modelList}" var="modelList">
		<tr><td>${modelList.modelId}</td>
		<td>${modelList.modelName}</td>
		<td><a href="editModel?modelId=${modelList.modelId}"><img src="resources/bootstrap/images/edit.png" width="25px" height="25px"></a></td>
		<td><a href="deleteModel?modelId=${modelList.modelId}">Delete</a></td>
		
		</tr>
	</core:forEach>
	</table>
	</div>
	<h3 style="color:green">${msg}</h3>
			</div>
			</div>
				</div>
				<div class="col-md-1"></div>
			</div>
			</div>
			
</body>
</html>