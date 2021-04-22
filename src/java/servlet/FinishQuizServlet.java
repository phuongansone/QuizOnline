/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import common.CommonAttribute;
import static common.CommonAttribute.ERROR;
import common.RequestMapping.FinishQuizRequest;
import dto.QuizDTO;
import dto.QuizQuestionDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.QuizQuestionService;
import service.QuizService;

/**
 *
 * @author andtpse62827
 */
public class FinishQuizServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        // update answer
        QuizQuestionService quizQuestionService = new QuizQuestionService();
        List<QuizQuestionDTO> quizQuestions = quizQuestionService
                .updateAnswerToQuizQuestion(request);
        
        // calculate score
        QuizService quizService = new QuizService();
        QuizDTO quiz = (QuizDTO) session.getAttribute(CommonAttribute.QUIZ);
        quiz.setScore(quizQuestionService.calculateScore(quizQuestions));
        
        try {
            // save to database
            quizService.updateQuizScore(quiz);
            quizQuestionService.saveQuizQuestionList(quizQuestions);
            
            // get latest information
            quiz = quizService.getQuizById(quiz.getQuizId());
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FinishQuizServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute(ERROR, Boolean.TRUE);
        }
        
        request.setAttribute(CommonAttribute.CORRECT_ANS_NO, 
                quizQuestionService.getNoOfCorrectAnswer(quizQuestions));
        request.setAttribute(CommonAttribute.QUIZ, quiz);
        
        session.removeAttribute(CommonAttribute.QUESTIONS);
        session.removeAttribute(CommonAttribute.QUIZ);
        session.removeAttribute(CommonAttribute.QUIZ_QUESTIONS);
        session.removeAttribute(CommonAttribute.QUESTION_NO);
        
        request.getRequestDispatcher(FinishQuizRequest.VIEW).forward(request, response);
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
