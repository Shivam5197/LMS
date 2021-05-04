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
<title>Insert title here</title>
</head>
<body>
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
        &copy; Add new Book
      </span>
  </a>
  <!-- Navbar content with sign up button -->
  <div class="navbar-content">
<!--     <button class="btn btn-primary" type="button">Sign up</button> -->
  </div>
</nav>

<div class="w-800 mw-full" style="background-color: #f3f2ed;"> <!-- w-400 = width: 40rem (400px), mw-full = max-width: 100% -->
  <div class="card shadow-lg">
    <h2 class="card-title">
    Add new Book 
    </h2>

<form:form action="/BookManagement/saveBooks" modelAttribute="bookForm"  method="POST">

<c:set var="error">
					<form:errors path="bookForm.*" />
				</c:set>
				<c:if test="${error ne null && error ne '' }">
					<div class="alert alert-danger" role="alert">
						<form:errors path="bookForm.*" />
					</div>
				</c:if>


	  <!-- Hidden For Update Books  -->
   <form:input type="hidden" path="id" />
  <!-- First row -->
  <div class="form-row row-eq-spacing-sm">
    <div class="col-sm">
      <label for="first-name" class="required">Book Name</label>
      <form:input type="text" path="bookName" class="form-control" id="bookName" placeholder="Book Name" required="required" />
    </div>
    <div class="col-sm">
      <label for="last-name" class="required">Publish House</label>
      <form:input type="text" path="bookPublisherName" class="form-control" id="PublishHouse" placeholder="PublishHouse"/>
    </div>
  </div>

  <!-- Second row container -->
  <div class="form-row row-eq-spacing-sm">
    <div class="col-sm">
      <label for="first-name" class="required">Language </label>
      <form:input type="text" path= "bookLanguage"  class="form-control" id="language" placeholder="Language" required="required" />
    </div>
    <div class="col-sm">
      <label for="last-name" class="required">Book Description</label>
			<form:textarea class="form-control" placeholder="Book Description" path = "bookDescription" rows = "5" cols = "30" />
   </div>
  </div>

  <!-- Third row container -->
  <div class="form-row row-eq-spacing-sm">
    <div class="col-sm-2">
      <label for="first-name" class="required">Books In stock</label>
      <form:input type="number" path= "bookInStock"  class="form-control" id="inStock" required="required" />
    </div>
  </div>
  <!-- Submit button container -->
  <div class="text-right"> <!-- text-right = text-align: right -->
    <input class="btn btn-primary" type="submit" value="Add Book">
  </div>
</form:form>

</div>
</div>

<hr class="black-hr shadow-lg">
<a href="/BookManagement/list" class="btn">Back to Books List</a>
<hr class="black-hr shadow-lg">


</body>
</html>