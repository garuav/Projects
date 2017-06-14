<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="<core:url value="/resources/bootstrap/js/jquery-3.1.1.min.js"/>"></script>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
	<script
	src="<core:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script>
	var count = 1;
	function addRow() {
		
		count = $('#spareAdd tr').length - 1;
		
		var nameSpare = document.getElementById("nameSpare").value
		var quantitySpare = document.getElementById("quantitySpare").value
		var requireDateSpare = document.getElementById("requireDateSpare").value
		
		$('#spareAdd')
				.append(
						'<tr id='+count+'><td><input type="text" class="input-sm" name="spr['+count +'].srNo" value='+count+' id="txtSrNo['+count+']"></td><td><input type="text" class="input-sm"  name="spr['+count+'].nameSpare"  value="'+nameSpare+'"></td><td><input type="text" class="input-sm"  name="spr['+count+'].quantitySpare"  value="'+quantitySpare+'"></td><td><input type="date" class="input-sm" name="spr['+count+'].requireDateSpare"  value="'+requireDateSpare+'"></td><td onclick="removeRow('
								+ count + ')"><a href="#">-</a></td></tr> ');
		count++;
	}
	function removeRow(row) {
		var del = "table#spareAdd tr#" + row;
		$(del).remove();
		var rowCount = $('#spareAdd tr').length;
		var srNo = row;
		for (var i = row + 1; i < rowCount; i++) {
			document.getElementById("txtSrNo[" + i + "]").value = srNo;
			srNo++;
		}
		count--;

	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/engineer/header.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"><jsp:include page="/WEB-INF/jsp/engineer/navlink.jsp" /></div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Spare Require</h3>
						</div>
						<div class="table-responsive">
							<form:form action="spareRequire" modelattribute="spare" method="post">
								<table class="table">
									<tr>
										<td>Required Id</td>
										<td><input type="text" name="requireId" class="input-sm" value="${require.requireId}" readonly></td>
										<td>Required Entry Date</td>
										<td><input type="date" name="requireEntryDate"
											class="input-sm"></td>
									</tr>
									<tr>
										<td>Engineer Name</td>
										<td><input type="text" name="engName" class="input-sm"></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td colspan="1"></td>
										<td colspan="3">
											<table class="table" id="spareAdd">
												<tr>

													<th>Sr No</th>
													<th>Spare Name</th>
													<th>Quantity</th>
													<th>Require Date</th> 
												</tr>
												<tr>
													<td><input type="text" class="input-sm" id="srNo"></td>

													<td><input type="text" class="input-sm" id="nameSpare"></td>
													<td><input type="text" class="input-sm" id="quantitySpare"></td>
													<td><input type="date" class="input-sm" id="requireDateSpare"></td>
													<td><a href="#" onclick="addRow()">+</a></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<input type="submit" value="Add" class="btn btn-info btn-primary-spacing"> 
		<input type="reset" value="Clear" class="btn btn-info btn-primary-spacing" >
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