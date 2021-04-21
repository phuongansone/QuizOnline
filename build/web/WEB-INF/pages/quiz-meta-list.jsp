<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Meta</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <%@include file="../jspf/navigation.jspf" %>
        
        <c:if test="${sessionScope.ERROR == true}">
            <div class="alert alert-danger" role="alert">
                Something is wrong. Please try again
            </div>
        </c:if>
        <c:remove var="ERROR" scope="session" />
        
        <div class="container page-content">
            <h1>Quiz</h1>
            
            <c:forEach items="${requestScope.QUIZ_METAS}" var="quizMeta">
                <div class="card mb-3 mt-3">
                    <div class="card-body">
                        <h5 class="card-title">${quizMeta.title}</h5>
                        <p>Subject: ${quizMeta.subject.subjectName}</p>
                        <hr/>
                        <p>Number of questions: ${quizMeta.noOfQuestion}</p>
                        <p>Duration: ${quizMeta.duration} minutes</p>
                        <a class="btn btn-primary" 
                           href="takeQuiz?subject_id=${quizMeta.subject.subjectId}&question_no=${quizMeta.noOfQuestion}&quiz_meta_id=${quizMeta.quizMetaId}">
                            Start
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
