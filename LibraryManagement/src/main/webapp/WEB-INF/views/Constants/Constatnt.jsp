<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta charset="ISO-8859-1">
<title>LibraryManagement</title>
</head>
<body>
<%@page  import="com.Library.LibraryManagement.Utils.Constants.StudentStatus" %>
<%@page  import="com.Library.LibraryManagement.Utils.Constants.BookStatus" %>
<%@page  import="com.Library.LibraryManagement.Utils.Constants.CourseCode" %>
<%@page  import="com.Library.LibraryManagement.Utils.Constants.UserType" %>


<c:set var="MCA" value="<%= CourseCode.MCA%>" />
<c:set var="BCA" value="<%= CourseCode.BCA%>" />
<c:set var="BTECH" value="<%= CourseCode.B_Tech%>" />
<c:set var="MTECH" value="<%= CourseCode.M_Tech%>" />
<c:set var="None" value="<%= CourseCode.None%>" />


<c:set var="Student" value="<%= UserType.STUDENT%>" />
<c:set var="Admin" value="<%= UserType.ADMIN%>" />
<c:set var="Library_Manager" value="<%= UserType.LIBRARY_MANAGER%>" />




</body>
</html>