<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warranty Tracking</title>
<script
	src="<core:url value="/resources/bootstrap/js/jquery-3.1.1.min.js"/>"></script>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
	
<script>
function changeFunc(userName)
{
	
	$.ajax({
        url : 'ajaxtest?customerId='+userName,
        success : function(data) {
        
        	showDetails(data);
        },
        error:function(data,status,errorThrown){
        	alert("Error= "+errorThrown+" Status= "+status);
        	
        }
        
    });
}
function showDetails(data){
	
	$('#houseNo').val(data.houseNo);
	$('#society').val(data.society);
	$('#locality').val(data.locality);
	$('#city').val(data.city);
	$('#state').val(data.state);
	
}

</script>	
	
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/admin/header.jsp" />
	<div class="container-fluid">
		<div class="row">
		<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/admin/navlink.jsp" /></div>
		<div class="col-md-7">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="page-header ">
						<h3 align="center">Warranty Tracking</h3>
					</div>
					<div class="table-responsive">
					<form:form  action="warrantyAdd" method="post" modelattribute="warranty">
					
					<table class="table ">
					<tr>
					<td>Customer</td>
					<td><select  onchange="changeFunc(value);" name="customer">
					  <option value="" label="${warranty.customer}" />
					  <core:forEach items="${customerList}" var="customerDetails">
					  <option value="${customerDetails.userName}">${customerDetails.userName}</option>
					  </core:forEach>
					  </select> </td>
					  
					 
					<td>Doc Id</td>
					<td><input type="text" class="input-sm" name="docId" value="${warranty.docId}"  readonly></td>
					</tr>
					<tr>
					<td>House No</td>
					<td><input type="text" class="input-sm" id="houseNo" name="houseNo" value="${customerDetails.houseNo}" value="${warranty.houseNo}" readonly></td>
					<td>Doc Date</td>
					<td><input type="date" class="input-sm"  name="docDate" value="${warranty.docDate}" ></td>
					</tr>
					<tr>
					<td>Society</td>
					<td><input type="text" class="input-sm" id="society" name="society" value="${customerDetails.society}" readonly></td>
					<td>Locality</td>
					<td><input type="text" class="input-sm" id="locality" name="locality" value="${customerDetails.locality}" readonly></td>
					</tr>
					<tr>
					<td>City</td>
					<td><input type="text" class="input-sm" id="city" name="city" value="${customerDetails.city}" readonly></td>
					<td>State</td>
					<td><input type="text" class="input-sm" id="state" name="state" value="${customerDetails.state}" readonly></td>
					</tr>
					<tr>
					<td>Product Name</td>
					<td><select name="productName">
					  <option value="" label="${warranty.productName}" />
					  <core:forEach items="${productList}" var="productDetails">
					  <option value="${productDetails.productName}">${productDetails.productName}</option>
					  </core:forEach>
					  </select> </td>
					<td>Purchase Date</td>
					<td><input type="date" class="input-sm" name="purchaseDate" value="${warranty.purchaseDate}"></td>
					</tr>
					<tr>
					<td>Dispatch Date</td>
					<td><input type="date" class="input-sm" name="dispatchDate" value="${warranty.dispatchDate}"></td>
					<td>Equipment Sr. No</td>
					<td><input type="text" class="input-sm" name="eqtSrNo" value="${warranty.eqtSrNo}"></td>
					</tr>
					<tr>
					<td></td>
					<td></td>
					<td>Mgr Sr.No</td>
					<td><input type="text" class="input-sm" name="mgrSrNo" value="${warranty.mgrSrNo}"></td>
					</tr>
					<tr>
					<td>Install Date</td>
					<td><input type="date" class="input-sm" name="installDate" value="${warranty.installDate}"></td>
					<td>New Warranty Date</td>
					<td><input type="text" class="input-sm" name="newWarrenty" value="${warranty.newWarrenty}"></td>
					</tr>
					<tr>
					<td>Gross Exp</td>
					<td><input type="text" class="input-sm" name="grossExp" value="${warranty.grossExp}"></td>
					<td>Expiry Date</td>
					<td><input type="text" class="input-sm" name="expiryDate" value="${warranty.expiryDate}"></td>
					</tr>
					
					</table>
					
					<input type="submit" value="Save" class="btn btn-primary btn-primary-spacing"> 
		<input type="reset" value="Clear" class="btn btn-primary btn-primary-spacing" >						
<a href="getWarranty"  class="btn btn-primary btn-primary-spacing">Show Warranty</a>
</form:form>
					</div>
					<h3 style="color: green">${success}</h3>
					<h3 style="color: red">${error}</h3>
				</div>
			</div>
		</div>
		<div class="col-md-2"></div>
		</div>
	</div>

</body>
</html>