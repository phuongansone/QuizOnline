package dao;

import common.RequestParam.QuestionParam;
import common.RequestParam.SubjectParam;
import dto.QuestionDTO;
import dto.SubjectDTO;
import dto.UserDTO;
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
public class QuestionDAO {
    private static final String INSERT_QUESTION = "INSERT INTO question "
            + "(subject_id, question_content, is_active, create_by) "
            + "VALUES (?, ?, ?, ?)";
    
    private static final String GET_ALL_QUESTIONS = "SELECT question_id, "
            + "subject_id, subject_name, "
            + "question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question "
            + "INNER JOIN subject USING (subject_id) "
            + "ORDER BY question_content LIMIT ?, ?";
    
    private static final String COUNT_ALL_QUESTIONS = "SELECT count(*) FROM question";
    
    private static final String GET_QUESTIONS_BY_NAME = "SELECT question_id, subject_id, "
            + "subject_name, question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question INNER JOIN subject USING (subject_id) "
            + "WHERE question_content LIKE ? "
            + "ORDER BY question_content LIMIT ?, ?";
    
    private static final String COUNT_QUESTIONS_BY_NAME = "SELECT count(*) "
            + "FROM question WHERE question_content LIKE ?";
    
    private static final String GET_QUESTIONS_BY_STATUS = "SELECT question_id, subject_id, "
            + "subject_name, question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question "
            + "INNER JOIN subject USING (subject_id) "
            + "WHERE question.is_active = ? "
            + "ORDER BY question_content LIMIT ?, ?";
    
    private static final String COUNT_QUESTIONS_BY_STATUS = "SELECT count(*) "
            + "FROM question WHERE question.is_active = ?";
    
    private static final String GET_QUESTIONS_BY_SUBJECT = "SELECT question_id, subject_id, "
            + "subject_name, question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question "
            + "INNER JOIN subject USING (subject_id) "
            + "WHERE question.subject_id = ? "
            + "ORDER BY question_content LIMIT ?, ?";
    
    private static final String COUNT_QUESTION_BY_SUBJECT = "SELECT count(*) "
            + "FROM question WHERE question.subject_id = ?";
    
    private static final String GET_QUESTION_BY_ID = "SELECT question_id, subject_id, "
            + "subject_name, question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question "
            + "INNER JOIN subject USING (subject_id) "
            + "WHERE question.question_id = ?";
    
    private static final String UPDATE_QUESTION_BY_ID = "UPDATE question "
            + "SET subject_id = ?, "
            + "question_content = ?, "
            + "is_active = ?, "
            + "update_by = ? "
            + "WHERE question_id = ?";
    
    private static final String UPDATE_QUESTION_STATUS = "UPDATE question "
            + "SET is_active = ? WHERE question_id = ?";
    
    private static final String GET_RANDOM_QUESTIONS = "SELECT question_id, subject_id, "
            + "subject_name, question_content, question.is_active, "
            + "create_at, create_by, update_at, update_by "
            + "FROM question "
            + "INNER JOIN subject USING (subject_id) "
            + "WHERE question.subject_id = ? AND question.is_active = 1 "
            + "ORDER BY RAND() LIMIT ?";
    
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
    
