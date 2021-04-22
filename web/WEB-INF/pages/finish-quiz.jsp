<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Result</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <c:set var="quiz" value="${requestScope.QUIZ}"/>

        <c:if test="${sessionScope.ERROR == true}">
            <div class="alert alert-danger" role="alert">
                Something is wrong. Please try again
            </div>
        </c:if>
        <c:remove var="ERROR" scope="session" />

        <%@include file="../jspf/navigation.jspf" %>
        <div class="container page-content">
            <div class="card mt-3 mb-3 mr-3 border-0">
                <div class="card-body">
                    <h1 class="card-title">${quiz.quizMeta.title}</h1>
                </div>
                <hr class="mb-3" />
                <div class="card-text mr-3">
                    Score: ${quiz.score}
                </div>
                <div class="card-text mr-3">
                    Correct: ${requestScope.CORRECT_ANS_NO} / ${quiz.quizMeta.noOfQuestion}
                </div>
            </div>
                <a href="subjectList" class="btn btn-primary">Back</a>
        </div>

    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
