
<!DOCTYPE HTML >

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Grades</title>
    </head>
    <body>
        <h1>Student Grades Input</h1><br/>
    <form action="CalculateGrades" method="post" name="calcgrades" id="calcgrades">
      <table width="600px" border="0" >
  		<tr>
    		<td>Student ID:</td>
    		<td>Last Name:</td>
    		<td>First Name:</td>
  		</tr>
  		<tr>
    		<td><input name="studentID" id="studentID" type="text" size="15" style="background-color:#FAFAD2" 
                           value="${student.studentID}" ></td>
    		<td><input name="lastName" id="lastName" type="text" size="30" style="background-color:#FAFAD2" 
                           value = "${student.lastName}" ></td>
    		<td><input name="firstName" id="firstName" type="text" size="30" style="background-color:#FAFAD2" 
                           value = "${student.firstName}" ></td>
  		</tr>
		</table><br />
        <table width="775px" border="0" cellspacing="1" >
		<tr>
            <td>Quiz 1:</td>
            <td>Quiz 2:</td>
            <td>Quiz 3:</td>
            <td>Quiz 4:</td>
            <td>Quiz 5:</td>
            <td>Make-Up:</td>
        </tr>
        <tr>
            <td><input name="quiz1" id="quiz1" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quiz1}" ></td>
            <td><input name="quiz2" id="quiz2" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quiz2}"></td>
            <td><input name="quiz3" id="quiz3" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quiz3}"></td>
            <td><input name="quiz4" id="quiz4" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quiz4}"></td>
            <td><input name="quiz5" id="quiz5" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quiz5}"></td>
            <td><input name="quizMakeUp" id="quizMakeUp" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.quizMakeUp > 0.0? student.quizMakeUp : "" }"></td>
        </tr>
        </table><br/>
        <table width="400px" border="0" cellspacing="1" >
		<tr>
            <td>Midterm:</td>
            <td>Probs:</td>
            <td>Final:</td>
        </tr>
        <tr>
            <td><input name="midterm" id="midterm" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.midTerm}"></td>
            <td><input name="probs" id="probs" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.probs}"></td>
            <td><input name="final" id="final" type="text" size="10" style="background-color:#FAFAD2"
                       value="${student.finalExam > 0.0? student.finalExam : ""}"></td>
        </tr>
        </table><br/>
        <input type="submit" value="Calculate Grade" style="float:left">
        </form>
                
        <table width="600px" border="0" cellspacing="1" cellpadding="2" style="float:right">
            
        <form action="ClassList" method="post" name="classlist">
        <tr><td><input type="submit" value="Class List"></td></tr>
        </form>
            
        </table>
                
        <br>
        <div>
            <p>Input validation error messages:</p>
            ${errorMessage}
        </div>
    </body>
</html>
