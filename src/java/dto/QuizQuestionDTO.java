package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author andtpse62827
 */
public class QuizQuestionDTO implements Serializable {
    private int quizQuestionId;
    private QuizDTO quiz;
    private QuestionDTO question;
    private AnswerDTO answer;
    private boolean correct;
    private double score;
    private Date answerAt;

    public QuizQuestionDTO() {
    }

    public QuizQuestionDTO(QuizDTO quiz, QuestionDTO question) {
        this.quiz = quiz;
        this.question = question;
    }

    public QuizQuestionDTO(int quizQuestionId, QuizDTO quiz, QuestionDTO question, 
            AnswerDTO answer, boolean correct, double score, Date answerAt) {
        this.quizQuestionId = quizQuestionId;
        this.quiz = quiz;
        this.question = question;
        this.answer = answer;
        this.correct = correct;
        this.score = score;
        this.answerAt = answerAt;
    }

    public QuizQuestionDTO(QuizDTO quiz, QuestionDTO question, AnswerDTO answer, 
            boolean correct, double score) {
        this.quiz = quiz;
        this.question = question;
        this.answer = answer;
        this.correct = correct;
        this.score = score;
    }

    public int getQuizQuestionId() {
        return quizQuestionId;
    }

    public void setQuizQuestionId(int quizQuestionId) {
        this.quizQuestionId = quizQuestionId;
    }

    public QuizDTO getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizDTO quiz) {
        this.quiz = quiz;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public AnswerDTO getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getAnswerAt() {
        return answerAt;
    }

    public void setAnswerAt(Date answerAt) {
        this.answerAt = answerAt;
    }
    
    
}
