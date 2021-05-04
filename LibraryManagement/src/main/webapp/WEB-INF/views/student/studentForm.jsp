<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/templet/loaders.jsp" %>
<%@include file="/WEB-INF/views/Constants/Constatnt.jsp" %>


<meta charset="ISO-8859-1">
<title>LibraryManagement</title>
</head>
<body>
<!-- Navbar with content justified between -->
<nav class="navbar justify-content-between"> <!-- justify-content-between = justify-content: space-between -->
  <!-- Navbar content with menu button -->
  <div class="navbar-content">
  <span class="navbar-text"> <!-- ml-auto = margin-left: auto -->
	 
      </span>
  </div>
  <!-- Navbar brand -->
  <a href="#" class="navbar-brand">
  <span class="navbar-text"> <!-- ml-auto = margin-left: auto -->
        &copy; Add a new Student 
      </span>
  </a>
  <!-- Navbar content with sign up button -->
  <div class="navbar-content">
<!--     <button class="btn btn-primary" type="button">Sign up</button> -->
  </div>
</nav>

<div class="w-800 mw-full"> <!-- w-400 = width: 40rem (400px), mw-full = max-width: 100% -->
  <div class="card">
    <h2 class="card-title">
     Add new Student
    </h2>

<form:form action="/Students/sendPasswordMail" modelAttribute="studentFormData"  method="POST">

				<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">
						<h5 class="alert-heading">Failed to Save</h5>
						<hr>
						<p>${error}</p>
					</div>
				</c:if>

<!-- Hidden For Update employee  -->
   <form:input type="hidden" path="id" />
  <!-- First row -->
  <div class="form-row row-eq-spacing-sm">
    <div class="col-sm">
      <label for="first-name" class="required">First name</label>
      <form:input type="text" path="firstName" class="form-control" id="first-name" placeholder="First name" required="required" />
    </div>
    <div class="col-sm">
      <label for="last-name" class="required">Last name</label>
      <form:input type="text" path="lastName" class="form-control" id="last-name" placeholder="Last name"/>
    </div>
  </div>

  <!-- Second row container -->
  <div class="form-row row-eq-spacing-sm">
    <div class="col-sm">
      <label for="first-name" class="required">Email</label>
      <form:input type="email" path= "email"  class="form-control" id="Email" placeholder="Email" required="required" />
    </div>
    <div class="col-sm">
      <label for="last-name" class="required">Date of Birth</label>
		 <form:input type="date" path="dateOfBirth" id="birthday" class="form-control" name="birthday" />
   </div>
  </div>

  <!-- Third row container -->
    <div class="form-row row-eq-spacing-sm">
    <div class="col-sm">
      <label for="first-name" class="required">UserName</label>
      <form:input type="text" path= "userName"  class="form-control" id="userName" placeholder="userName" required="required" />
      <form:errors path="userName" /> 
    </div>
    <div class="col-sm">
      <label for="last-name" class="required">Password</label>
		 <form:input type="text" path="password" id="password" class="form-control" name="password" />
   </div>
  </div>
  
  <!-- Fourth row container -->

				<div class="form-row row-eq-spacing-sm">
					<div class="col-sm-4">

						<label for="state" class="required">Course</label>
						<form:select class="form-control" path="course" id="state"
							required="required">
							<form:option selected="selected" value="${None}">None</form:option>
							<form:option value="${MCA}">MCA</form:option>
							<form:option value="${BCA}">BCA</form:option>
							<form:option value="${BTECH}">B.tech</form:option>
							<form:option value="${MTECH}">M.tech</form:option>
						</form:select>
					</div>

					<div class="col-sm-4">
						<label for="multi-select-1">Role</label>
						<form:select class="form-control" path="userType" id="state"
							required="required">
							<form:option value="${Student}">Student</form:option>
							<form:option value="${Library_Manager}">Library Manager</form:option>
						</form:select>

					</div>
				</div>

  <!-- Submit button container -->
  <div class="text-right"> <!-- text-right = text-align: right -->
    <input class="btn btn-primary" type="submit" value="Add Student">
  </div>
</form:form>

<hr>

<p>Already a User <a  href="/login/loginForm">Login</a> Here</p>

<a href="/library/home" class="btn">Home</a>


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
          <button class="btn" data-toggle="dropdown" type="button" id="navbar-fixed-bottom-dropdown-toggle">
            Get Support
            <i class="fa fa-angle-up" aria-hidden="true"></i>
          </button>
          <div class="dropdown-menu" aria-labelledby="navbar-fixed-bottom-dropdown-toggle">
            <a href="#" class="dropdown-item">Tutorials</a>
            <a href="#" class="dropdown-item">Examples</a>
            <div class="dropdown-divider"></div>
            <a href="#" class="dropdown-item">Support</a>
            <a href="#" class="dropdown-item">Contact us</a>
          </div>
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


</body>
</html>