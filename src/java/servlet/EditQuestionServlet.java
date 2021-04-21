package servlet;

import common.CommonAttribute;
import static common.CommonAttribute.ERROR;
import static common.CommonAttribute.QUESTION;
import static common.CommonAttribute.SUBJECTS;
import common.RequestMapping.EditQuestionRequest;
import common.RequestParam.QuestionParam;
import dto.QuestionDTO;
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
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class EditQuestionServlet extends HttpServlet {

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
        
        int questionId = StringUtil.parseInt(request.getParameter(QuestionParam.QUESTION_ID), -1);
        QuestionService questionService = new QuestionService();
        SubjectService subjectService = new SubjectService();
        
        QuestionDTO question = null;
        List<SubjectDTO> subjects = null;
        
        try {
            question = questionService.getQuestionById(questionId);
            subjects = subjectService.getActiveSubjects();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute(ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(QUESTION, question);
        request.setAttribute(SUBJECTS, subjects);
        request.getRequestDispatcher(EditQuestionRequest.VIEW)
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
        SubjectService subjectService = new SubjectService();
        
        int questionId = StringUtil.parseInt(
                request.getParameter(QuestionParam.QUESTION_ID), -1);
        QuestionDTO question = null;
        List<SubjectDTO> subjects = null;
        
        try {
            // update question
            questionService.updateQuestionAndAnswerById(request);
            
            // reload data
            question = questionService.getQuestionById(questionId);
            subjects = subjectService.getActiveSubjects();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute(ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(QUESTION, question);
        request.setAttribute(SUBJECTS, subjects);
        request.getSession().setAttribute(CommonAttribute.UPDATED, Boolean.TRUE);
        
        request.getRequestDispatcher(EditQuestionRequest.VIEW)
                .forward(request, response);
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
