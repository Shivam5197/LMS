<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css"
	rel="stylesheet" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link type="text/css" href="<c:url value="/Css/loginform.css"/>"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/templet/loaders.jsp"%>
<%@include file="/WEB-INF/views/Constants/Constatnt.jsp"%>

<meta charset="ISO-8859-1">
<title>LibraryManagement</title>
</head>
<body>
	<div class="container">
		<div class="card small" style="height: fit-content;
    width: max-content;
    margin: auto;
    margin-top: 25vh;
}">
			<form:form action="/Students/setPassword"
				modelAttribute="passwordset" method="POST">
				<!-- First row -->
				<div class="row">
					<div class="input-field col s6">
						<form:input id="password" path="password" type="password"
							class="validate" onkeyup='check()' />
						<label for="NewPassword">New Password</label>
					</div>
				</div>
				<!-- Second row container -->
				<div class="row">
					<div class="input-field col s6">
						<form:input id="confirm_password" type="text"
							class="validate" path="" onkeyup='check()'/>
						<label for="ConfirmPassword">Confirm Password</label>
					<span class="helper-text" id="message"></span>
					</div>
				</div>
				<!-- Submit button container -->
				<div class="text-right">
					<!-- text-right = text-align: right -->
					<input class="btn waves-effect waves-teal" type="submit"
						value="Submit">
				</div>
			</form:form>

		</div>
	</div>
	
	
	
<script>
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'Confirm Password Matched';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'Confirm Password is not matched ';
	  }
	}


</script>	
	
	
</body>
</html>