package common;

/**
 *
 * @author PC
 */
public class RequestMapping {
    
    public static class RegisterRequest {
        public static final String ACTION = "register";
        public static final String SERVLET = "RegisterServlet";
        public static final String VIEW = "/WEB-INF/pages/register.jsp";
        private RegisterRequest() {
        }
    }
    
    public static class LoginRequest {
        public static final String ACTION = "login";
        public static final String SERVLET = "LoginServlet";
        public static final String VIEW = "/WEB-INF/pages/login.jsp";
        private LoginRequest() {
        }
    }
    
    public static class LogoutRequest {
        public static final String ACTION = "logout";
        public static final String SERVLET = "LogoutServlet";
        private LogoutRequest() {
        }
    }
    
    public static class TakeQuizRequest {
        public static final String ACTION = "takeQuiz";
        public static final String SERVLET = "TakeQuizServlet";
        public static final String VIEW = "/WEB-INF/pages/take-quiz.jsp";
        private TakeQuizRequest() {
        }
    }
    
    public static class SearchQuestionRequest {
        public static final String ACTION = "searchQuestion";
        public static final String SERVLET = "SearchQuestionServlet";
        public static final String VIEW = "/WEB-INF/pages/search-question.jsp";
        private SearchQuestionRequest() {
        }
    }
    
    public static class CreateQuestionRequest {
        public static final String ACTION = "createQuestion";
        public static final String VIEW = "/WEB-INF/pages/create-question.jsp";
        private CreateQuestionRequest() {
        }
    }
}
