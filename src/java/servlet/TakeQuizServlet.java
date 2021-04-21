package servlet;

import common.CommonAttribute;
import common.RequestMapping.QuizQuestionRequest;
import common.RequestParam.QuizMetaParam;
import dto.QuestionDTO;
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
import javax.servlet.http.HttpSession;
import service.QuestionService;
import service.QuizQuestionService;
import service.QuizService;
import util.StringUtil;

/**
 *
 * @author PC
 */
public class TakeQuizServlet extends HttpServlet {

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
        
        int subjectId = StringUtil.parseInt(
                request.getParameter(QuizMetaParam.SUBJECT_ID), -1);
        int noOfQuestion = StringUtil.parseInt(
                request.getParameter(QuizMetaParam.QUESTION_NO), 0);
        
        QuestionService questionService = new QuestionService();
        List<QuestionDTO> questions = new ArrayList<>();
        
        QuizService quizService = new QuizService();
        QuizDTO quiz = null;
        
        QuizQuestionService quizQuestionService = new QuizQuestionService();
        List<QuizQuestionDTO> quizQuestion = null;
        
        try {
            questions = questionService
                    .getRandomQuestion(subjectId, noOfQuestion);
            
            int quizId = quizService.insertQuiz(request);
            quiz = quizService.getQuizById(quizId);
            
            quizQuestion = quizQuestionService
                    .generateQuizQuestionDTO(questions, quiz);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TakeQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute(CommonAttribute.QUESTIONS, questions);
        session.setAttribute(CommonAttribute.QUIZ, quiz);
        session.setAttribute(CommonAttribute.QUIZ_QUESTIONS, quizQuestion);
        session.setAttribute(CommonAttribute.QUESTION_NO, noOfQuestion);
        
        response.sendRedirect(QuizQuestionRequest.ACTION);
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
