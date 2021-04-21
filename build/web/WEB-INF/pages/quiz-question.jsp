<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <c:set var="question" value="${requestScope.QUESTION}"/>
        <form action="quizQuestion" method="POST">
            <div class="card mt-3 mb-3 mr-3 border-0">
                <div class="card-body">
                    <h6 class="card-title">${question.questionContent}</h6>
                </div>
                <div class="card-text mr-3">
                    <ul>
                        <c:forEach items="${question.answers}" var="answer">
                            <li class="list-group-item ${answer.isCorrect == true ? 'list-group-item-success' : ''}">
                                <input value="${answer.answerId}" class="mr-2"
                                       name="answer_id" type="radio">${answer.answerContent}
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" name="index" value="${param.current == null ? 0 : param.current}" />
                </div>
                <div class="d-flex justify-content-end">
                    <div>
                        <button class="btn btn-secondary" name="current" 
                                value="${param.current - 1 >= 0 ? param.current - 1 : 0}"
                                type="submit">
                            Prev</button>
                            
                        <button class="btn btn-secondary" name="current" 
                                value="${param.current + 1 <= sessionScope.QUESTION_NO - 1 ? param.current + 1 : sessionScope.QUESTION_NO - 1}"
                                type="submit">
                            Next</button>
                    </div>
                </div>
            </div>
        </form>
        <div class="card mt-3 mb-3 mr-3 border-0">
            <div class="d-flex justify-content-end">
                <a class="btn btn-secondary" href="finishQuiz">
                    Finish</a>
            </div>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
