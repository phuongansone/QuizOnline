<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Question</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <%@include file="../jspf/navigation.jspf" %>
        
        <c:set var="user" value="${sessionScope.USER}" />
        <c:if test="${sessionScope.LOGGED_IN == true}">
            <div class="alert alert-success" role="alert">
                Welcome, ${user.fullname}
            </div>
        </c:if>
        <c:remove var="LOGGED_IN" scope="session" />
        
        <div class="container page-content">
            <h1>Search Question</h1>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
