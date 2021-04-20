package service;

import common.RequestParam.AnswerParam;
import dao.AnswerDAO;
import dto.AnswerDTO;
import dto.QuestionDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author andtpse62827
 */
public class AnswerService {
    private final AnswerDAO answerDAO;
    
    public AnswerService() {
        answerDAO = new AnswerDAO();
    }
    
    public int insertAnswer(AnswerDTO answer) 
            throws SQLException, ClassNotFoundException {
        return answerDAO.insertAnswer(answer);
    }
    
    public void insertListAnswer(HttpServletRequest request, int questionId) 
            throws SQLException, ClassNotFoundException {
        List<AnswerDTO> answers = mapRequestToListAnswer(request, questionId);
        
        for (AnswerDTO answer : answers) {
            answerDAO.insertAnswer(answer);
        }
    }
    
    public List<AnswerDTO> getAnswersByQuestionId(int questionId) 
            throws SQLException, ClassNotFoundException {
        return answerDAO.getAnswersByQuestionId(questionId);
    }
    
    private List<AnswerDTO> mapRequestToListAnswer(HttpServletRequest request, 
            int questionId) {
        List<AnswerDTO> answers = new ArrayList<>();
        
        String answerContent1 = request.getParameter(AnswerParam.ANSWER_CONTENT1);
        AnswerDTO answer1 = new AnswerDTO(new QuestionDTO(questionId), answerContent1, false);
        
        String answerContent2 = request.getParameter(AnswerParam.ANSWER_CONTENT2);
        AnswerDTO answer2 = new AnswerDTO(new QuestionDTO(questionId), answerContent2, false);
        
        String answerContent3 = request.getParameter(AnswerParam.ANSWER_CONTENT3);
        AnswerDTO answer3 = new AnswerDTO(new QuestionDTO(questionId), answerContent3, false);
        
        String answerContent4 = request.getParameter(AnswerParam.ANSWER_CONTENT4);
        AnswerDTO answer4 = new AnswerDTO(new QuestionDTO(questionId), answerContent4, false);
        
        String selectedAnswer = request.getParameter(AnswerParam.IS_CORRECT);
        
        switch(selectedAnswer) {
            case "1":
                answer1.setIsCorrect(Boolean.TRUE);
                break;
            case "2":
                answer2.setIsCorrect(Boolean.TRUE);
                break;
            case "3":
                answer3.setIsCorrect(Boolean.TRUE);
                break;
            case "4":
                answer4.setIsCorrect(Boolean.TRUE);
                break;
        }
        
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        
        return answers;
    }
}
