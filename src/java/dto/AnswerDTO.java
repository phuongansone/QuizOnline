package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author andtpse62827
 */
public class AnswerDTO implements Serializable {
    private int answerId;
    private QuestionDTO question;
    private String answerContent;
    private boolean isCorrect;
    private Date createAt;
    private Date updateAt;

    public AnswerDTO() {
    }

    public AnswerDTO(int answerId, QuestionDTO question, String answerContent, 
            boolean isCorrect, Date createAt, Date updateAt) {
        this.answerId = answerId;
        this.question = question;
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public AnswerDTO(QuestionDTO question, String answerContent, boolean isCorrect) {
        this.question = question;
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    
}
