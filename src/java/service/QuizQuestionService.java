package service;

import common.CommonAttribute;
import static common.CommonAttribute.QUIZ_QUESTIONS;
import common.RequestParam;
import static common.RequestParam.CURRENT;
import static common.RequestParam.INDEX;
import dao.QuizQuestionDAO;
import dto.AnswerDTO;
import dto.QuestionDTO;
import dto.QuizDTO;
import dto.QuizQuestionDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class QuizQuestionService {
    private static final double FULL_SCORE = 10;
    private final QuizQuestionDAO quizQuestionDAO;

    public QuizQuestionService() {
        quizQuestionDAO = new QuizQuestionDAO();
    }
    
    public List<QuizQuestionDTO> generateQuizQuestionDTO
        (List<QuestionDTO> questions, QuizDTO quiz) {
        List<QuizQuestionDTO> quizQuestions = new ArrayList<>();
        
        for (QuestionDTO question : questions) {
            quizQuestions.add(new QuizQuestionDTO(quiz, question));
        }
        
        return quizQuestions;
    }
        
    public List<QuizQuestionDTO> updateAnswerToQuizQuestion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        int answerId = StringUtil.parseInt(request.getParameter(RequestParam.AnswerParam.ANSWER_ID), -1);
        int index = Integer.parseInt(request.getParameter(INDEX));
        
        // save selected answer to session
        List<QuizQuestionDTO> quizQuestions = (List<QuizQuestionDTO>) session.getAttribute(QUIZ_QUESTIONS);
        
        QuestionDTO currentQuestion = quizQuestions.get(index).getQuestion();
        
        if (answerId != -1) {
            AnswerDTO selectedAnswer = currentQuestion.getAnswers()
                    .stream()
                    .filter((AnswerDTO ans) 
                            -> ans.getAnswerId() == answerId)
                    .findFirst()
                    .orElse(null);

            quizQuestions.get(index).setAnswer(selectedAnswer);            
        }
        
        return quizQuestions;
    }
    
    public QuestionDTO getNextQuestion(HttpServletRequest request) {
        int current = Integer.parseInt(request.getParameter(CURRENT));
        List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession()
                .getAttribute(CommonAttribute.QUESTIONS);
        
        return questions.get(current);
    }
    
    public double calculateScore(List<QuizQuestionDTO> quizQuestions) {
        double score = 0;
        
        int noOfQuestion;
        double scoreUnit;
        
        for (QuizQuestionDTO quizQuestion : quizQuestions) {
            noOfQuestion = quizQuestion.getQuiz().getQuizMeta().getNoOfQuestion();
            scoreUnit = FULL_SCORE / noOfQuestion;
            
            if (quizQuestion.getAnswer() != null && quizQuestion.getAnswer().isIsCorrect()) {
                quizQuestion.setScore(scoreUnit);
                score += scoreUnit;
            }
        }
        
        return score;
    }
    
    public int getNoOfCorrectAnswer(List<QuizQuestionDTO> quizQuestions) {
        int correctAnswer = 0;
        
        for (QuizQuestionDTO quizQuesition : quizQuestions) {
            if (quizQuesition.getAnswer() != null && quizQuesition.getAnswer().isIsCorrect()) {
                correctAnswer++;
            }
        }
        
        return correctAnswer;
    }
    
    public void saveQuizQuestionList(List<QuizQuestionDTO> quizQuestions) 
            throws SQLException, ClassNotFoundException {
        for (QuizQuestionDTO quizQuestion : quizQuestions) {
            quizQuestionDAO.insertQuizQuestion(quizQuestion);
        }
    }
}
