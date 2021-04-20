package service;

import common.CommonAttribute;
import common.RequestParam.QuestionParam;
import dao.QuestionDAO;
import dto.QuestionDTO;
import dto.SubjectDTO;
import dto.UserDTO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class QuestionService {
    private final QuestionDAO questionDAO;
    private final AnswerService answerService;

    public QuestionService() {
        questionDAO = new QuestionDAO();
        answerService = new AnswerService();
    }
    
    public void insertQuestionAndAnswer(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        int questionId = insertQuestion(request);
        answerService.insertListAnswer(request, questionId);
    }
    
    public int insertQuestion(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        return questionDAO.insertQuestion(mapRequestToQuestionDTO(request));
    }
    
    private QuestionDTO mapRequestToQuestionDTO(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(CommonAttribute.USER);
        
        int subjectId = StringUtil.parseInt(
                request.getParameter(QuestionParam.SUBJECT_ID), -1);
        SubjectDTO subject = new SubjectDTO(subjectId, null);
        
        String questionContent = request.getParameter(QuestionParam.QUESTION_CONTENT);
        
        return new QuestionDTO(subject, questionContent, Boolean.TRUE, user, null);
    }
}
