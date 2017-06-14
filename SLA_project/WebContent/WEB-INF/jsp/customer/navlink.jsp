<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name=viewport content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script
	src="<core:url value="/resources/bootstrap/js/jquery-3.1.1.min.js"/>"></script>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<script
	src="<core:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

</head>
<body>

	<div class="panel-group" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
						data-parent="#accordion" href="#collapseOne" aria-expanded="false"
						aria-controls="collapseOne" > Menu </a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingOne">
				<div class="list-group">
					<ul>
						
						<li class="list-group-item"><a href="complaintLog">Complaint
								Log</a></li>
						<li class="list-group-item"><a href="#">Feedback
								Master</a></li>
						<li class="list-group-item"><a href="complaintStatus">Complaint
								Status</a></li>
						<li class="list-group-item"><a href="warrantyInfo">Warranty
								Information</a></li>
						<li class="list-group-item"><a href="#">Mail
								Box</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>