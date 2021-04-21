package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author andtpse62827
 */
public class QuizDTO implements Serializable {
    private int quizId;
    private String email;
    private double score;
    private boolean active;
    private Date createAt;
    private Date updateAt;
    private QuizMetaDTO quizMeta;

    public QuizDTO(int quizId, String email, double score, boolean active, 
            Date createAt, Date updateAt, QuizMetaDTO quizMeta) {
        this.quizId = quizId;
        this.email = email;
        this.score = score;
        this.active = active;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.quizMeta = quizMeta;
    }

    public QuizDTO(String email, double score, boolean active, QuizMetaDTO quizMeta) {
        this.email = email;
        this.score = score;
        this.active = active;
        this.quizMeta = quizMeta;
    }

    public QuizDTO() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public QuizMetaDTO getQuizMeta() {
        return quizMeta;
    }

    public void setQuizMeta(QuizMetaDTO quizMeta) {
        this.quizMeta = quizMeta;
    }
    
    
}
