<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Add Books</title>

<%@include file="allCss.jsp"%>

</head>
<body style="background-color: #f0f2f2;">
	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">

		<div class="row">
			<div class=" col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-warning">Add Books</h4>
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty failedMsg}">
							<p class="text-center text-success">${failedMsg}</p>
							<c:remove var="failedMsg" />
						</c:if>

						<form action="../add_books" method="post"
							enctype="multipart/form-data">

							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="author">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input type="tel"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="price">

							</div>



							<div class="form-group">
								<label for="inputState">Book Categories</label> <select
									class="form-control" id="inputState" name="categories">
									<option selected="selected">---select---</option>
									<option value="New">New Book</option>
								</select>
							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									class="form-control" id="inputState" name="status">
									<option selected="selected">---select---</option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
								</select>
							</div>
							<div class="form-check">
								<label for="exampleCheckFile1">Upload Photo</label> <input
									type="file" class="form-control-file" name="bimg"
									id="exampleCheckFile1">

							</div>
							<button type="submit" class="btn btn-primary mt-3">Add</button>

						</form>




					</div>
				</div>
			</div>

		</div>




	</div>
</body>
</html>