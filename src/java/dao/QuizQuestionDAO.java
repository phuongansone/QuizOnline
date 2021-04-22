package dao;

import common.RequestParam.AnswerParam;
import static common.RequestParam.AnswerParam.IS_CORRECT;
import common.RequestParam.QuestionParam;
import common.RequestParam.QuizParam;
import dto.AnswerDTO;
import dto.QuestionDTO;
import dto.QuizQuestionDTO;
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
public class QuizQuestionDAO {
    private static final String INSERT_QUIZ_QUESTION = "INSERT INTO quiz_question "
            + "(quiz_id, question_id, answer_id, is_correct, score) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    private static final String GET_QUIZ_QUESTION_BY_QUIZ_ID = "SELECT q.question_id, q.question_content, "
            + "a.answer_id, qq.is_correct, qq.score "
            + "FROM quiz_question qq "
            + "INNER JOIN question q USING (question_id) "
            + "LEFT JOIN answer a USING (answer_id) "
            + "WHERE quiz_id = ?";
    
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
    
    public List<QuizQuestionDTO> getQuizQuestionByQuizId(int quizId) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<QuizQuestionDTO> quizDTOLst = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_QUIZ_QUESTION_BY_QUIZ_ID);
                ps.setInt(1, quizId);
                
                rs = ps.executeQuery();
                while(rs.next()) {
                    quizDTOLst.add(mapResultSetToQuizQuestionDTO(rs));
                }
            }
            
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return quizDTOLst;
    }
    
    private QuizQuestionDTO mapResultSetToQuizQuestionDTO(ResultSet rs) throws SQLException {
        QuizQuestionDTO quizQuestion = new QuizQuestionDTO();
        
        QuestionDTO question = new QuestionDTO();
        question.setQuestionId(rs.getInt(QuestionParam.QUESTION_ID));
        question.setQuestionContent(rs.getString(QuestionParam.QUESTION_CONTENT));
        
        AnswerDTO answer = new AnswerDTO();
        answer.setAnswerId(rs.getInt(AnswerParam.ANSWER_ID));
        
        double score = rs.getDouble(QuizParam.SCORE);
        boolean correct = rs.getBoolean(IS_CORRECT);
        
        quizQuestion.setQuestion(question);
        quizQuestion.setAnswer(answer);
        quizQuestion.setCorrect(correct);
        quizQuestion.setScore(score);
        
        return quizQuestion;
    }
    
}
