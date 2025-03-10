

<%@page import="com.jsp.EbookMangement.entity.User"%>
<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>
<%@page import="com.jsp.EbookMangement.DB.DBConnect"%>
<%@page errorPage="error_page.jsp"%>
<%@page import="java.sql.Connection"%>
<%-- <%@page import="com.ebook.Ebook_App.DB.*"%>
 --%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook:Index</title>

<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/b.jpg");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body style="background-color: #f7f7f7;">

	<%
	User u = (User)session.getAttribute("userobj");
	%>


	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid back-img">

		<h2 class="text-center text-sucess text-bold">ONLINE-BOOK-STORE</h2>
 
	</div>



	<hr>

	<!-- Start New Book -->


	<div class="container">

		<h3 class="text-center">New Book</h3>

		<div class="row">

			<%
			BookDao dao = new BookDao();

			List<BookDtls> list = dao.getNewBookDisplayDao();

			for (BookDtls bookDtls : list) {
			%>
			<div class="col-md-3">

				<div class="card crd-ho">
					<div class="card-body text-center">

						<img alt="" src="book/<%=bookDtls.getPhotoName()%>"
							style="width: 150px; height: 200px">
						<p><%=bookDtls.getBookname()%></p>
						<p><%=bookDtls.getAuthor()%></p>
						<p>
							Categories:<%=bookDtls.getBookCategory()%></p>
						<div class="row">

							<%
							if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fas fa-cart-plus"></i>Add
								Cart</a>
							<%
							} else {
							%>

							<a href="cart?bid=<%=bookDtls.getBookId() %>" class="btn btn-danger btn-sm "><i
								class="fas fa-cart-plus"></i>Add
								Cart</a>

							<%
							}
							%>
							<a href="view_book.jsp?bid=<%=bookDtls.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm  "><%=bookDtls.getPrice()%> <i
								class="fas fa-rupee-sign"></i></a>

						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>

		<div class="text-center mt-1">
			<a href="all_new_book.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>
	</div>

	<!--End New Book  -->



	<hr>
	<!-- Start Old Book -->

	<div class="container">

		<h3 class="text-center">Old Book</h3>

		<div class="row">

			<%
			BookDao dao3 = new BookDao();

			List<BookDtls> list2 = dao3.getOldBookDisplayDao();

			for (BookDtls bookDtls3 : list2) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">

						<img alt="" src="book/<%=bookDtls3.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=bookDtls3.getBookname()%></p>
						<p><%=bookDtls3.getAuthor()%></p>
						<p><%=bookDtls3.getBookCategory()%></p>

						<div class="row">

							<a href="view_book.jsp?bid=<%=bookDtls3.getBookId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><%=bookDtls3.getPrice()%> <i
								class="fas fa-rupee-sign"></i></a>

						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>

		<div class="text-center mt-1">
			<a href="all_old_book.jsp" class="btn btn-danger btn-sm text-white">View
				All</a>
		</div>

	</div>

	<!--End Old Book  -->

	<%@include file="all_component/footer.jsp"%>

</body>
</html>





