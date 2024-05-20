<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Book</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body style="background-color: #f0f1f2;">

<c:if test="${empty userobj }">

<c:redirect  url="login.jsp"/>

</c:if>

	<%@include file="all_component/navbar.jsp"%>


	<div class="container">
		<div class="row mt-3">
			<div class="col-md-4 offset-md-4">
				<div class="card">

					<div class="card-body">
						<h5 class="text-center text-primary p-1">Sell Old Books</h5>
						
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty failedMsg}">
							<p class="text-center text-success">${failedMsg}</p>
							<c:remove var="failedMsg" />
						</c:if>
						
						
						<form action="add_old_book" method="post"
							enctype="multipart/form-data">

							<input type="hidden" value="${userobj.email }" name="user">

    
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



							<div class="form-check">
								<label for="exampleCheckFile1">Upload Photo</label> <input
									type="file" class="form-control-file" name="bimg"
									id="exampleCheckFile1">

							</div>
							<button type="submit" class="btn btn-primary mt-3">Sell</button>

						</form>
					</div>
				</div>
			</div>
		</div>


	</div>

</body>
</html>