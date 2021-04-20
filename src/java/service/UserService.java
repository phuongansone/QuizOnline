package service;

import common.RequestParam.UserParam;
import dao.UserDAO;
import dto.RoleDTO;
import dto.StatusDTO;
import dto.UserDTO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author PC
 */
public class UserService {
    private static final int DEFAULT_ROLE_ID = 1;
    private static final int DEFAULT_STATUS_ID = 1;
    
    UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }
    
    public int insertUser(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        String email = request.getParameter(UserParam.EMAIL);
        String password = DigestUtils.sha256Hex(request.getParameter(UserParam.PASSWORD));
        String fullname = request.getParameter(UserParam.FULLNAME);
        RoleDTO role = new RoleDTO(DEFAULT_ROLE_ID, null);
        StatusDTO status = new StatusDTO(DEFAULT_STATUS_ID, null);
        
        UserDTO userDTO = new UserDTO(email, password, fullname, role, status);
        
        return userDAO.insertUser(userDTO);
    }
    
    public boolean checkEmailExisted(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        String email = request.getParameter(UserParam.EMAIL);
        
        return userDAO.checkEmailExisted(email);
    }
    
    public UserDTO checkUserCredential(HttpServletRequest request) 
            throws SQLException, ClassNotFoundException {
        String email = request.getParameter(UserParam.EMAIL);
        String password = DigestUtils.sha256Hex(request.getParameter(UserParam.PASSWORD));
        return userDAO.checkUserCredential(email, password);
    }
}
