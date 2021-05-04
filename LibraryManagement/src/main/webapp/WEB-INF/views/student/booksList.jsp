<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <jsp:include page="Constants/Constatnt.jsp" /> --%>
<%@include file="/WEB-INF/views/Constants/Constatnt.jsp" %>
<%@include file="/WEB-INF/views/templet/loaders.jsp" %>

<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>LibraryManagement</title>
</head>
<body>
<nav class="navbar justify-content-between"> <!-- justify-content-between = justify-content: space-between -->
  <!-- Navbar content with menu button -->
  <div class="navbar-content">
  <span class="navbar-text"> <!-- ml-auto = margin-left: auto -->
	Operations 
      </span>
  </div>
  <!-- Navbar brand -->
  <a href="#" class="navbar-brand">
  <span class="navbar-text"> <!-- ml-auto = margin-left: auto -->
        &copy; List of Books in Library
      </span>
  </a>
  <!-- Navbar content with sign up button -->
  <div class="navbar-content">
<!--     <button class="btn btn-primary" type="button">Sign up</button> -->
  </div>
</nav>


<div class="container-fluid my-10">
<div class="row">

			<div class="col-12">
  <div class="card shadow-lg">

				<table class="display" id="table_id">
					<thead>
						<tr>
<!-- 							<th>ID</th> -->
							<th>Book Name</th>
							<th>Publisher's Name</th>
							<th class="text-center" style=" max-width: 15px;">Book Description</th>
							<th class="text-center">Book Language</th>
							<th class="text-center">In stocks</th>
							<th class="text-right"></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="books" items="${booksForstudent}">

 							<c:url var="IssueBook" value="/Students/IssueBook">
								<c:param name="bookId" value="${books.id}"></c:param>
							</c:url>
<%--							<c:url var="deleteBook" value="/BookManagement/deleteBook">
								<c:param name="bookId" value="${books.id}"></c:param>
							</c:url>
 --%>
<%-- 							<c:set var="course" scope="session" value="${student.course}" /> --%>

							<tr>
<%-- 								<td class="text-center">${books.id}</td> --%>
								<td class="text-center">${books.bookName}</td>
								<td class="text-center">${books.bookPublisherName}</td>
								<td class="text-center" style=" max-width: 14vw;">${books.bookDescription}</td>
								<td class="text-center">${books.bookLanguage}</td>
								<td class="text-center">${books.bookInStock}</td>
								
								<td class="text-right"><a href="${IssueBook}"
									class="btn btn-primary" type="button">Issue Book</a>
<%-- 									 <a href="${deleteBook }" class="btn btn-danger" type="button">Delete</a> --%>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
  </div>

</div>


  <!-- Page wrapper with .with-navbar-fixed-bottom class -->
  <div class="page-wrapper with-navbar-fixed-bottom">
    <!-- Content wrapper -->
    <div class="content-wrapper">
    </div>

    <!-- Navbar fixed bottom (immediate child of the page wrapper) -->
    <nav class="navbar navbar-fixed-bottom">
      <!-- Navbar content with the dropup menu -->
      <div class="navbar-content">
        <div class="dropdown dropup with-arrow">
          <a class="btn" data-toggle="dropdown" href="/library/home" type="button" id="navbar-fixed-bottom-dropdown-toggle">
            Back Home
          </a>
        </div>
      </div>
      <!-- Navbar brand -->
      <a href="#" class="navbar-brand ml-auto"> <!-- ml-auto = margin-left: auto -->
      <span class="navbar-text"> <!-- ml-auto = margin-left: auto -->
        &copy; Version 0.0.1
      </span>
      </a>
      <!-- Navbar text -->
      <span class="navbar-text ml-auto"> <!-- ml-auto = margin-left: auto -->
        &copy; Library Management System
      </span>
    </nav>
  </div>

  <!-- Requires halfmoon.js for the dropdown -->
  <script src="path/to/halfmoon.js"></script>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>

<script>
$(document).ready( function () {
    $('#table_id').DataTable();
    console.log("Hello");
} );</script>



</body>
</html>