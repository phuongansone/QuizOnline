package dao;

import dto.QuizQuestionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DatabaseUtil;

/**
 *
 * @author andtpse62827
 */
public class QuizQuestionDAO {
    private static final String INSERT_QUIZ_QUESTION = "INSERT INTO quiz_question "
            + "(quiz_id, question_id, answer_id, is_correct, score) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    public int insertQuizQuestion(QuizQuestionDTO quizQuestion) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int insertedId = -1;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(INSERT_QUIZ_QUESTION, 
                        Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, quizQuestion.getQuiz().getQuizId());
                ps.setInt(2, quizQuestion.getQuestion().getQuestionId());
                if (quizQuestion.getAnswer() == null) {
                    ps.setInt(3, -1);
                    ps.setBoolean(4, Boolean.FALSE);
                } else {
                    ps.setInt(3, quizQuestion.getAnswer().getAnswerId());
                    ps.setBoolean(4, quizQuestion.getAnswer().isIsCorrect());
                }
                
                ps.setDouble(5, quizQuestion.getScore());
                
                if (ps.executeUpdate() > 0) {
                    rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        insertedId = rs.getInt(1);
                    }
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return insertedId;
    }
}
