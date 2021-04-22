package servlet;

import common.CommonAttribute;
import static common.CommonAttribute.QUIZ;
import static common.CommonAttribute.QUIZ_QUESTIONS;
import common.RequestMapping.HistoryDetailRequest;
import common.RequestParam;
import dto.QuizDTO;
import dto.QuizQuestionDTO;
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
import service.QuizQuestionService;
import service.QuizService;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class HistoryDetailServlet extends HttpServlet {

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
        
        int quizId = StringUtil.parseInt(request.getParameter(RequestParam.QuizParam.QUIZ_ID), -1);
        QuizQuestionService quizQuestionService = new QuizQuestionService();
        QuizService quizService = new QuizService();
        
        List<QuizQuestionDTO> quizQuestions = new ArrayList<>();
        QuizDTO quiz = new QuizDTO();
        
        try {
            quizQuestions = quizQuestionService.getQuizQuestionByQuizId(quizId);
            quiz = quizService.getQuizById(quizId);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HistoryDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getSession().setAttribute(CommonAttribute.ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(QUIZ_QUESTIONS, quizQuestions);
        request.setAttribute(QUIZ, quiz);
        
        request.getRequestDispatcher(HistoryDetailRequest.VIEW)
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

}
