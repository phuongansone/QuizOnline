package common;

/**
 *
 * @author andtpse62827
 */
public class RequestParam {
    // Pagination
    public static final String OFFSET = "off";
    public static final String LENGTH = "len";
    public static final String PAGE = "page";
    
    // Search parameter
    public static final String KEYWORD = "keyword";
    public static final String SUBJECT = "subject";
    public static final String STATUS = "status";
    
    public static class UserParam {
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String FULLNAME = "fullname";
        public static final String ROLE_ID = "role_id";
        public static final String STATUS_ID = "status_id";
    }
    
    public static class RoleParam {
        public static final String ROLE_ID = "role_id";
        public static final String ROLE_NAME = "role_name";
    }
    
    public static class StatusParam {
        public static final String STATUS_ID = "status_id";
        public static final String STATUS_NAME = "status_name";
    }
    
    public static class SubjectParam {
        public static final String SUBJECT_ID = "subject_id";
        public static final String SUBJECT_NAME = "subject_name";
    }
    
    public static class QuestionParam {
        public static final String QUESTION_ID = "question_id";
        public static final String SUBJECT_ID = "subject_id";
        public static final String QUESTION_CONTENT = "question_content";
        public static final String IS_ACTIVE = "is_active";
        public static final String CREATE_AT = "create_at";
        public static final String UPDATE_AT = "update_at";
        public static final String CREATE_BY = "create_by";
        public static final String UPDATE_BY = "update_by";
    }
    
    public static class AnswerParam {
        public static final String ANSWER_ID = "answer_id";
        public static final String QUESTION_ID = "question_id";
        public static final String ANSWER_CONTENT = "answer_content";
        public static final String IS_CORRECT = "is_correct";
        public static final String CREATE_AT = "create_at";
        public static final String UPDATE_AT = "update_at";
        
        public static final String ANSWER_CONTENT1 = "answer_content1";
        public static final String ANSWER_CONTENT2 = "answer_content2";
        public static final String ANSWER_CONTENT3 = "answer_content3";
        public static final String ANSWER_CONTENT4 = "answer_content4";
    }
    
    
}
