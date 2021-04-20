package servlet;

import common.CommonAttribute;
import common.RequestMapping.SearchQuestionRequest;
import static common.RequestParam.KEYWORD;
import static common.RequestParam.PAGE;
import static common.RequestParam.STATUS;
import static common.RequestParam.SUBJECT;
import dto.QuestionDTO;
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
import service.QuestionService;
import service.SubjectService;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class SearchQuestionServlet extends HttpServlet {
    private static final String RECORD_PER_PAGE = "recordPerPage";

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
        
        String keyword = request.getParameter(KEYWORD);
        String subject = request.getParameter(SUBJECT);
        String status = request.getParameter(STATUS);
        
        // get targetted page
        int page = getCurrentPage(request);
        int totalPage;
        int[] pages = null;
        List<QuestionDTO> questions = new ArrayList<>();
        List<SubjectDTO> subjects = new ArrayList<>();
        
        // get number of record per page configuration
        int recordPerPage = Integer.parseInt(request.getServletContext()
                .getInitParameter(RECORD_PER_PAGE));
        
        QuestionService questionService = new QuestionService();
        SubjectService subjectService = new SubjectService();
        
        try {
            if (keyword != null && !keyword.isBlank()) {
                totalPage = getTotalNoOfPage(
                        questionService.countQuestionsByName(keyword), recordPerPage);
                
                pages = getPagesArr(totalPage);
                int offset = (page - 1) * recordPerPage;
                
                questions = questionService.getQuestionsByName(keyword, offset, recordPerPage);
            } else if (status != null && !status.isBlank()) {
                boolean isActive = status.equalsIgnoreCase("1");
                
                totalPage = getTotalNoOfPage(
                        questionService.countQuestionsByStatus(isActive), 
                        recordPerPage);
                pages = getPagesArr(totalPage);
                int offset = (page - 1) * recordPerPage;
                
                questions = questionService.getQuestionsByStatus(isActive, offset, recordPerPage);
            } else if (subject != null && !subject.isBlank()) {
                int subjectId = StringUtil.parseInt(request.getParameter(SUBJECT), -1);
                
                totalPage = getTotalNoOfPage(
                        questionService.countQuestionsBySubject(subjectId), 
                        recordPerPage);
                pages = getPagesArr(totalPage);
                int offset = (page - 1) * recordPerPage;
                
                questions = questionService.getQuestionBySubject(subjectId, offset, recordPerPage);
            } else {
                totalPage = getTotalNoOfPage(questionService.countAllQuestions(), recordPerPage);
                pages = getPagesArr(totalPage);
                int offset = (page - 1) * recordPerPage;

                questions = questionService.getAllQuestions(offset, recordPerPage);
            }
            
            subjects = subjectService.getActiveSubjects();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchQuestionServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
            request.getSession().setAttribute(CommonAttribute.ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(CommonAttribute.PAGE, page);
        request.setAttribute(CommonAttribute.PAGES, pages);
        request.setAttribute(CommonAttribute.QUESTIONS, questions);
        request.setAttribute(CommonAttribute.SUBJECTS, subjects);
        
        request.getRequestDispatcher(SearchQuestionRequest.VIEW)
                .forward(request, response);
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
