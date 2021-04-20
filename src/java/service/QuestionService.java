package service;

import common.CommonAttribute;
import common.RequestParam.QuestionParam;
import dao.QuestionDAO;
import dto.AnswerDTO;
import dto.QuestionDTO;
import dto.SubjectDTO;
import dto.UserDTO;
import java.sql.SQLException;
import java.util.List;
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
    
    public List<QuestionDTO> getAllQuestions(int off, int len) 
            throws SQLException, ClassNotFoundException {
        List<QuestionDTO> questions = questionDAO.getAllQuestions(off, len);
        
        for (QuestionDTO question : questions) {
            List<AnswerDTO> answers = answerService
                    .getAnswersByQuestionId(question.getQuestionId());
            question.setAnswers(answers);
        }
        
        return questions;
    }
    
    public int countAllQuestions() throws SQLException, ClassNotFoundException {
        return questionDAO.countAllQuestions();
    }
    
    public List<QuestionDTO> getQuestionsByName(String keyword, int off, int len) 
            throws SQLException, ClassNotFoundException {
        List<QuestionDTO> questions = questionDAO.getQuestionsByName(keyword, off, len);
        
        for (QuestionDTO question : questions) {
            List<AnswerDTO> answers = answerService
                    .getAnswersByQuestionId(question.getQuestionId());
            question.setAnswers(answers);
        }
        
        return questions; 
    }
    
    public int countQuestionsByName(String keyword) 
            throws SQLException, ClassNotFoundException {
        return questionDAO.countQuestionsByName(keyword);
    }
    
    public List<QuestionDTO> getQuestionsByStatus(boolean status, int off, int len) 
            throws SQLException, ClassNotFoundException {
        List<QuestionDTO> questions = questionDAO.getQuestionsByStatus(status, off, len);
        
        for (QuestionDTO question : questions) {
            List<AnswerDTO> answers = answerService
                    .getAnswersByQuestionId(question.getQuestionId());
            question.setAnswers(answers);
        }
        
        return questions;
    }
    
    public int countQuestionsByStatus(boolean status) 
            throws SQLException, ClassNotFoundException {
        return questionDAO.countQuestionsByStatus(status);
    }
    
    public List<QuestionDTO> getQuestionBySubject(int subjectId, int off, int len) 
            throws SQLException, ClassNotFoundException {
        List<QuestionDTO> questions = questionDAO.getQuestionBySubject(subjectId, off, len);
        
        for (QuestionDTO question : questions) {
            List<AnswerDTO> answers = answerService
                    .getAnswersByQuestionId(question.getQuestionId());
            question.setAnswers(answers);
        }
        
        return questions;
    }
    
    public int countQuestionsBySubject(int subjectId) 
            throws SQLException, ClassNotFoundException {
        return questionDAO.countQuestionsBySubject(subjectId);
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
