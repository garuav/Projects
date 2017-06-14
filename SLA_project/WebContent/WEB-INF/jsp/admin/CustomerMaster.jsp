<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Master</title>
<script
	src="<core:url value="/resources/bootstrap/js/jquery-3.1.1.min.js"/>"></script>
		<script
	src="<core:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />" rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
	<script>
function changeFunc()
{
	var userName=document.getElementById("userName").value;
	
	$.ajax({
        url : 'validCstUserName?userName='+userName,
        success : function(data) {
      
        	showValid(data);
        },
        error:function(data,status,errorThrown){
        	alert("Error= "+errorThrown+" Status= "+status);
        	
        }
        
    });
}
function showValid(data){
	
	if(data!=false)
		{
		document.getElementById("valid").innerHTML=" User Name Alredy Registered ";
		
		
		}
	else
		{
		document.getElementById("valid").innerHTML="User Name Available ";
		}
}

//.........................Edit Hide Code ..............................................

// 	$(document).ready(function () {
// 		var url = (window.location).href; // You can also use document.URL
// 		var id = url.substring(url.lastIndexOf('=') + 1);
// 		alert(id);
// 		if(id!=null)
// 			{
// 				$("#user").hide();
// 				$("#pass").hide();
// 				$("#password").hide();
// // 				$("#customerType").val(${customer.customerType});
// 			}
	
	
// 	});
	</script>

	
</head>
<body>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"><jsp:include page="/WEB-INF/jsp/admin/navlink.jsp"/></div>
			<div class="col-md-9">

				<div class="panel panel-default" >
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Customer Master</h3>
						</div>
						<div class="table-responsive">
						<form:form action="CustomerRegstration" method="post" modelAttribute="customer">
						
							<table class="table">
							<tr>
									<td>Customer ID</td>
									<td><input type="text" class="input-sm" name="customerId" value="${customer.customerId}" readonly></td>
									<td>Customer Name</td>
									<td><input type="text" class="input-sm" name="customerName" value="${customer.customerName}"></td>
								</tr>
							<tr>
									<td>House No.</td>
									<td><input type="text" class="input-sm" name="houseNo" value="${customer.houseNo}"></td>
									<td>Society/Apartments </td>
									<td><input type="text" class="input-sm" name="society" value="${customer.society}"></td>
								</tr>
								<tr>
									<td>Locality</td>
									<td><input type="text" class="input-sm" name="locality" value="${customer.locality}"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>City</td>
									<td><input type="text" class="input-sm" name="city" value="${customer.city}"></td>
									<td>State</td>
									<td><input type="text" class="input-sm" name="state" value="${customer.state}"></td>
								</tr>
								<tr id="user">
									<td>User Name</td>
									<td><input type="text" class="input-sm" name="userName" id="userName" onchange="changeFunc();"></td>
									<td colspan="2">
				<p id="valid" style="color:red"> </p></td>
									
								</tr>
								<tr>
									<td>Email</td>
									<td><input  type="text" class="input-sm" name="email" value="${customer.email}"></td>

									<td><div id="pass">Password</div></td>
									<td><input type="password" class="input-sm" name="password" id="password"></td>
								</tr>
								<tr>
									<td>Phone No</td>
									<td><input type="text" class="input-sm" name="phoneNo" value="${customer.phoneNo}"></td>
									<td>Mobile</td>
									<td><input type="text" class="input-sm" name="mobile" value="${customer.mobile}"></td>
								</tr>
								<tr>
									<td>Fax</td>
									<td><input type="text" class="input-sm" name="fax" value="${customer.fax}"></td>
									<td>Customer Type</td>
									<td><select name="customerType" id="customerType">
					  <option value="" label="Select Customer Type " />
					  <option value="Corporate">Corporate</option>
					  <option value="Individual">Individual</option>
					  </select></td>
								</tr>
								
							
							
		
			</table>			
		<input type="submit" value="Add" class="btn btn-primary btn-primary-spacing">
		<input type="reset" value="Clear" class="btn btn-primary btn-primary-spacing">
		<a href="getCustomer" class="btn btn-primary btn-primary-spacing">Get Customer</a>						
</form:form>
</div>
						
<h3 style="color:green">${success}</h3>
<h3 style="color:red">${error}</h3>
					</div>
				</div>
			</div>
			

		</div>
	</div>
</body>
</html>