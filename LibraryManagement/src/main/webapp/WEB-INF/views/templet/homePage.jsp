<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
<link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/Constants/Constatnt.jsp" %>
<%@include file="/WEB-INF/views/templet/loaders.jsp" %>
<link type="text/css" href="<c:url value="/Css/mainPage.css"/>" rel="stylesheet">
 
<meta charset="ISO-8859-1">
<title>Library Management</title>
</head>

<body class=" with-custom-webkit-scrollbars with-custom-css-scrollbars" data-dm-shortcut-enabled="true" data-sidebar-shortcut-enabled="true">

    <!-- Page wrapper start -->
    <div id="page-wrapper" class="page-wrapper  with-navbar with-sidebar with-navbar-fixed-bottom" data-sidebar-hidden="hidden" >

        <!-- Sticky alerts -->
        <div class="sticky-alerts"></div>

       <!-- Navbar start -->
        <nav class="navbar">
<!--         <a href="/Students/list" class="btn"> Manage Students</a>
		<a href="/BookManagement/list" class="btn"> Manage Books</a>
 -->
 			   <a href="/Students/studentFormShow" class="btn">Register</a>
 
            <div class="navbar-content ml-auto">
                <button class="btn btn-action mr-5" type="button" onclick="halfmoon.toggleDarkMode()">
                    <i class="fa fa-moon-o" aria-hidden="true"></i>
                    <span class="sr-only">Toggle dark mode</span>
                </button>
            </div>
        </nav>
        <!-- Navbar end -->

        <!-- Sidebar overlay -->
        <div class="sidebar-overlay" onclick="halfmoon.toggleSidebar()"></div>

        <!-- Sidebar start -->
		<div class="sidebar">
			<div class="my-card card">
				<div class="my-card-header">
					<h5 class="card-title">Please Provide your feedback</h5>
				</div>
				<hr>

				<form action="..." method="..." class="w-400 mw-full">
					<!-- w-400 = width: 40rem (400px), mw-full = max-width: 100% -->
					<div class="form-group">
						<label for="username" class="required">Email</label> <input
							type="email" class="form-control" id="username"
							placeholder="Email" required="required">
					</div>

					<div class="form-group">
						<label for="password" class="required">Your Comments</label>
						<textarea class="form-control"
							placeholder="Please provide your Feedback with in 500 words"></textarea>
					</div>

					<input class="btn btn-primary btn-block" type="submit"
						value="Submit">
				</form>
			</div>
		</div>
		<!-- Sidebar end -->

        <!-- Content wrapper start -->
        <div class="content-wrapper">
		<img src="<c:url value="/img/StaticImages/mainPage.jpg"/>" title=""
				class="Page_image" alt="">
			<h1 class="centered">
				<span>Welcome to <br>Library
				</span>
			</h1>
        </div>
        <!-- Content wrapper end -->

        <!-- Navbar fixed bottom start -->
        <nav class="navbar navbar-fixed-bottom">
      <button id="btn" class="btn" type="button" onclick="halfmoon.toggleSidebar()">
                    <i aria-hidden="true">FeedBack</i>
                </button>
        
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-question-circle-o mr-5" aria-hidden="true"></i>
                        Help
                    </a>
                </li>
            </ul>
            <span class="navbar-text">
                &copy; Copyright 2021, Brand
            </span>
        </nav>
        <!-- Navbar fixed bottom end -->

    </div>
    <!-- Page wrapper end -->

    <!-- Halfmoon JS -->
    <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>
    <script type="text/javascript">
        // Toasts a default alert
        function toastAlert() {
            var alertContent = "This is a default alert with <a href='#' class='alert-link'>a link</a> being toasted.";
            // Built-in function
            halfmoon.initStickyAlert({
                content: alertContent,
                title: "Toast!"
            })
        }

        // Toggles the parent's dark mode (if this page is loaded in an iFrame) 
        function parentToggleDarkmode() {
            window.parent.toggleDarkModeFromChild();
        }

        // Override the dark mode toggle function to call the parent's one
        // Again, this is for the case where the page is loaded in an iFrame
        if (window !== window.parent) {
            halfmoon.toggleDarkMode = parentToggleDarkmode;
        }
    </script>
</body>







  <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>




</html>