    public List<QuestionDTO> getAllQuestions(int off, int len) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuestionDTO> questions = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_ALL_QUESTIONS);
                
                ps.setInt(1, off);
                ps.setInt(2, len);
                
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    questions.add(mapResultSetToQuestionDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return questions;
    }
    
    public int countAllQuestions() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int noOfQuestion = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_ALL_QUESTIONS);
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    noOfQuestion = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return noOfQuestion;
    }
    
    public List<QuestionDTO> getQuestionsByName(String keyword, int off, int len) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuestionDTO> questions = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUESTIONS_BY_NAME);
                
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, off);
                ps.setInt(3, len);
                
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    questions.add(mapResultSetToQuestionDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return questions;
    }
    
    public int countQuestionsByName(String keyword) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int noOfQuestion = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_QUESTIONS_BY_NAME);
                
                ps.setString(1, "%" + keyword + "%");
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    noOfQuestion = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return noOfQuestion;
    }
    
    public List<QuestionDTO> getQuestionsByStatus(boolean status, int off, int len) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuestionDTO> questions = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUESTIONS_BY_STATUS);
                
                ps.setBoolean(1, status);
                ps.setInt(2, off);
                ps.setInt(3, len);
                
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    questions.add(mapResultSetToQuestionDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return questions;
    }
    
    public int countQuestionsByStatus(boolean status) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int noOfQuestion = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_QUESTIONS_BY_STATUS);
                
                ps.setBoolean(1, status);
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    noOfQuestion = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return noOfQuestion;
    }
    
    public List<QuestionDTO> getQuestionBySubject(int subjectId, int off, int len) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuestionDTO> questions = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUESTIONS_BY_SUBJECT);
                
                ps.setInt(1, subjectId);
                ps.setInt(2, off);
                ps.setInt(3, len);
                
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    questions.add(mapResultSetToQuestionDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return questions;
    }
    
    public int countQuestionsBySubject(int subjectId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int noOfQuestion = 0;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(COUNT_QUESTION_BY_SUBJECT);
                
                ps.setInt(1, subjectId);
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    noOfQuestion = rs.getInt(1);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return noOfQuestion;
    }
    
    public QuestionDTO getQuestionById(int questionId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        QuestionDTO question = null;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUESTION_BY_ID);
                
                ps.setInt(1, questionId);
                
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    question = mapResultSetToQuestionDTO(rs);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return question;
    }
    
    public boolean updateQuestionById(QuestionDTO question) 
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        boolean updated = false;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(UPDATE_QUESTION_BY_ID);
                
                ps.setInt(1, question.getSubject().getSubjectId());
                ps.setString(2, question.getQuestionContent());
                ps.setBoolean(3, question.isIsActive());
                ps.setString(4, question.getUpdateBy().getEmail());
                ps.setInt(5, question.getQuestionId());
                
                updated = ps.executeUpdate() > 0;
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, null);
        }
        
        return updated;
    }
    
    public boolean updateQuestionStatus(int questionId, boolean status) 
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        boolean updated = false;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(UPDATE_QUESTION_STATUS);
                ps.setBoolean(1, status);
                ps.setInt(2, questionId);
                
                updated = ps.executeUpdate() > 0;
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, null);
        }
        
        return updated;
    }
    
    public List<QuestionDTO> getRandomQuestion(int subjectId, int noOfQuestion) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuestionDTO> questions = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_RANDOM_QUESTIONS);
                ps.setInt(1, subjectId);
                ps.setInt(2, noOfQuestion);
                
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    questions.add(mapResultSetToQuestionDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return questions;
    }
    
    private QuestionDTO mapResultSetToQuestionDTO(ResultSet rs) 
            throws SQLException {
        int subjectId = rs.getInt(SubjectParam.SUBJECT_ID);
        String subjectName = rs.getString(SubjectParam.SUBJECT_NAME);
        SubjectDTO subject = new SubjectDTO(subjectId, subjectName);
        
        int questionId = rs.getInt(QuestionParam.QUESTION_ID);
        String questionContent = rs.getString(QuestionParam.QUESTION_CONTENT);
        boolean isActive = rs.getBoolean(QuestionParam.IS_ACTIVE);
        
        Date createAt = rs.getDate(QuestionParam.CREATE_AT);
        UserDTO createBy = new UserDTO();
        createBy.setEmail(rs.getString(QuestionParam.CREATE_BY));
        
        Date updateAt = rs.getDate(QuestionParam.UPDATE_AT);
        UserDTO updateBy = new UserDTO();
        updateBy.setEmail(rs.getString(QuestionParam.UPDATE_BY));
        
        return new QuestionDTO(questionId, subject, questionContent, isActive, 
                createAt, updateAt, createBy, updateBy);
    }
}
