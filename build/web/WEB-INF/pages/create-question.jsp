<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create question</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <%@include file="../jspf/navigation.jspf" %>
        <c:set var="user" value="${sessionScope.USER}" />
        <c:if test="${sessionScope.INSERTED == true}">
            <div class="alert alert-success" role="alert">
                New question is inserted
            </div>
        </c:if>
        <c:if test="${sessionScope.INSERTED == false}">
            <div class="alert alert-danger" role="alert">
                Something is wrong. Please try again
            </div>
        </c:if>
        <c:remove var="INSERTED" scope="session" />
        
        <div class="container page-content">
            <h1>Create Question</h1>
            <form action="createQuestion" method="POST">
                <div class="mb-3">
                    <label for="subject" class="form-label">Subject</label>
                    <select id="subject" name="subject_id" 
                            class="form-control" required>
                        <c:forEach var="subject" items="${requestScope.SUBJECTS}">
                            <option value="${subject.subjectId}">
                                ${subject.subjectName}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="question_content" class="form-label">Question</label>
                    <textarea class="form-control" id="question_content"
                              name="question_content" required></textarea>
                </div>
                <hr class="mt-5 mb-3"/>
                <div class="mb-3">
                    <input name="is_correct" value="1" type="radio" required/>
                    <label for="answer_content1" class="form-label">Option A</label>
                    <textarea class="form-control" id="answer_content1"
                              name="answer_content1" required></textarea>
                    
                </div>
                <div class="mb-3">
                    <input name="is_correct" value="2" type="radio" required/>
                    <label for="answer_content2" class="form-label">Option B</label>
                    <textarea class="form-control" id="answer_content2"
                              name="answer_content2" required></textarea>
                </div>
                <div class="mb-3">
                    <input name="is_correct" value="3" type="radio" required/>
                    <label for="answer_content3" class="form-label">Option C</label>
                    <textarea class="form-control" id="answer_content3"
                              name="answer_content3" required></textarea>
                </div>
                <div class="mb-3">
                    <input name="is_correct" value="4" type="radio" required/>
                    <label for="answer_content4" class="form-label">Option D</label>
                    <textarea class="form-control" id="answer_content4"
                              name="answer_content4" required></textarea>
                </div>
                <div class="mt-3 mb-3">
                    <input type="submit" value="Create new question" class="form-control btn btn-secondary" />
                </div>
            </form>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
