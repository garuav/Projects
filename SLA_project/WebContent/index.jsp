
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
			<div class="row">
			<nav  class="navbar navbar-inverse">
   <div class="navbar-header">
   <img src="resources/bootstrap/images/Maintenance.png"  width="25px" height="25px">
  <font color="white" size="5px" face="Copperplate Gothic Bold" style="margin-left:2px;">SLA For Computer Maintenance  </font>
    </div>
    </nav>
			
			<div class="col-md-3"></div>
			<div class="col-md-5">
			<div class="panel panel-primary" >
			 <div class="panel-heading">
			 <H4>LOGIN TO YOUR ACCOUNT</H4>
			 </div>
			 	<form:form action="dashboard" method="post" modelAttribute="login">
			 	
			  <div class="panel-body">
			 <hr><div class="input-group">
						<span class="input-group-addon" id="sizing-addon2">@</span> <input
							type="text" name="userId" class="form-control"
							placeholder="Username" aria-describedby="sizing-addon2">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input id="password"
							type="password" name="password" class="form-control"
							name="password" placeholder="Password">
					</div>
					<br>
					<div class="btn-group" role="group">
					<button type="submit" class="btn btn-info">Login</button>
					</div><br><hr>
					<button type="button" class="btn btn-link"
						style="color: red;"><b>Change Password</b></button>
						<font style="color: red;">${msg }</font>
				</div>
				</form:form>
			
			</div>
			
			</div>
			<div class="col-md-4"></div>
</div>
			
		</div>

</body>
</html>
