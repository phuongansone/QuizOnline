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
import java.util.ArrayList;
import java.util.List;
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
    
    private static final String UPDATE_QUIZ_SCORE = "UPDATE quiz SET score = ?, "
            + "is_active = ? WHERE quiz_id = ?";
    
    private static final String GET_BY_EMAIL = "SELECT quiz_id, email, score, "
            + "q.is_active, q.create_at, q.update_at, "
            + "s.subject_id, s.subject_name, "
            + "qm.title, qm.question_no, qm.duration "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s "
            + "ON qm.subject_id = s.subject_id "
            + "WHERE q.email = ? "
            + "LIMIT ?, ?";
    
    private static final String COUNT_BY_EMAIL = "SELECT count(*) FROM quiz q WHERE q.email = ?";
    
    private static final String GET_BY_SUBJECT_ID = "SELECT quiz_id, email, score, "
            + "q.is_active, q.create_at, q.update_at, "
            + "s.subject_id, s.subject_name, "
            + "qm.title, qm.question_no, qm.duration "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s "
            + "ON qm.subject_id = s.subject_id "
            + "WHERE s.subject_id = ? AND email = ?"
            + "LIMIT ?, ?";
    
    private static final String COUNT_BY_SUBJECT_ID = "SELECT count(*) "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s ON qm.subject_id = s.subject_id "
            + "WHERE s.subject_id = ? AND email = ?";
    
    private static final String GET_BY_SUBJECT_NAME = "SELECT quiz_id, email, score, "
            + "q.is_active, q.create_at, q.update_at, "
            + "s.subject_id, s.subject_name, "
            + "qm.title, qm.question_no, qm.duration "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s "
            + "ON qm.subject_id = s.subject_id "
            + "WHERE s.subject_name LIKE ? AND email = ?"
            + "LIMIT ?, ?";
    
    private static final String COUNT_BY_SUBJECT_NAME = "SELECT count(*) "
            + "FROM quiz q "
            + "INNER JOIN quiz_meta qm USING (quiz_meta_id) "
            + "INNER JOIN subject s ON qm.subject_id = s.subject_id "
            + "WHERE s.subject_name LIKE ? AND email = ?";
    
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
    
    public List<QuizDTO> getQuizByEmail(String email, int off, int len) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuizDTO> quizDTOLst = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_BY_EMAIL);
                ps.setString(1, email);
                ps.setInt(2, off);
                ps.setInt(3, len);
                
                rs = ps.executeQuery();
                while(rs.next()) {
                    quizDTOLst.add(mapResultSetToQuizDTO(rs));
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizDTOLst;
    }
    
    public int countByEmail(String email) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int total = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_BY_EMAIL);
                ps.setString(1, email);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return total;
    }
    
    public List<QuizDTO> getQuizBySubjectName(String keyword, String email, 
            int off, int len) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuizDTO> quizDTOLst = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_BY_SUBJECT_NAME);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, email);
                ps.setInt(3, off);
                ps.setInt(4, len);
                
                rs = ps.executeQuery();
                while(rs.next()) {
                    quizDTOLst.add(mapResultSetToQuizDTO(rs));
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizDTOLst;
    }
    
    public int countBySubjectName(String keyword, String email) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int total = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_BY_SUBJECT_NAME);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, email);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return total;
    }
    
    public int countBySubjectId(int subjectId, String email) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int total = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_BY_SUBJECT_ID);
                ps.setInt(1, subjectId);
                ps.setString(2, email);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return total;
    }
    
    public List<QuizDTO> getQuizBySubjectId(int subjectId, String email,
            int off, int len) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuizDTO> quizDTOLst = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_BY_SUBJECT_ID);
                ps.setInt(1, subjectId);
                ps.setString(2, email);
                ps.setInt(3, off);
                ps.setInt(4, len);
                
                rs = ps.executeQuery();
                while(rs.next()) {
                    quizDTOLst.add(mapResultSetToQuizDTO(rs));
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizDTOLst;
    }
    
    public boolean updateQuizScore(QuizDTO quiz) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean updated = false;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(UPDATE_QUIZ_SCORE);
                ps.setDouble(1, quiz.getScore());
                ps.setBoolean(2, quiz.isActive());
                ps.setInt(3, quiz.getQuizId());
                
                updated = ps.executeUpdate() > 0;
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return updated;
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
