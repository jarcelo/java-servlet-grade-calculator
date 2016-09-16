
package servlets;

import business.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josepharcelo
 */
public class CalculateGradesServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String URL = "/StudentGrade.jsp";
        String errorMsg = "";
 
        Student student = new Student();
        
        try{
            String sID = request.getParameter("studentID");
            String lName = request.getParameter("lastName");
            String fName = request.getParameter("firstName");

            if(sID.isEmpty() || lName.isEmpty() || fName.isEmpty()) {
                errorMsg += "Bad or missing ID or name.<br>";
            }
            else {
                student.setStudentID(sID);
                student.setLastName(lName);
                student.setFirstName(fName);
            }
        } catch(Exception e) {
            errorMsg += "Exception on ID or Name. <br>";
        }
        
        
        try {
            String sq1 = request.getParameter("quiz1");
            if (!sq1.isEmpty()) {
                double q1 = Double.parseDouble(sq1);
                if (q1 < 0) {
                    throw new NumberFormatException("negative q1.");
                }
                else {
                    student.setQuiz1(q1);
                }
            } else {
                errorMsg += "Q1 is empty. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMsg += "Q1 value is bad/invalid: " + e.getMessage() + "<br>";
        }
        
        // for data pull, revise in final program
        try {
            student.setQuiz2(Double.parseDouble(request.getParameter("quiz2")));
            student.setQuiz3(Double.parseDouble(request.getParameter("quiz3")));
            student.setQuiz4(Double.parseDouble(request.getParameter("quiz4")));
            student.setQuiz5(Double.parseDouble(request.getParameter("quiz5")));
            student.setQuizMakeUp(Double.parseDouble(request.getParameter("quizMakeUp"))); // may have no entry
            student.setMidTerm(Double.parseDouble(request.getParameter("midterm")));
            student.setProbs(Double.parseDouble(request.getParameter("probs")));
            student.setFinalExam(Double.parseDouble(request.getParameter("final"))); // may have no entry, students may be excused to take final exam
        } catch(Exception e){
            errorMsg += "Error in fields quizMakeup to final";
        }
        
        if (!errorMsg.isEmpty()){
            URL = "/Students.jsp";
            request.setAttribute("errorMsg", errorMsg);
        } /*else {
            //ServletContext context = getServletContext();
            //String path = context.getRealPath("/WEB-INF/classlist.txt");

            if(!StudentIO.addStudent((Student)student,path)) {  //Cast is required
                errorMsg += "Unable to save student data.";
                request.setAttribute("errorMsg", errorMsg);
            }
        }*/
        
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
