<%@page import="com.jsp.EbookMangement.entity.User"%>
<%@page import="com.jsp.EbookMangement.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.EbookMangement.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All recent Page</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
/* toast */
#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeOut 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeOut {form { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}

/* toast */
</style>
</head>
<body>
     <%
	User u = (User)session.getAttribute("userobj");
	%>
 	<c:if test="${not empty addCart }">

		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
</script>

		<c:remove var="addCart" scope="session" />
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">

		<div class="row p-3">

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
							<a href="login.jsp" class="btn btn-danger btn-sm"><i
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
							<a href="" class="btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class="btn btn-danger btn-sm "><%=bookDtls.getPrice()%>
								<i class="fas fa-rupee-sign"></i></a>

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