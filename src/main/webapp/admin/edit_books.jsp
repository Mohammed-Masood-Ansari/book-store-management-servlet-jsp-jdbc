<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:Edit Books</title>
<%@include file="allCss.jsp"%>

</head>
<body style="background-color: #f0f2f2">
	<%@include file="navbar.jsp"%>

	<div class="container">

		<div class="row">
			<div class=" col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-warning">Update Books</h4>
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						/* System.out.println(id); */
						BookDao dao = new BookDao();
						BookDtls b = dao.getBookDetailsById(id);
						/* System.out.println(b.getBookId()); */ 
						%>
						<form action="../Edit_Books" method="post">
                          <input type="text" name="Id" value="<%=b.getBookId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="bname"
									value="<%=b.getBookname()%>">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="author"
									value="<%=b.getAuthor()%>">

							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input type="tel"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="price"
									value="<%=b.getPrice()%>"> 

							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									class="form-control" id="inputState" name="bstatus">
									<%
									if ("Active".equals(b.getStatus())) {
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<%
									} else {
									%>
									<option value="Inactive">Inactive</option>
									<option value="Active">Active</option>
									<%
									}
									%>
								</select>
                             </div>
								<button type="submit" class="btn btn-primary mt-3">Update</button>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
</body>

</html>