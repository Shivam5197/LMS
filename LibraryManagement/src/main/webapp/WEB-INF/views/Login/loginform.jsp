<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" href="<c:url value="/Css/loginform.css"/>" rel="stylesheet">

<%@include file="/WEB-INF/views/templet/loaders.jsp" %>
<%@include file="/WEB-INF/views/Constants/Constatnt.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
<meta charset="ISO-8859-1">
<title>LibraryManagementSystem</title>
<style>
</style>

</head>
<body>
	<div class="container">
		<div class="card large s12" style="margin-top: 12vh; background-color: #F5F5F5;" >
			<div class="row">
				<div class="col s6">
		<img src="<c:url value="/img/StaticImages/login.jpg"/>" title=""
				class="loginImage" alt="">

				</div>
				
				<div class="col s6 formLogin">

					<div class="card loginCard">
						<h2 class="card-title center-align"><em>Login</em></h2>

						<form:form action="/login/validateLogin"
							modelAttribute="mainLogin" method="POST">

					<c:if test="${not empty error}">
					<div class="alert alert-danger" role="alert">
						<h5 class="alert-heading">Login Failed</h5>
						<hr>
						<p>${error}</p>
					</div>
				</c:if>
							<!-- First row -->
							<div class="row">
								<div class="input-field col s6">
									<form:input id="last_name" path="userName" type="text"
										class="validate" />
									<label for="last_name">Last Name</label>
								</div>
							</div>

							<!-- Second row container -->
							<div class="row">
								<div class="input-field col s6">
									<form:input id="password" path="password" type="password"
										class="validate" />
									<label for="password">Password</label>
								</div>
							</div>
							<!-- Submit button container -->
							<div class="text-right">
								<!-- text-right = text-align: right -->
								<input class="btn waves-effect waves-teal" type="submit" value="Login">
							</div>
						</form:form>
						<hr>
<!-- 						<a href="/library/home" >Not a User </a> -->
				<p style="font-size: 13px;">Not registered yet?? <a href="/library/home" >Register Here </a></p>
					</div>

				</div>
			</div>
		</div>

	</div>
</body>
</html>