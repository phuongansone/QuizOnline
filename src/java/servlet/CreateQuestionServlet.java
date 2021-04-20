package servlet;

import common.CommonAttribute;
import common.RequestMapping.CreateQuestionRequest;
import dto.SubjectDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.QuestionService;
import service.SubjectService;

/**
 *
 * @author andtpse62827
 */
public class CreateQuestionServlet extends HttpServlet {

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
        
        List<SubjectDTO> subjects;
        SubjectService subjectService = new SubjectService();
        
        try {
            subjects = subjectService.getActiveSubjects();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CreateQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        
        request.setAttribute(CommonAttribute.SUBJECTS, subjects);
        request.getRequestDispatcher(CreateQuestionRequest.VIEW)
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
        
        QuestionService questionService = new QuestionService();
        
        try {
            questionService.insertQuestionAndAnswer(request);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CreateQuestionServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
            request.getSession()
                    .setAttribute(CommonAttribute.INSERTED, Boolean.FALSE);
        }
        
        request.getSession()
                .setAttribute(CommonAttribute.INSERTED, Boolean.TRUE);
        
        response.sendRedirect(CreateQuestionRequest.ACTION);
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
}
