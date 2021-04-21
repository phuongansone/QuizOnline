package dao;

import common.RequestParam.QuizMetaParam;
import dto.QuizMetaDTO;
import dto.SubjectDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseUtil;


/**
 *
 * @author andtpse62827
 */
public class QuizMetaDAO {
    private static final String GET_QUIZ_META_BY_SUBJECT_ID = "SELECT quiz_meta_id, "
            + "subject.subject_id, subject.subject_name, "
            + "title, quiz_meta.is_active, question_no, duration "
            + "FROM quiz_online.quiz_meta "
            + "INNER JOIN subject USING (subject_id) "
            + "WHERE subject_id = ?";
    
    public List<QuizMetaDTO> getQuizMetaBySubjectId(int subjectId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuizMetaDTO> quizMetaList = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUIZ_META_BY_SUBJECT_ID);
                ps.setInt(1, subjectId);
                
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    quizMetaList.add(mapResultSetToQuizMetaDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizMetaList;
    }
    
    private QuizMetaDTO mapResultSetToQuizMetaDTO(ResultSet rs) 
            throws SQLException {
        int quizMetaId = rs.getInt(QuizMetaParam.QUIZ_META_ID);
        
        int subjectId = rs.getInt(QuizMetaParam.SUBJECT_ID);
        String subjectName = rs.getString(QuizMetaParam.SUBJECT_NAME);
        SubjectDTO subject = new SubjectDTO(subjectId, subjectName);
        
        String title = rs.getString(QuizMetaParam.TITLE);
        boolean isActive = rs.getBoolean(QuizMetaParam.IS_ACTIVE);
        int questionNo = rs.getInt(QuizMetaParam.QUESTION_NO);
        int duration = rs.getInt(QuizMetaParam.DURATION);
        
        return new QuizMetaDTO(quizMetaId, subject, 
                title, isActive, questionNo, duration);
    }
}
