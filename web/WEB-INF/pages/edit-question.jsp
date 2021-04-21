<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit question</title>
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
        
        <c:if test="${sessionScope.UPDATED == true}">
            <div class="alert alert-success" role="alert">
                Update successfully
            </div>
        </c:if>
        <c:remove var="UPDATED" scope="session" />
        
        <c:if test="${sessionScope.DELETED == true}">
            <div class="alert alert-success" role="alert">
                Deactivate question successfully
            </div>
        </c:if>
        <c:remove var="DELETED" scope="session" />
        
        <c:set var="question" value="${requestScope.QUESTION}" />
        
        <div class="container page-content">
            <h1>Edit question</h1>
            <form action="editQuestion" method="POST">
                <input type="hidden" name="question_id" 
                       value="${question.questionId}" />
                <div class="mb-3">
                    <label for="subject" class="form-label">Subject</label>
                    <select id="subject" name="subject_id" 
                            class="form-control" required>
                        <c:forEach var="subject" items="${requestScope.SUBJECTS}">
                            <option value="${subject.subjectId}" 
                                    ${question.subject.subjectId == subject.subjectId ? 'selected' : ''}>
                                ${subject.subjectName}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="question_content" class="form-label">Question</label>
                    <textarea class="form-control" id="question_content"
                              name="question_content" required>${question.questionContent}</textarea>
                </div>

                <div class="mb-3">
                    <label for="status" class="form-label">Status</label>
                    <select id="status" name="is_active" 
                            class="form-control" required>
                        <option value="1" ${question.isActive == true ? 'selected' : ''}>
                            Active
                        </option>
                        <option value="0" ${question.isActive == false ? 'selected' : ''}>
                            Deactivated
                        </option>
                    </select>
                </div>

                <hr class="mt-5 mb-3"/>
                <div class="mb-3">
                    <input type="hidden" name="answer_id1" 
                           value="${question.answers[0].answerId}" />
                    <input name="is_correct" value="1" 
                           type="radio" required
                           ${question.answers[0].isCorrect == true ? 'checked' : ''}/>
                    <label for="answer_content1" class="form-label">Option A</label>
                    <textarea class="form-control" id="answer_content1"
                              name="answer_content1" required>${question.answers[0].answerContent}</textarea>

                </div>
                <div class="mb-3">
                    <input type="hidden" name="answer_id2" 
                           value="${question.answers[1].answerId}" />
                    <input name="is_correct" value="2" 
                           type="radio" required
                           ${question.answers[1].isCorrect == true ? 'checked' : ''} />
                    <label for="answer_content2" class="form-label">Option B</label>
                    <textarea class="form-control" id="answer_content2"
                              name="answer_content2" required>${question.answers[1].answerContent}</textarea>
                </div>
                <div class="mb-3">
                    <input type="hidden" name="answer_id3" 
                           value="${question.answers[2].answerId}" />
                    <input name="is_correct" value="3" 
                           type="radio" required 
                           ${question.answers[2].isCorrect == true ? 'checked' : ''}/>
                    <label for="answer_content3" class="form-label">Option C</label>
                    <textarea class="form-control" id="answer_content3"
                              name="answer_content3" required>${question.answers[2].answerContent}</textarea>
                </div>
                <div class="mb-3">
                    <input type="hidden" name="answer_id4" 
                           value="${question.answers[3].answerId}" />
                    <input name="is_correct" value="4" 
                           type="radio" required
                           ${question.answers[3].isCorrect == true ? 'checked' : ''} />
                    <label for="answer_content4" class="form-label">Option D</label>
                    <textarea class="form-control" id="answer_content4"
                              name="answer_content4" required>${question.answers[3].answerContent}</textarea>
                </div>
                <div class="mt-3 mb-3">
                    <input type="submit" value="Update question" 
                           class="form-control btn btn-primary"/>
                </div>
            </form>
                
            <form action="deleteQuestion" method="POST">
                <input type="hidden" value="${question.questionId}" 
                       name="question_id"/>
                <div class="mt-3 mb-3">
                    <input type="submit" value="Delete question" 
                           class="form-control btn btn-danger"/>
                </div>
            </form>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
</html>
