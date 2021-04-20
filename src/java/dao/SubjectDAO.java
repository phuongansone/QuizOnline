package dao;

import common.RequestParam.SubjectParam;
import dto.SubjectDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DatabaseUtil;

/**
 *
 * @author andtpse62827
 */
public class SubjectDAO {
    private static final String GET_ACTIVE_SUBJECTS = "SELECT subject_id, subject_name "
            + "FROM subject WHERE is_active = true";
    
    public List<SubjectDTO> getActiveSubjects() 
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<SubjectDTO> subjects = new ArrayList<>();
        
        try {
            conn = DatabaseUtil.makeConnection();
            
            if (conn != null) {
                ps = conn.prepareStatement(GET_ACTIVE_SUBJECTS);
                rs = ps.executeQuery();
                
                while(rs.next()) {
                    subjects.add(mapResultSetToSubjectDTO(rs));
                }
            }
        } finally {
            DatabaseUtil.closeConnection(conn, ps, rs);
        }
        
        return subjects;
    }
    
    private SubjectDTO mapResultSetToSubjectDTO(ResultSet rs) throws SQLException {
        int subjectId = rs.getInt(SubjectParam.SUBJECT_ID);
        String subjectName = rs.getString(SubjectParam.SUBJECT_NAME);
        
        return new SubjectDTO(subjectId, subjectName);
    }
}
