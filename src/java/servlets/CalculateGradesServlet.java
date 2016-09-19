
package servlets;

import business.Student;
import business.StudentIO;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
    
    ArrayList<String> fieldError;
    String[] fields = {"studentID", "firstName", "lastName", "quiz1", "quiz2",
        "quiz3", "quiz4", "quiz5", "quizMakeUp", "midterm", "probs", "final"};
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        fieldError = new ArrayList<>();
        String URL = "/StudentGrade.jsp";
        String errorMessage = "";
 
        Student student = new Student();
        
        try{
            String sID = request.getParameter("studentID");
            String lName = request.getParameter("lastName");
            String fName = request.getParameter("firstName");

            if(sID.isEmpty() || lName.isEmpty() || fName.isEmpty()) {
                errorMessage += "Bad or missing ID or name.<br>";
            }
            else {
                student.setStudentID(sID);
                student.setLastName(lName);
                student.setFirstName(fName);
            }
        } catch(Exception e) {
            errorMessage += "Exception on ID or Name. <br>";
        }
        
        try {
            String sq1 = request.getParameter("quiz1");
            String quiz2 = request.getParameter("quiz2");
            if (!sq1.isEmpty()) {
                double q1 = Double.parseDouble(sq1);
                if (q1 < 0) {
                    throw new NumberFormatException("negative q1.");
                }
                else {
                    student.setQuiz1(q1);
                }
            } else {
                errorMessage += "Q1 is empty. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Q1 value is bad/invalid: " + e.getMessage() + "<br>";
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
            errorMessage += "Error in fields quizMakeup to final";
        }

        // recover values if validation error occurred
        request.setAttribute("student", student);
        
        if (!errorMessage.isEmpty()){
            URL = "/Students.jsp";
            request.setAttribute("errorMessage", errorMessage);
        }else {
            ServletContext context = getServletContext();
            String path = context.getRealPath("/WEB-INF/classlist.txt");

            if(!StudentIO.addStudent(student,path)) {
                errorMessage += "Unable to save student data.";
                request.setAttribute("errorMessage", errorMessage);
            }
        } 
        
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);    
    }
    
    private void validateInput(HttpServletRequest request, String input)
    {
        if (request != null) {
            // This has to go on a loop instead
            if (request.getParameter("studentID").trim().isEmpty()) {
                fieldError.add("Student ID is required.");
            }
            if (request.getParameter("firstName").trim().isEmpty()) {
                fieldError.add("First Name is required.");
            }
            if (request.getParameter("lastName").trim().isEmpty()) {
                fieldError.add("Last Name is required.");
            }
            if (request.getParameter("quiz1").trim().isEmpty()) {
                fieldError.add("Quiz 1 is required.");
            }
            if (request.getParameter("quiz2").trim().isEmpty()) {
                fieldError.add("Quiz 2 is required.");
            }
            if (request.getParameter("quiz3").trim().isEmpty()) {
                fieldError.add("Quiz 3 is required.");
            }
            if (request.getParameter("quiz4").trim().isEmpty()) {
                fieldError.add("Quiz 4 is required.");
            }
            if (request.getParameter("quiz5").trim().isEmpty()) {
                fieldError.add("Quiz 5 is required.");
            }
            // Makeup quiz is optional
            if (!(request.getParameter("quizMakeUp").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("quizMakeUp")) < 0)) {
                fieldError.add("Invalid entry. Makeup quiz cannot be less than zero.");
            }
            if (!(request.getParameter("midterm").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("midterm")) < 0)) {
                fieldError.add("Invalid entry. Midterm score cannot be less than zero.");
            }
            if (!(request.getParameter("probs").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("probs")) < 0)) {
                fieldError.add("Invalid entry. Problem score cannot be less than zero.");
            }
            // Final is Optional
            if (!(request.getParameter("final").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("final")) < 0)) {
                fieldError.add("Invalid entry. Final score cannot be less than zero.");
            }
            //return false;
        }
        //return true;
    }
    
    private boolean hasNoValidationError(HttpServletRequest request)
    {
        if (request != null) {
            if (request.getParameter("studentID").trim().isEmpty()) {
                fieldError.add("Student ID is required.");
            }
            if (request.getParameter("firstName").trim().isEmpty()) {
                fieldError.add("First Name is required.");
            }
            if (request.getParameter("lastName").trim().isEmpty()) {
                fieldError.add("Last Name is required.");
            }
            if (request.getParameter("quiz1").trim().isEmpty()) {
                fieldError.add("Quiz 1 is required.");
            }
            if (request.getParameter("quiz2").trim().isEmpty()) {
                fieldError.add("Quiz 2 is required.");
            }
            if (request.getParameter("quiz3").trim().isEmpty()) {
                fieldError.add("Quiz 3 is required.");
            }
            if (request.getParameter("quiz4").trim().isEmpty()) {
                fieldError.add("Quiz 4 is required.");
            }
            if (request.getParameter("quiz5").trim().isEmpty()) {
                fieldError.add("Quiz 5 is required.");
            }
            // Makeup quiz is optional
            if (!(request.getParameter("quizMakeUp").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("quizMakeUp")) < 0)) {
                fieldError.add("Invalid entry. Makeup quiz cannot be less than zero.");
            }
            if (!(request.getParameter("midterm").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("midterm")) < 0)) {
                fieldError.add("Invalid entry. Midterm score cannot be less than zero.");
            }
            if (!(request.getParameter("probs").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("probs")) < 0)) {
                fieldError.add("Invalid entry. Problem score cannot be less than zero.");
            }
            // Final is Optional
            if (!(request.getParameter("final").isEmpty()) &&
                    (Double.parseDouble(request.getParameter("final")) < 0)) {
                fieldError.add("Invalid entry. Final score cannot be less than zero.");
            }
            return false;
        }
        return true;
    }
    
    // changed boolean to void
    private static void setValue(Object object, String fieldName, Object fieldValue) 
            throws NoSuchFieldException, IllegalAccessException {
        
        Class<?> studentClass = object.getClass();
        while(studentClass != null){
            Field field = studentClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, fieldValue);
            //return true;
        } 
        //return false;
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
