<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
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
            <h1>Quiz History</h1>
            <form action="quizHistory" method="GET">
                <div class="input-group mt-2 mb-2">
                    <div class="input-group-prepend">
                        <label class="input-group-text width-100px" 
                               for="subject-name">
                            Keyword
                        </label>
                    </div>
                    <input type="text" class="form-control" 
                           placeholder="Subject contains..." 
                           id="subject-name" name="subject_name"
                           value="${param.subject_name}"/>
                </div>
                
                <div class="input-group mt-2 mb-2">
                    <div class="input-group-prepend">
                        <label class="input-group-text width-100px" 
                               for="subject">
                            Subject
                        </label>
                    </div>
                    <select name="subject_id" id="subject-id" 
                            class="form-control">
                        <option value="">Select subject...</option>
                        <c:forEach var="subject" items="${requestScope.SUBJECTS}">
                            <option value="${subject.subjectId}" 
                                    ${param.subject == subject.subjectId ? 'selected' : ''}>
                                ${subject.subjectName}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                
                <input type="submit" class="btn btn-outline-secondary" value="Search" />
            </form>
            <hr class="mt-2 mb-2">
            <c:forEach var="quiz" items="${requestScope.QUIZZES}">
                <div class="card mb-3 mt-3">
                    <div class="card-body">
                        <h5 class="card-title">${quiz.quizMeta.title}</h5>
                        <hr class="mt-3 mb-3">
                        <div class="card-text">
                            <p><b>Subject</b>: ${quiz.quizMeta.subject.subjectName}</p>
                            <p><b>Score</b>: ${quiz.score}</p>
                            <p class="text-muted">Date: ${quiz.createAt}</p>
                        </div>
                        <div>
                            <a href="historyDetail?quiz_id=${quiz.quizId}" 
                               class="btn btn-primary">
                                View Detail
                            </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
            
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach items="${requestScope.PAGES}" var="pageNo">
                        <li class="page-item ${pageNo == requestScope.PAGE ? 'active' : ''}">
                            <a class="page-link" 
                               href="quizHistory?page=${pageNo}&subject_name=${param.subject_name}&subject_id=${param.subject_id}&status=${param.status}">
                                ${pageNo}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
    <script>
        var SUBJECT_NAME = '#subject-name';
        var SUBJECT_ID = '#subject-id';
        
        $(SUBJECT_NAME).on('click', function() {
            $(SUBJECT_ID).val('');
        });
        
        $(SUBJECT_ID).on('click', function() {
            $(SUBJECT_NAME).val('');
        });
    </script>
</html>
