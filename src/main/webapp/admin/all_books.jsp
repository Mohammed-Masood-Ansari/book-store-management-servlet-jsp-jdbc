<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>
<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin:All Books</title>
<%@include file="allCss.jsp"%>

</head>
<body>
	<%@include file="navbar.jsp"%>
	
	 <c:if test="${empty userobj }">
     <c:redirect url="../login.jsp"/>
     </c:if>
	<h3 class="text-center">Welcome To Admin All Book</h3>
	<%
	BookDao dao = new BookDao();
	
	List<BookDtls> details=dao.displayAllBookDao();
	%>
	<c:if test="${not empty succMsg}">
		<p class="text-center text-success">${succMsg}</p>
		<c:remove var="succMsg" />
	</c:if>

	<c:if test="${not empty failedMsg}">
		<p class="text-center text-danger">${failedMsg}</p>
		<c:remove var="failedMsg" />
	</c:if>
	<table class="table">
		<thead class="bg-primary text-white">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Image</th>
				<th scope="col">Book Name</th>
				<th scope="col">Author</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Action</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (BookDtls b : details) {
			%>
			<tr>
				<th><%=b.getBookId()%></th>
				<td><img alt="" src="../book/<%=b.getPhotoName()%>"
					style="width: 50px; height: 50px;"></td>
				<td><%=b.getBookname()%></td>
				<td><%=b.getAuthor()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getBookCategory()%></td>
				<td><%=b.getStatus()%></td>

				<td class="d-flex flex-row bd-highlight mb-3"><a
					href="edit_books.jsp?id=<%=b.getBookId()%>"
					class="btn btn-sm btn-primary"><i class="fas fa-edit"></i>Edit</a>

					<form method="post" action="../delete?id=<%=b.getBookId()%>">
						<button type="submit" class="btn btn-sm btn-danger ml-1">
							<i class="far fa-trash-alt"></i>Delete
						</button>
					</form></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>