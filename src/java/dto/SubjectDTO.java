package dto;

import java.io.Serializable;

/**
 *
 * @author andtpse62827
 */
public class SubjectDTO implements Serializable {
    private int subjectId;
    private String subjectName;
    private boolean isActive;

    public SubjectDTO() {
    }

    public SubjectDTO(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public SubjectDTO(int subjectId, String subjectName, boolean isActive) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.isActive = isActive;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
