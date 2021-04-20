package dto;

import enums.Role;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author andtpse62827
 */
public class UserDTO implements Serializable {
    private String email;
    private String password;
    private String fullname;
    private RoleDTO role;
    private StatusDTO status;
    private Date createAt;

    public UserDTO() {
    }

    public UserDTO(String email, String password, String fullname, RoleDTO role, StatusDTO status, Date createAt) {
        this(email, password, fullname, role, status);
        this.createAt = createAt;
    }

    public UserDTO(String email, String password, String fullname, RoleDTO role, StatusDTO status) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }
    
    public UserDTO(String email, String fullname, RoleDTO role, StatusDTO status) {
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    
    public boolean isAdmin() {
        return this.role.getRoleId() == Role.ADMIN.roleId;
    }
    
    public boolean isStudent() {
        return this.role.getRoleId() == Role.STUDENT.roleId;
    }
}
