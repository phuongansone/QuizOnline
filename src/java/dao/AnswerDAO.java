package dao;

import dto.AnswerDTO;
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
public class AnswerDAO {
    private static final String INSERT_ANSWER = "INSERT INTO answer "
            + "(question_id, answer_content, is_correct) "
            + "VALUES (?, ?, ?)";
    
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
}
