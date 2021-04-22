package service;

import common.CommonAttribute;
import common.RequestParam.QuizMetaParam;
import dao.QuizDAO;
import dto.QuizDTO;
import dto.QuizMetaDTO;
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
public class QuizService {
    private final QuizDAO quizDAO;

    public QuizService() {
        this.quizDAO = new QuizDAO();
    }
    
    public int insertQuiz(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(CommonAttribute.USER);
        
        int quizMetaId = StringUtil.parseInt(
                request.getParameter(QuizMetaParam.QUIZ_META_ID), -1);
        QuizMetaDTO quizMeta = new QuizMetaDTO();
        quizMeta.setQuizMetaId(quizMetaId);
        
        QuizDTO quiz = new QuizDTO();
        quiz.setEmail(user.getEmail());
        quiz.setQuizMeta(quizMeta);
        
        return quizDAO.insertQuiz(quiz);
    }
    
    public QuizDTO getQuizById(int quizId) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.getQuizById(quizId);
    }
    
    public boolean updateQuizScore(QuizDTO quiz) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.updateQuizScore(quiz);
    }
    
    public List<QuizDTO> getQuizByEmail(String email, int off, int len) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.getQuizByEmail(email, off, len);
    }
    
    public int countByEmail(String email) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.countByEmail(email);
    }
    
    public List<QuizDTO> getQuizBySubjectName(String keyword, String email,
            int off, int len) throws SQLException, ClassNotFoundException {
        return quizDAO.getQuizBySubjectName(keyword, email, off, len);
    }
    
    public int countBySubjectName(String keyword, String email) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.countBySubjectName(keyword, email);
    }
    
    public List<QuizDTO> getQuizBySubjectId(int subjectId, String email, 
            int off, int len) throws SQLException, ClassNotFoundException {
        return quizDAO.getQuizBySubjectId(subjectId, email, off, len);
    }
    
    public int countBySubjectId(int subjectId, String email) 
            throws SQLException, ClassNotFoundException {
        return quizDAO.countBySubjectId(subjectId, email);
    }
}
