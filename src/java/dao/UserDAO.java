package dao;

import common.RequestParam.RoleParam;
import common.RequestParam.StatusParam;
import common.RequestParam.UserParam;
import dto.RoleDTO;
import dto.StatusDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DatabaseUtil;

/**
 *
 * @author PC
 */
public class UserDAO {
    private static final String INSERT_USER = "INSERT INTO user "
            + "(email, password, fullname, role_id, status_id) "
            + "VALUES (?, ?, ?, ?, ?)";
    
    private static final String CHECK_EMAIL_EXISTED = "SELECT COUNT(*) FROM user "
            + "WHERE email = ?";
    
    private static final String CHECK_USER_CREDENTIAL = "SELECT u.email, u.fullname, "
            + "r.role_id, r.role_name, s.status_id, s.status_name "
            + "FROM user u "
            + "INNER JOIN role r USING (role_id) "
            + "INNER JOIN status s USING (status_id) "
            + "WHERE email = ? && password = ?";
    
    public int insertUser(UserDTO user) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int insertedId = -1;
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFullname());
                ps.setInt(4, user.getRole().getRoleId());
                ps.setInt(5, user.getStatus().getStatusId());
                
                if (ps.executeUpdate() > 0) {
                    rs = ps.getGeneratedKeys();
                    
                    if (rs.next()) {
                        insertedId = rs.getInt(1);
                    }
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return insertedId;
    }
    
    public boolean checkEmailExisted(String email) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        boolean existed = false;
        
        try {
            conn = DatabaseUtil.makeConnection();
            if (conn != null) {
                ps = conn.prepareStatement(CHECK_EMAIL_EXISTED);
                ps.setString(1, email);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    existed = rs.getInt(1) > 0;
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return existed;
    }
    
    public UserDTO checkUserCredential(String email, String password) 
            throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        UserDTO user = null;
        
        try {
            conn = DatabaseUtil.makeConnection();
            if (conn != null) {
                ps = conn.prepareStatement(CHECK_USER_CREDENTIAL);
                ps.setString(1, email);
                ps.setString(2, password);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    user = mapResultSetToUserDTO(rs);
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return user;
    }
    
    private UserDTO mapResultSetToUserDTO(ResultSet rs) throws SQLException {
        String email = rs.getString(UserParam.EMAIL);
        String fullname = rs.getString(UserParam.FULLNAME);
        
        int roleId = rs.getInt(RoleParam.ROLE_ID);
        String roleName = rs.getString(RoleParam.ROLE_NAME);
        RoleDTO role = new RoleDTO(roleId, roleName);
        
        int statusId = rs.getInt(StatusParam.STATUS_ID);
        String statusName = rs.getString(StatusParam.STATUS_NAME);
        StatusDTO status = new StatusDTO(statusId, statusName);
        
        return new UserDTO(email, fullname, role, status);
    }
}
