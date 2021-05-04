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

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<body>


<!-- Navbar with content justified between -->
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
        &copy; List of Students in University
      </span>
  </a>
  <!-- Navbar content with sign up button -->
  <div class="navbar-content">
<!--     <button class="btn btn-primary" type="button">Sign up</button> -->
  </div>
</nav>


<div class="container-fluid my-10">
<div class="row">
    <div class="col-2">
    <a href="/Students/studentFormShow" class="btn"><b>Add new Student</b></a>
    
    </div>
    <div class="col-10">

				<table class="display" id="table_id">
					<thead>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th class="text-center">Email Address</th>
							<th class="text-center">Course</th>
							<th class="text-center">Date Of Birth</th>
							<th class="text-right"></th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="student" items="${students}">

							<c:url var="updateStudent" value="/Students/updateShowForm">
								<c:param name="studentId" value="${student.id}"></c:param>
							</c:url>
							<c:url var="borrowBook" value="/Students/showBookList">
								<c:param name="studentId" value="${student.id}"></c:param>
							</c:url>

							<c:url var="deleteStudent" value="/Students/deleteStudent">
								<c:param name="studentId" value="${student.id}"></c:param>
							</c:url>
							<c:url var="viewBooks" value="/Students/viewBooks">
								<c:param name="studentId" value="${student.id}"></c:param>
							</c:url>


							<c:set var="course" scope="session" value="${student.course}" />

							<tr>
								<td>${student.id}</td>
								<td><a href="${viewBooks}">${student.firstName}</a></td>
								<td>${student.lastName}</td>
								<td>${student.email}</td>
								<td>
								<c:choose>
										<c:when test="${course == 1}">  
    														MCA </c:when>
										<c:when test="${course == 2}">  
     														BCA</c:when>
										<c:when test="${course == 3}">  
															B.tech </c:when>
										<c:otherwise>  
      														M.tech </c:otherwise>
									</c:choose>
									</td>
								<td>${student.dateOfBirth}</td>
								<td class="text-right">
								<a href="${borrowBook}" class="btn btn-primary" type="button">Issue Book</a> 
								<a href="${updateStudent}" class="btn btn-primary" type="button">Update</a> 
								<a href="${deleteStudent}" class="btn btn-danger" type="button">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
					<a class="btn" data-toggle="dropdown" href="/library/home"
						type="button" id="navbar-fixed-bottom-dropdown-toggle"> Back
						Home </a>
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