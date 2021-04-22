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
        <c:set var="quizQuestion" value="${sessionScope.QUIZ_QUESTIONS[param.current]}"/>
        <c:set var="quiz" value="${sessionScope.QUIZ}"/>
        
        
        <form action="quizQuestion" method="POST" id="quiz-question-form">
            <div class="card mt-3 mb-3 mr-3 border-0">
                <div class="card-body border-0">
                    Time remained: <span id="time-remain" class="red-bold"></span>
                </div>
                <div class="card-body">
                    <h6 class="card-title">${param.current == null ? 1 : param.current + 1}. ${question.questionContent}</h6>
                </div>
                    <input type="hidden" name="timer" 
                           value="${sessionScope.TIMER == null ? (quiz.quizMeta.duration * 60) : sessionScope.TIMER}"/>
                <div class="card-text mr-3">
                    <ul>
                        <c:forEach items="${question.answers}" var="answer">
                            <li class="list-group-item">
                                <input value="${answer.answerId}" class="mr-2"
                                       name="answer_id" type="radio"
                                       ${quizQuestion.answer.answerId == answer.answerId ? 'checked' : ''}>
                                ${answer.answerContent}
                            </li>
                        </c:forEach>
                    </ul>
                    <input type="hidden" name="index" value="${param.current == null ? 0 : param.current}" />
                </div>
                <div class="d-flex justify-content-end">
                    <div>
                        <c:if test="${param.current > 0}">
                            <button class="btn btn-secondary" name="current" 
                                    value="${param.current - 1 >= 0 ? param.current - 1 : 0}"
                                    type="submit">
                                Prev</button>
                        </c:if>
                        
                        <c:if test="${param.current == null or param.current < sessionScope.QUESTION_NO - 1}">
                            <button class="btn btn-secondary" name="current" 
                                    value="${param.current + 1 <= sessionScope.QUESTION_NO - 1 ? param.current + 1 : sessionScope.QUESTION_NO - 1}"
                                    type="submit">
                                Next</button>                            
                        </c:if>
                    </div>
                </div>
            </div>
        </form>
        <div class="card mt-3 mb-3 mr-3 border-0">
            <div class="d-flex justify-content-end">
                <form action="finishQuiz" method="POST" id="finish-form">
                    <input type="hidden" name="index" value="${param.current == null ? 0 : param.current}""/>
                    <input type="hidden" name="answer_id" />
                    <button class="btn btn-secondary" id="finish-btn">Finish</button>
                </form>
            </div>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
    <script src="resources/js/quiz-question.js" /></script>
    <script>
        // selector
        var ANSWER_RADIO = 'input[type="radio"][name="answer_id"]';
        var SELECTED_ANSWER = 'input[type="radio"][name="answer_id"]:checked';
        var ANSWER_HDN = 'input[type="hidden"][name="answer_id"]';
        
        $(ANSWER_RADIO).on('click', function() {
            $(ANSWER_HDN).val($(SELECTED_ANSWER).val());
        });
    </script>
</html>
