package dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author andtpse62827
 */
public class QuizMetaDTO implements Serializable {
    private int quizMetaId;
    private SubjectDTO subject;
    private String title;
    private boolean active;
    private int noOfQuestion;
    private int duration;
    private Date createAt;
    private Date updateAt;

    public QuizMetaDTO() {
    }

    public QuizMetaDTO(int quizMetaId, SubjectDTO subject, String title, 
            boolean active, int noOfQuestion, int duration, Date createAt, Date updateAt) {
        this.quizMetaId = quizMetaId;
        this.subject = subject;
        this.title = title;
        this.active = active;
        this.noOfQuestion = noOfQuestion;
        this.duration = duration;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public QuizMetaDTO(int quizMetaId, SubjectDTO subject, String title, 
            boolean active, int noOfQuestion, int duration) {
        this.quizMetaId = quizMetaId;
        this.subject = subject;
        this.title = title;
        this.active = active;
        this.noOfQuestion = noOfQuestion;
        this.duration = duration;
    }

    public int getQuizMetaId() {
        return quizMetaId;
    }

    public void setQuizMetaId(int quizMetaId) {
        this.quizMetaId = quizMetaId;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNoOfQuestion() {
        return noOfQuestion;
    }

    public void setNoOfQuestion(int noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
