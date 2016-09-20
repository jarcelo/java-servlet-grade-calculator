
<!DOCTYPE HTML >

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Grades</title>
        <!-- Latest compiled and minified CSS for Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Student Grades Input</h1>
            <hr>
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
                <input class="form-control text-center" type="submit" value="Calculate Grade">
        </form>
        
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3">
                            <table width="600px" border="0" cellspacing="1" cellpadding="2">
                                <form action="ClassList" method="post" name="Classlist">
                                    <hr>
                                    <tr><td><input class="form-control" type="submit" value="View Class List"></td></tr>
                                </form>
                            </table>
                        </div>
                    </div>  
                
        <br>
        
        <div>
            ${errorMessage}
        </div>
        </div>
    </body>
</html>
