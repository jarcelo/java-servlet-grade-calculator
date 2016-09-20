<%-- 
    Document   : StudentGrade
    Created on : Sep 1, 2016, 11:08:19 PM
    Author     : josepharcelo
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="business.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade Calculation</title>
        <!-- Latest compiled and minified CSS for Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    
    <body>
        <div class="container">
            <div class="jumbotron">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2>Student Results</h2>
                        <hr>
                        <% 
                        NumberFormat formatter = new DecimalFormat("#0.00");
                        Student student = (Student) request.getAttribute("student"); 
                        %>
                        <p>
                            Student ID: <%=student.getStudentID() %> <br>
                            Name: <%= student.getFirstName() %> <%= student.getLastName() %> 
                        </p>
                        <hr>
                        <p>
                            Quiz Average: <%= formatter.format(student.getQuizAvg()) %><br>
                            Course Average: <%= formatter.format(student.getCourseAvg())%><br>
                            Letter Grade: <%= student.getLetterGrade() %>
                        </p
                        <br>
                        <br>
                        <br>
                        <div>
                            <p>
                                <br>
                                ${errorMessage}
                            </p>
                            <p><small>Quiz and course averages have been rounded off to two decimal places.</small></p>
                        </div>
                        <a href="Students.jsp">Return to student input</a>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </div>
    </body>
</html>
