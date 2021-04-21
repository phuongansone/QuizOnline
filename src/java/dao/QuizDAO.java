package dao;

import common.RequestParam.QuizMetaParam;
import common.RequestParam.QuizParam;
import dto.QuizDTO;
import dto.QuizMetaDTO;
import dto.SubjectDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DatabaseUtil;

/**
 *
 * @author andtpse62827
 */
public class QuizDAO {
    private static final String INSERT_QUIZ = "INSERT INTO quiz "
            + "(email, is_active, quiz_meta_id) "
            + "VALUES (?, ?, ?)";
    
    private static final String GET_QUIZ_BY_ID = "SELECT quiz_id, email, score, "
            + "q.is_active, q.create_at, q.update_at, "
            + "s.subject_id, s.subject_name, "
            + "qm.title, qm.question_no, qm.duration "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s ON qm.subject_id = s.subject_id "
            + "WHERE quiz_id = ?";
    
    public int insertQuiz(QuizDTO quiz) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int insertedId = -1;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(INSERT_QUIZ, 
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, quiz.getEmail());
                ps.setBoolean(2, true);
                ps.setInt(3, quiz.getQuizMeta().getQuizMetaId());
                
                if (ps.executeUpdate() > 0) {
                    rs = ps.getGeneratedKeys();
                    
                    if(rs.next()) {
                        insertedId = rs.getInt(1);
                    }
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return insertedId;
    }
    
    public QuizDTO getQuizById(int quizId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        QuizDTO quizDTO = null;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUIZ_BY_ID);
                ps.setInt(1, quizId);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    quizDTO = mapResultSetToQuizDTO(rs);
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizDTO;
    }
    
    private QuizDTO mapResultSetToQuizDTO(ResultSet rs) throws SQLException {
        int quizID = rs.getInt(QuizParam.QUIZ_ID);
        String email = rs.getString(QuizParam.EMAIL);
        double score = rs.getDouble(QuizParam.SCORE);
        boolean active = rs.getBoolean(QuizParam.IS_ACTIVE);
        Date createAt = rs.getDate(QuizParam.CREATE_AT);
        Date updateAt = rs.getDate(QuizParam.UPDATE_AT);
        
        int subjectId = rs.getInt(QuizMetaParam.SUBJECT_ID);
        String subjectName = rs.getString(QuizMetaParam.SUBJECT_NAME);
        SubjectDTO subject = new SubjectDTO(subjectId, subjectName);
        String title = rs.getString(QuizMetaParam.TITLE);
        int questionNo = rs.getInt(QuizMetaParam.QUESTION_NO);
        int duration = rs.getInt(QuizMetaParam.DURATION);
        
        QuizMetaDTO quizMeta = new QuizMetaDTO();
        quizMeta.setSubject(subject);
        quizMeta.setTitle(title);
        quizMeta.setNoOfQuestion(questionNo);
        quizMeta.setDuration(duration);
        
        return new QuizDTO(quizID, email, score, active, 
                createAt, updateAt, quizMeta);
    }
}
