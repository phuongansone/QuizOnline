package servlet;

import common.CommonAttribute;
import common.RequestMapping.QuizHistoryRequest;
import static common.RequestParam.PAGE;
import common.RequestParam.QuizMetaParam;
import dto.QuizDTO;
import dto.UserDTO;
import dto.SubjectDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.QuizService;
import service.SubjectService;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class QuizHistoryServlet extends HttpServlet {
    private static final int RECORD_PER_PAGE = 5;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(CommonAttribute.USER);
        
        int subjectId = StringUtil.parseInt(request.getParameter(QuizMetaParam.SUBJECT_ID), -1);
        String keyword = request.getParameter(QuizMetaParam.SUBJECT_NAME);
        
        // get targetted page
        int page = getCurrentPage(request);
        int totalPage;
        int[] pages = null;
        
        QuizService quizService = new QuizService();
        List<QuizDTO> quizzes = new ArrayList<>();
        
        SubjectService subjectService = new SubjectService();
        List<SubjectDTO> subjects = new ArrayList<>();
        
        try {
            if (keyword != null && !keyword.isBlank()) {
                totalPage = getTotalNoOfPage(quizService.countBySubjectName(keyword), 
                        RECORD_PER_PAGE);
                pages = getPagesArr(totalPage);
                
                int offset = (page - 1) * RECORD_PER_PAGE;
                
                quizzes = quizService.getQuizBySubjectName(keyword, offset, RECORD_PER_PAGE);
            } else if (subjectId != -1) {
                totalPage = getTotalNoOfPage(quizService.countBySubjectId(subjectId), 
                        RECORD_PER_PAGE);
                pages = getPagesArr(totalPage);
                
                int offset = (page - 1) * RECORD_PER_PAGE;
                quizzes = quizService.getQuizBySubjectId(subjectId, offset, RECORD_PER_PAGE);
            } else {
                totalPage = getTotalNoOfPage(quizService.countByEmail(user.getEmail()), 
                        RECORD_PER_PAGE);
                pages = getPagesArr(totalPage);
                
                int offset = (page - 1) * RECORD_PER_PAGE;
                quizzes = quizService.getQuizByEmail(user.getEmail(), offset, RECORD_PER_PAGE);
            }
            subjects = subjectService.getActiveSubjects();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuizHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute(CommonAttribute.ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(CommonAttribute.PAGE, page);
        request.setAttribute(CommonAttribute.PAGES, pages);
        request.setAttribute(CommonAttribute.SUBJECTS, subjects);
        request.setAttribute(CommonAttribute.QUIZZES, quizzes);
        
        request.getRequestDispatcher(QuizHistoryRequest.VIEW).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private int getCurrentPage(HttpServletRequest request) {
        return StringUtil.parseInt(request.getParameter(PAGE), 1);
    }
    
    private int[] getPagesArr(int totalPage) {
        if (totalPage <= 0) {
            return new int[0];
        }
        
        int[] pages = new int[totalPage];
        
        for (int i = 0; i < totalPage; i++) {
            pages[i] = i + 1;
        }
        return pages;
    }
    
    private int getTotalNoOfPage(int totalRecords, int recordPerPage) {
        double totalPage = (double)totalRecords / (double) recordPerPage;
        return (int)Math.ceil(totalPage);
    }
}
