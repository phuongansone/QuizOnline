package dto;

import java.io.Serializable;

/**
 *
 * @author andtpse62827
 */
public class StatusDTO implements Serializable {
    private int statusId;
    private String statusName;

    public StatusDTO() {
    }

    public StatusDTO(int statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    
}
