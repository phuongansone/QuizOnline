<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resources/css/main.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <c:if test="${sessionScope.EMAIL_EXISTED}">
                        <div class="alert alert-danger" role="alert">
                            Email is already existed. Please use a different email.
                        </div>
                    </c:if>
                    <c:remove var="EMAIL_EXISTED" scope="session"/>
                    <div class="card">
                        <header class="card-header">
                            <a href="login" class="float-right btn btn-outline-primary mt-1">Log in</a>
                            <h4 class="card-title mt-2">Register</h4>
                        </header>
                        <article class="card-body">
                            <form method="POST" action="register" 
                                  class="form-signin">
                                <div class="form-group">
                                    <label for="email">Email address</label>
                                    <input type="email" class="form-control" id="email" 
                                           name="email" placeholder="Enter email" 
                                           value="${param.email}"
                                           autocomplete="off" required>
                                    <small id="emailHelp" class="form-text text-muted">
                                        We'll never share your email with anyone else.
                                    </small>
                                </div>
                                <div class="form-group">
                                    <label for="fullname">Full name</label>
                                    <input type="text" class="form-control" 
                                           id="fullname" name="fullname" 
                                           placeholder="Enter fullname" 
                                           value="${param.fullname}"
                                           autocomplete="off" required>
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" 
                                           id="password" name="password" 
                                           placeholder="Enter password" required>
                                </div>
                                <div class="form-group">
                                    <label for="confirm-password">Confirm password</label>
                                    <input type="password" class="form-control" 
                                           id="confirm-password" name="confirm-password" 
                                           placeholder="Confirm password" required>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-secondary btn-block">Register</button>
                                </div>
                            </form>                
                        </article>
                        <div class="border-top card-body text-center">Have an account? <a href="login">Log In</a></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="resources/js/jquery-3.6.0.min.js"></script>
    <script src="resources/js/bootstrap.min.js" /></script>
    <script>
        // selector
        var PASSWORD = '#password';
        var CONFIRM_PASSWORD = '#confirm-password';
        var MESSAGE = '#message';
        
        $(PASSWORD + ", " + CONFIRM_PASSWORD).on('keyup', function() {
            if ($(PASSWORD).val() !== $(CONFIRM_PASSWORD).val()) {
                $(CONFIRM_PASSWORD)[0].setCustomValidity('Password do not match');
            } else {
                $(CONFIRM_PASSWORD)[0].setCustomValidity('');
            }
        });
    </script>
</html>