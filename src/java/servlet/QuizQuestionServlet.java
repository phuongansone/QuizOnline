package servlet;

import common.CommonAttribute;
import static common.CommonAttribute.QUESTION;
import common.RequestMapping.QuizQuestionRequest;
import common.RequestMapping.SubjectListRequest;
import static common.RequestParam.CURRENT;
import dto.QuestionDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.QuizQuestionService;
import util.StringUtil;

/**
 *
 * @author andtpse62827
 */
public class QuizQuestionServlet extends HttpServlet {

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
        
        int current = StringUtil.parseInt(request.getParameter(CURRENT), 0);
        List<QuestionDTO> questions = (List<QuestionDTO>) session.getAttribute(CommonAttribute.QUESTIONS);
        
        // if there is no questions to load
        if (questions == null) {
            response.sendRedirect(SubjectListRequest.ACTION);
            return;
        }
        
        QuestionDTO currentQuestion = questions.get(current);
        request.setAttribute(QUESTION, currentQuestion);
        
        request.getRequestDispatcher(QuizQuestionRequest.VIEW).forward(request, response);
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
        
        // save selected answer to session
        QuizQuestionService quizQuestionService = new QuizQuestionService();
        session.setAttribute(CommonAttribute.QUIZ_QUESTIONS, 
                quizQuestionService.updateAnswerToQuizQuestion(request));
        
        // fetch next question
        request.setAttribute(QUESTION, quizQuestionService.getNextQuestion(request));
        
        request.getRequestDispatcher(QuizQuestionRequest.VIEW)
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
