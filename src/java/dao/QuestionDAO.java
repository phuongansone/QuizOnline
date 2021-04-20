package dao;

import dto.QuestionDTO;
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
public class QuestionDAO {
    private static final String INSERT_QUESTION = "INSERT INTO question "
            + "(subject_id, question_content, is_active, create_by) "
            + "VALUES (?, ?, ?, ?)";
    
    public int insertQuestion(QuestionDTO question) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int insertedId = -1;
        
        try {
            conn = DatabaseUtil.makeConnection();
            if (conn != null) {
                ps = conn.prepareStatement(INSERT_QUESTION, 
                        Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, question.getSubject().getSubjectId());
                ps.setString(2, question.getQuestionContent());
                ps.setBoolean(3, question.isIsActive());
                ps.setString(4, question.getCreateBy().getEmail());
                
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
