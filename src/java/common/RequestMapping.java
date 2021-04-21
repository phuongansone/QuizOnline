package common;

/**
 *
 * @author andtpse62827
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
    
    public static class EditQuestionRequest {
        public static final String ACTION = "editQuestion";
        public static final String VIEW = "/WEB-INF/pages/edit-question.jsp";
        private EditQuestionRequest() {
        }
    }
    
    public static class DeleteQuestionRequest {
        public static final String ACTION = "deleteQuestion";
        public static final String VIEW = "/WEB-INF/pages/edit-question.jsp";
        private DeleteQuestionRequest() {
        }
    }
    
    public static class SubjectListRequest {
        public static final String ACTION = "subjectList";
        public static final String VIEW = "/WEB-INF/pages/subject-list.jsp";
        private SubjectListRequest() {
        }
    }
    
    public static class QuizMetaRequest {
        public static final String ACTION = "quizMetaList";
        public static final String VIEW = "/WEB-INF/pages/quiz-meta-list.jsp";
        private QuizMetaRequest() {
        }
    }
    
    public static class QuizQuestionRequest {
        public static final String ACTION = "quizQuestion";
        public static final String VIEW = "/WEB-INF/pages/quiz-question.jsp";
        private QuizQuestionRequest() {
        }
    }
    
    public static class FinishQuizRequest {
        public static final String ACTION = "finishQuiz";
        public static final String VIEW = "/WEB-INF/pages/finish-quiz.jsp";
        private FinishQuizRequest() {
        }
    }
}
