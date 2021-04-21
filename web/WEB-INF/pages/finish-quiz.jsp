<%-- 
    Document   : finish-quiz
    Created on : Apr 22, 2021, 5:07:32 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Result</title>
    </head>
    <body>
        <h1>Quiz Result</h1>
        Score: ${requestScope.SCORE}
        <br>
        Correct Ans No: ${requestScope.CORRECT_ANS_NO}
    </body>
</html>
