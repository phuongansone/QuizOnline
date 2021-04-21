package dao;

import common.RequestParam.AnswerParam;
import dto.AnswerDTO;
import dto.QuestionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseUtil;

/**
 *
 * @author andtpse62827
 */
public class AnswerDAO {
    private static final String INSERT_ANSWER = "INSERT INTO answer "
            + "(question_id, answer_content, is_correct) "
            + "VALUES (?, ?, ?)";
    
    private static final String GET_ANSWER_BY_QUESTION_ID = "SELECT answer_id, question_id, "
            + "answer_content, is_correct FROM answer WHERE question_id = ?";
    
    private static final String UPDATE_ANSWER = "UPDATE answer "
            + "SET answer_content = ?, is_correct = ? "
            + "WHERE answer_id = ? AND question_id = ?";
    
    public int insertAnswer(AnswerDTO answer) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int insertedId = -1;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(INSERT_ANSWER, 
                        Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, answer.getQuestion().getQuestionId());
                ps.setString(2, answer.getAnswerContent());
                ps.setBoolean(3, answer.isIsCorrect());
                
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
    
    public List<AnswerDTO> getAnswersByQuestionId(int questionId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<AnswerDTO> answers = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            if (conn != null) {
                ps = conn.prepareStatement(GET_ANSWER_BY_QUESTION_ID);
                ps.setInt(1, questionId);
                
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    answers.add(mapResultSetToAnswerDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return answers;
    }
    
    public boolean updateAnswer(AnswerDTO answer) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean updated = false;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(UPDATE_ANSWER);
                
                ps.setString(1, answer.getAnswerContent());
                ps.setBoolean(2, answer.isIsCorrect());
                ps.setInt(3, answer.getAnswerId());
                ps.setInt(4, answer.getQuestion().getQuestionId());
                
                updated = ps.executeUpdate() > 0;
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return updated;
    }
    
    private AnswerDTO mapResultSetToAnswerDTO(ResultSet rs) throws SQLException {
        int answerId = rs.getInt(AnswerParam.ANSWER_ID);
        
        int questionId = rs.getInt(AnswerParam.QUESTION_ID);
        QuestionDTO question = new QuestionDTO(questionId);
        
        String answerContent = rs.getString(AnswerParam.ANSWER_CONTENT);
        boolean isCorrect = rs.getBoolean(AnswerParam.IS_CORRECT);
        
        return new AnswerDTO(answerId, question, answerContent, isCorrect, null, null);
    }
}
