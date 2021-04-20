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
            <h1>Question List</h1>
            <form action="searchQuestion" method="GET">
                <div class="input-group mt-2 mb-2">
                    <div class="input-group-prepend">
                        <label class="input-group-text width-100px" 
                               for="keyword">
                            Keyword
                        </label>
                    </div>
                    <input type="text" class="form-control" 
                           placeholder="Question contains..." 
                           id="keyword" name="keyword"
                           value="${param.keyword}"/>
                </div>
                
                <div class="input-group mt-2 mb-2">
                    <div class="input-group-prepend">
                        <label class="input-group-text width-100px" 
                               for="subject">
                            Subject
                        </label>
                    </div>
                    <select name="subject" id="subject" 
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
                        
                <div class="input-group mt-2 mb-2">
                    <div class="input-group-prepend">
                        <label class="input-group-text width-100px" 
                               for="status">
                            Status
                        </label>
                    </div>
                    <select name="status" id="status" 
                            class="form-control">
                        <option value="" ${param.status == '' ? 'selected' : ''}>Select status...</option>
                        <option value="1" ${param.status == '1' ? 'selected' : ''}>Active</option>
                        <option value="0" ${param.status == '0' ? 'selected' : ''}>Inactive</option>
                    </select>
                </div>
                <input type="submit" class="btn btn-outline-secondary" value="Search" />
            </form>
            <hr class="mt-2 mb-2">
            <c:forEach items="${requestScope.QUESTIONS}" var="question">
                <div class="card mt-3 mb-3">
                    <div class="card-body">
                        <h6 class="card-title">${question.questionContent}</h6>
                    </div>
                    <div class="card-text">
                        <ul>
                            <c:forEach items="${question.answers}" var="answer">
                                <li class="list-group-item ${answer.isCorrect == true ? 'list-group-item-success' : ''}">
                                    ${answer.answerContent}
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </c:forEach>
            
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach items="${requestScope.PAGES}" var="pageNo">
                        <li class="page-item ${pageNo == requestScope.PAGE ? 'active' : ''}">
                            <a class="page-link" 
                               href="searchQuestion?page=${pageNo}&keyword=${param.keyword}&subject=${param.subject}&status=${param.status}">
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
        // Selector
        var KEYWORD = '#keyword';
        var SUBJECT = '#subject';
        var STATUS = '#status';
        
        // Reset filter
        $(KEYWORD).on('click', function() {
            $(SUBJECT).val('');
            $(STATUS).val('');
        });
        
        $(SUBJECT).on('click', function() {
            $(KEYWORD).val('');
            $(STATUS).val('');
        });
        
        $(STATUS).on('click', function() {
            $(KEYWORD).val('');
            $(SUBJECT).val('');
        });
    </script>
</html>
