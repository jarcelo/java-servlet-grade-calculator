
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
        
        try {
            String sID = request.getParameter("studentID");
            if (sID == null || sID.isEmpty()) {
                errorMessage += "Please enter student ID.<br>";
            }
            else {
                student.setStudentID(sID);
            }
        } catch(Exception e) {
            errorMessage += "Invalid entry found in student ID.<br>";
        }  
        // First Name
        try {
            String fName = request.getParameter("firstName");
            if (fName == null || fName.isEmpty()) {
                errorMessage += "Please enter first name.<br>";
            }
            else {
                student.setFirstName(fName);
            }
        } catch(Exception e) {
            errorMessage += "Invalid entry found in first name.<br>";
        }  
        // Last Name
        try {
            String lName = request.getParameter("lastName");
            if (lName == null || lName.isEmpty()) {
                errorMessage += "Please enter last name.<br>";
            }
            else {
                student.setLastName(lName);
            }
        } catch(Exception e) {
            errorMessage += "Invalid entry found in last name.<br>";
        }  
        // Quiz 1
        try {
            String q1 = request.getParameter("quiz1");
            if (!q1.isEmpty()) {
                double score = Double.parseDouble(q1);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuiz1(score);
                }
            } else {
                errorMessage += "Quiz 1 is required. <br>";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Quiz value is invalid: " + e.getMessage() + "<br>";
        }
        // Quiz 2
        try {
            String q2 = request.getParameter("quiz2");
            if (!q2.isEmpty()) {
                Double score = Double.parseDouble(q2);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuiz2(score);
                }
            } else {
                errorMessage += "Quiz 2 is required. <br>";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Quiz 2 is invalid: " + e.getMessage() + "<br>";
        }
        // Quiz 3
        try {
            String q3 = request.getParameter("quiz3");
            if (!q3.isEmpty()) {
                Double score = Double.parseDouble(q3);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuiz3(score);
                }
            } else {
                errorMessage += "Quiz 3 is required. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Quiz 3 is invalid: " + e.getMessage() + "<br>";
        }
        // Quiz 4
        try {
            String q4 = request.getParameter("quiz4");
            if (!q4.isEmpty()) {
                Double score = Double.parseDouble(q4);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuiz4(score);
                }
            } else {
                errorMessage += "Quiz 4 is required. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Quiz 4 is invalid: " + e.getMessage() + "<br>";
        }
        // Quiz 5
        try {
            String q5 = request.getParameter("quiz5");
            if (!q5.isEmpty()) {
                Double score = Double.parseDouble(q5);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuiz3(score);
                }
            } else {
                errorMessage += "Quiz 5 is required. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Quiz 5 is invalid: " + e.getMessage() + "<br>";
        }
        // Makeup quiz / may or may not have a value
        try {
            String mkup = request.getParameter("quizMakeUp");
            if (!mkup.isEmpty()) {
                Double score = Double.parseDouble(mkup);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setQuizMakeUp(score);
                }
            } 
        } catch (NumberFormatException e) {
            errorMessage += "Makeup quiz is invalid: " + e.getMessage() + "<br>";
        }
        // Midterm
        try {
            String mdterm = request.getParameter("midterm");
            if (!mdterm.isEmpty()) {
                Double score = Double.parseDouble(mdterm);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setMidTerm(score);
                }
            } else {
                errorMessage += "Midterm is required. <br>";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Midterm is invalid: " + e.getMessage() + "<br>";
        }
        // Problem scores
        try {
            String ps = request.getParameter("probs");
            if (!ps.isEmpty()) {
                Double score = Double.parseDouble(ps);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setProbs(score);
                }
            } else {
                errorMessage += "Problem score is required. <br>";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Problem score is invalid: " + e.getMessage() + "<br>";
        }
        // Final
        try {
            String fin = request.getParameter("final");
            if (!fin.isEmpty()) {
                Double score = Double.parseDouble(fin);
                if (score < 0) {
                    throw new NumberFormatException("Negative value.");
                }
                else {
                    student.setFinalExam(score);
                }
            } 
        } catch (NumberFormatException e) {
            errorMessage += "Final score is invalid: " + e.getMessage() + "<br>";
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
