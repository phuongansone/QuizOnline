<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subjects</title>
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
        
        <c:if test="${sessionScope.ERROR == true}">
            <div class="alert alert-danger" role="alert">
                Something is wrong. Please try again
            </div>
        </c:if>
        <c:remove var="ERROR" scope="session" />
        
        <div class="container page-content">
            <h1>Subjects</h1>
            <c:forEach items="${requestScope.SUBJECTS}" var="subject" >
                <div class="card mb-3 mt-3">
                    <div class="card-body">
                        <h5 class="card-title">${subject.subjectName}</h5>
                        <a href="quizMetaList?subject_id=${subject.subjectId}" 
                           class="btn btn-primary">Take quiz</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
