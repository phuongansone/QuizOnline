package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andtpse62827
 */
public class QuestionDTO implements Serializable {
    private int questionId;
    private SubjectDTO subject;
    private String questionContent;
    private boolean isActive;
    private Date createAt;
    private Date updateAt;
    private UserDTO createBy;
    private UserDTO updateBy;
    private List<AnswerDTO> answers;

    public QuestionDTO() {
        this.answers = new ArrayList();
    }
    
    public QuestionDTO(int questionId) {
        this.answers = new ArrayList();
        this.questionId = questionId;
    }

    public QuestionDTO(int questionId, SubjectDTO subject, String questionContent, 
            boolean isActive, Date createAt, Date updateAt, UserDTO createBy, UserDTO updateBy) {
        this.answers = new ArrayList();
        this.questionId = questionId;
        this.subject = subject;
        this.questionContent = questionContent;
        this.isActive = isActive;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public QuestionDTO(SubjectDTO subject, String questionContent, boolean isActive, 
            UserDTO createBy, UserDTO updateBy) {
        this.answers = new ArrayList();
        this.subject = subject;
        this.questionContent = questionContent;
        this.isActive = isActive;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public UserDTO getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UserDTO createBy) {
        this.createBy = createBy;
    }

    public UserDTO getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UserDTO updateBy) {
        this.updateBy = updateBy;
    }
    
    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
