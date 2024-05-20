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
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">

		<div class="row p-3">

			<%
			BookDao dao = new BookDao();

			List<BookDtls> list = dao.getAllOldBookDisplayDao();

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
							<a href="view_book.jsp?bid=<%=bookDtls.getBookId()%>"
								class="btn btn-success btn-sm ml-5">View Details</a> <a href=""
								class="btn btn-danger btn-sm "><%=bookDtls.getPrice()%> <i
								class="fas fa-rupee-sign"></i></a>

						</div>
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