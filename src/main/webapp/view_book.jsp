<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>


	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BookDao bookDao = new BookDao();
	BookDtls bookDtls = bookDao.getBookDetailsById(bid);
	%>



	<div class="container p-3">

		<div class="row">
			<div class="col-md-6 text-center p-5 border bg-white">

				<img alt="" src="book/<%=bookDtls.getPhotoName()%>"
					style="height: 150px; width: 150px"><br>
				<h4 class="mt-3">
					Book: Name:<span class="text-success"><%=bookDtls.getBookname()%></span>
				</h4>
				<h4>
					Author Name:<span class="text-success"><%=bookDtls.getAuthor()%></span>
				</h4>
				<h4>
					Category:<span class="text-success"><%=bookDtls.getBookCategory()%></span>
				</h4>
			</div>

			<div class="col-md-6 text-center p-5 border bg-white">


				<h2><%=bookDtls.getBookname()%></h2>

				<%
				if ("Old".equals(bookDtls.getBookCategory())) {
				%>
				<h5 class="text-primary">Contact To Seller</h5>
				<h5 class="text-primary">
					<i class="far fa-envelope"></i>Email:<%=bookDtls.getEmail()%></h5>

				<%
				}
				%>


				<div class="row">

					<div class="col-md-4 text-danger text-center p2">
						<i class="fas fa-money-bill-wave fa-2x"></i>
						<p>Cash on Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p2">
						<i class="fas fa-undo-alt fa-2x"></i>
						<p>return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p2">
						<i class="fas fa-truck-moving fa-2x"></i>
						<p>Free Delivery</p>
					</div>


				</div>

				<%
				if ("Old".equals(bookDtls.getBookCategory())) {
				%>
				<div class="text-center p-3">
					<a href="index.jsp" class="btn btn-success"><i class="fas fa-cart-plus"></i>
						Continue Shopping</a> <a href="" class="btn btn-danger"><i
						class="fas fa-rupee-sign"></i> 200</a>

				</div>

				<%
				} else {
				%>

				<div class="text-center p-3">
					<a href="" class="btn btn-primary"><i class="fas fa-cart-plus"></i>
						Add Cart</a> <a href="" class="btn btn-danger"><i
						class="fas fa-rupee-sign"></i> 200</a>

				</div>


				<%
				}
				%>


			</div>
		</div>
	</div>

</body>
</html>