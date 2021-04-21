package servlet;

import common.CommonAttribute;
import static common.CommonAttribute.QUESTION;
import static common.CommonAttribute.QUIZ_QUESTIONS;
import common.RequestMapping.QuizQuestionRequest;
import common.RequestParam.AnswerParam;
import static common.RequestParam.CURRENT;
import static common.RequestParam.INDEX;
import dto.AnswerDTO;
import dto.QuestionDTO;
import dto.QuizQuestionDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        
        int current = StringUtil.parseInt(request.getParameter(CURRENT), 0);
        List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession()
                .getAttribute(CommonAttribute.QUESTIONS);
        
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
        
        int answerId = StringUtil.parseInt(request.getParameter(AnswerParam.ANSWER_ID), -1);
        int index = Integer.parseInt(request.getParameter(INDEX));
        
        // save selected answer to session
        List<QuizQuestionDTO> quizQuestions = (List<QuizQuestionDTO>) session.getAttribute(QUIZ_QUESTIONS);
        
        QuestionDTO currentQuestion = quizQuestions.get(index).getQuestion();
        AnswerDTO selectedAnswer = currentQuestion.getAnswers()
                .stream()
                .filter((AnswerDTO ans) 
                        -> ans.getAnswerId() == answerId)
                .findFirst()
                .orElse(null);
        quizQuestions.get(index).setAnswer(selectedAnswer);
        
        session.setAttribute(CommonAttribute.QUIZ_QUESTIONS, quizQuestions);
        
        // fetch next question
        int current = Integer.parseInt(request.getParameter(CURRENT));
        List<QuestionDTO> questions = (List<QuestionDTO>) request.getSession()
                .getAttribute(CommonAttribute.QUESTIONS);
        
        QuestionDTO question = questions.get(current);
        request.setAttribute(QUESTION, question);
        
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
