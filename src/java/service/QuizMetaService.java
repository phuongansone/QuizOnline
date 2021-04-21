package service;

import dao.QuizMetaDAO;
import dto.QuizMetaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andtpse62827
 */
public class QuizMetaService {
    private final QuizMetaDAO quizMetaDAO;

    public QuizMetaService() {
        quizMetaDAO = new QuizMetaDAO();
    }
    
    public List<QuizMetaDTO> getQuizMetaBySubjectId(int subjectId) 
            throws SQLException, ClassNotFoundException {
        return quizMetaDAO.getQuizMetaBySubjectId(subjectId);
    }
}
