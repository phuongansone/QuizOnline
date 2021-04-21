package service;

import dto.QuestionDTO;
import dto.QuizDTO;
import dto.QuizQuestionDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andtpse62827
 */
public class QuizQuestionService {
    private static final double FULL_SCORE = 10;
    public List<QuizQuestionDTO> generateQuizQuestionDTO
        (List<QuestionDTO> questions, QuizDTO quiz) {
        List<QuizQuestionDTO> quizQuestions = new ArrayList<>();
        
        for (QuestionDTO question : questions) {
            quizQuestions.add(new QuizQuestionDTO(quiz, question));
        }
        
        return quizQuestions;
    }
    
    public double calculateScore(List<QuizQuestionDTO> quizQuestions) {
        double score = 0;
        
        int noOfQuestion;
        double scoreUnit;
        
        for (QuizQuestionDTO quizQuesition : quizQuestions) {
            noOfQuestion = quizQuesition.getQuiz().getQuizMeta().getNoOfQuestion();
            scoreUnit = FULL_SCORE / noOfQuestion;
            
            if (quizQuesition.getAnswer() != null && quizQuesition.getAnswer().isIsCorrect()) {
                score += scoreUnit;
            }
        }
        
        return score;
    }
    
    public double getNoOfCorrectAnswer(List<QuizQuestionDTO> quizQuestions) {
        int correctAnswer = 0;
        
        for (QuizQuestionDTO quizQuesition : quizQuestions) {
            if (quizQuesition.getAnswer() != null && quizQuesition.getAnswer().isIsCorrect()) {
                correctAnswer++;
            }
        }
        
        return correctAnswer;
    }
}
