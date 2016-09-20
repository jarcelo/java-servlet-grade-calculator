<%-- 
    Document   : ClassList
    Created on : Sep 6, 2016, 1:53:31 PM
    Author     : josepharcelo
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="business.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
        <!-- Latest compiled and minified CSS for Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>
       
        <h2 class="text-center">Students on File</h2>
        <br>
        <table class="table">
            <tr class="active">
                <th>Student No.</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Quiz 1</th>
                <th>Quiz 2</th>
                <th>Quiz 3</th>
                <th>Quiz 4</th>
                <th>Quiz 5</th>
                <th>Makeup Quiz</th>
                <th>Midterm</th>
                <th>Prob Score</th>
                <th>Final</th>
                <th>Quiz Avg</th>
                <th>Course Avg</th>
                <th>Grade</th>

            </tr>
        <%
            NumberFormat formatter = new DecimalFormat("#0.00");
            ArrayList<Student> studentList = (ArrayList<Student>)
                        request.getAttribute("studentList");
            for(int i = 0; i < studentList.size(); i++) {
        %>
        <tr>
            <td><%= studentList.get(i).getStudentID() %> </td>
            <td><%= studentList.get(i).getLastName() %> </td>
            <td><%= studentList.get(i).getFirstName() %> </td>
            <td><%= studentList.get(i).getQuiz1() %> </td>
            <td><%= studentList.get(i).getQuiz2() %> </td>
            <td><%= studentList.get(i).getQuiz3() %> </td>
            <td><%= studentList.get(i).getQuiz4() %> </td>
            <td><%= studentList.get(i).getQuiz5() %> </td>
            <td><%= studentList.get(i).getQuizMakeUp() %> </td>
            <td><%= studentList.get(i).getMidTerm() %> </td>
            <td><%= studentList.get(i).getProbs() %> </td>
            <td><%= studentList.get(i).getFinalExam() %> </td>
            <td><%= formatter.format(studentList.get(i).getQuizAvg()) %> </td>
            <td><%= formatter.format(studentList.get(i).getCourseAvg()) %> </td>
            <td><%= studentList.get(i).getLetterGrade() %> </td>

        </tr>
        <% } %>
            
        </table>
        <div>
            <a href="Students.jsp">Return to student input</a>
        </div>
    </body>
</html>
