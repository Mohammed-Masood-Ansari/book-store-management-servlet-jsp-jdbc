<%@page import="com.jsp.EbookMangement.entity.User"%>
<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All recent Page</title>
<%@include file="all_component/allCss.jsp"%>

</head>
<body>
<%
	User u = (User)session.getAttribute("userobj");
	%>

	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">

		<div class="row">

			<%
			BookDao dao2 = new BookDao();

			List<BookDtls> list1 = dao2.getAllRecentBookDisplayDao();

			for (BookDtls bookDtls1 : list1) {
			%>

			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">

						<img alt="" src="book/<%=bookDtls1.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=bookDtls1.getBookname()%></p>
						<p><%=bookDtls1.getAuthor()%></p>
						<p>


							<%
							if (bookDtls1.getBookCategory().equals("Old")) {
							%>

							Categories:<%=bookDtls1.getBookCategory()%></p>
						<div class="row">


							<a href="view_book.jsp?bid=<%=bookDtls1.getBookId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=bookDtls1.getPrice()%><i
								class="fas fa-rupee-sign"></i></a>

						</div>

						<%
						} else {
						%>
						Categories:<%=bookDtls1.getBookCategory()%></p>
						<div class="row">
							<%
							if (u == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1"><i
								class="fas fa-cart-plus"></i>Add Cart</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=bookDtls1.getBookId()%>"
								class="btn btn-danger btn-sm "><i class="fas fa-cart-plus"></i>Add
								Cart</a>
							<%
							}
							%>

							<a href="view_book.jsp?bid=<%=bookDtls1.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><%=bookDtls1.getPrice()%><i
								class="fas fa-rupee-sign"></i></a>

						</div>

						<%
						}
						%>


					</div>
				</div>
			</div>
			<%
			}
			%>


		</div>
	</div>

</body>
</html>