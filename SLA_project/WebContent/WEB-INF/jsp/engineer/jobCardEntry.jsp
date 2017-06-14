<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Master</title>
<link href="<core:url value="/resources/bootstrap/css/bootstrap.css" />"
	rel="stylesheet">
<link href="<core:url value="/resources/bootstrap/css/myStlye.css" />"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/engineer/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"><jsp:include
					page="/WEB-INF/jsp/engineer/navlink.jsp" /></div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header ">
							<h3 align="center">Job Card Entry</h3>
						</div>
						<div class="table-responsive">
							<form:form action="#" method="post" modelAttribute="complaint">
								<table class="table">
									<tr>
										<td>Customer Name</td>
										<td><input type="text" class="input-sm"
											name="customerName"></td>
										<td>Job Card Id</td>
										<td><input type="text" class="input-sm" name="jobCardId"></td>
										<td>Ticket Id </td>
										<td><select  onchange="changeFunc(value);">
					  <option value="" label="Select Ticket Id" />
					  <core:forEach items="${ticketList}" var="ticketdetails">
					  <option value="${ticketdetails.ticketId}">${ticketdetails.ticketId}</option>
					  </core:forEach>
					  </select> </td>
									</tr>
									<tr>
										<td>House No</td>
										<td><input type="text" class="input-sm" name="houseNo"></td>
										<td></td>
										<td></td>
										<td>Date</td>
										<td><input type="date" class="input-sm" name="date"></td>
									</tr>
									<tr>
										<td>Society</td>
										<td><input type="text" class="input-sm" name="society"></td>
										<td>Engineer Name</td>
										<td><input type="text" class="input-sm"
											name="engineerName"></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>Locality</td>
										<td><input type="text" class="input-sm" name="locality"></td>
										<td>Complaint Status</td>
										<td><input type="text" class="input-sm" name=""></td>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td>City</td>
										<td><input type="text" class="input-sm" name="city"></td>
										<td>State</td>
										<td><input type="text" class="input-sm" name="state"></td>
										<td>Status</td>
										<td><input type="text" class="input-sm" name="status"></td>
									</tr>
									<tr>
										<td colspan="6">
											<table class="table">
												<tr>
													<th>Sr No</th>
													<th>Spare Name</th>
													<th>Quantity</th>
													<th>Replace Date</th>
													<th>Rate</th>
													<th>Remark</th>
													<th>Plus</th>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td colspan="2">UPS at receive Stage</td>
										<td colspan="4"><textarea rows="" cols="50" name=""></textarea></td>
									</tr>
									<tr>
										<td colspan="2">Problem Solve Description</td>
										<td colspan="4"><textarea rows="" cols="50" name=""></textarea></td>
									</tr>
								</table>
								<input type="submit" value="Add"
									class="btn btn-primary btn-primary-spacing">
								<input type="reset" value="Clear"
									class="btn btn-primary btn-primary-spacing">
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>