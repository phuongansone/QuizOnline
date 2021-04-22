<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz History</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <%@include file="../jspf/navigation.jspf" %>
        <c:set var="quiz" value="${requestScope.QUIZ}" />
        
        <c:if test="${sessionScope.ERROR == true}">
            <div class="alert alert-danger" role="alert">
                Something is wrong. Please try again
            </div>
        </c:if>
        <c:remove var="ERROR" scope="session" />
        <div class="container page-content">
            <div class="card mb-3 mt-3">
                <div class="card-body">
                    <h5 class="card-title">${quiz.quizMeta.title}</h5>
                    <hr class="mt-3 mb-3">
                    <div class="card-text">
                        <p><b>Subject</b>: ${quiz.quizMeta.subject.subjectName}</p>
                        <p><b>Score</b>: ${quiz.score}</p>
                        <p class="text-muted">Date: ${quiz.createAt}</p>
                    </div>
                </div>
            </div>
            <hr/>
            <div>
                <c:forEach var="quizQuestion" items="${requestScope.QUIZ_QUESTIONS}">
                    <div class="card mt-3 mb-3 mr-3 border-0">
                        <div class="card-body">
                            <h6 class="card-title">${quizQuestion.question.questionContent}</h6>
                        </div>
                        <div class="card-text mr-3">
                            <ul>
                                <c:forEach items="${quizQuestion.question.answers}" var="answer">
                                    <li class="list-group-item 
                                        ${quizQuestion.answer.answerId == answer.answerId and quizQuestion.correct == false ? 'list-group-item-danger' : ''} 
                                        ${answer.isCorrect == true ? 'list-group-item-success' : ''}">
                                        <input value="${answer.answerId}" class="mr-2" type="radio"
                                               ${quizQuestion.answer.answerId == answer.answerId ? 'checked' : ''}>
                                        ${answer.answerContent}
                                    </li>
                                </c:forEach>
                            </ul>
                            <input type="hidden" name="index" value="${param.current == null ? 0 : param.current}" />
                        </div>
                    </div>
                </c:forEach>
            </div>
            
            <div>
                <a class="btn btn-primary mb-3" href="quizHistory">Back to history</a>
            </div>
        </div>
        
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
