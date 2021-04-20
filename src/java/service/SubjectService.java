package service;

import dao.SubjectDAO;
import dto.SubjectDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author andtpse62827
 */
public class SubjectService {
    private final SubjectDAO subjectDAO;

    public SubjectService() {
        subjectDAO = new SubjectDAO();
    }
    
    public List<SubjectDTO> getActiveSubjects() 
            throws ClassNotFoundException, SQLException {
        return subjectDAO.getActiveSubjects();
    }
}
