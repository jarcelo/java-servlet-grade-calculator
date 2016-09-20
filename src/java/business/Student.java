
package business;

import java.util.Arrays;

/**
 *
 * @author josepharcelo
 */
public class Student
{
    private String studentID, firstName, lastName;
    private double quiz1, quiz2, quiz3, quiz4, quiz5, quizMakeUp;
    private double midTerm, probs, finalExam;
    private double quizAvg, courseAvg;
    private String letterGrade;
    public boolean built;
    
    public Student() {
        studentID = "";
        firstName = "";
        lastName = "";
        quiz1 = 0;
        quiz2 = 0;
        quiz3 = 0;
        quiz4 = 0;
        quiz5 = 0;
        quizMakeUp = 0;
        midTerm = 0;
        probs = 0;
        finalExam = 0;
        quizAvg = 0;
        courseAvg = 0;
        letterGrade = "N/A";
        built = false;
        
    }
    
    public Student(String studentID, String firstName, String lastName, double quiz1, double quiz2, double quiz3, double quiz4,
            double quiz5, double quizMakeUp, double midTerm, double probs, double finalExam, double quizAvg, double courseAvg,
            String letterGrade) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.quiz5 = quiz5;
        this.quizMakeUp = quizMakeUp;
        this.midTerm = midTerm;
        this.probs = probs;
        this.finalExam = finalExam;
        this.quizAvg = quizAvg;
        this.courseAvg = courseAvg;
        this.letterGrade = letterGrade;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public double getQuiz1()
    {
        return quiz1;
    }

    public void setQuiz1(double quiz1)
    {
        this.quiz1 = quiz1;
    }

    public double getQuiz2()
    {
        return quiz2;
    }

    public void setQuiz2(double quiz2)
    {
        this.quiz2 = quiz2;
    }

    public double getQuiz3()
    {
        return quiz3;
    }

    public void setQuiz3(double quiz3)
    {
        this.quiz3 = quiz3;
    }

    public double getQuiz4()
    {
        return quiz4;
    }

    public void setQuiz4(double quiz4)
    {
        this.quiz4 = quiz4;
    }

    public double getQuiz5()
    {
        return quiz5;
    }

    public void setQuiz5(double quiz5)
    {
        this.quiz5 = quiz5;
    }

    public double getQuizMakeUp()
    {
        return quizMakeUp;
    }

    public void setQuizMakeUp(double quizMakeUp)
    {
        this.quizMakeUp = quizMakeUp;
    }

    public double getMidTerm()
    {
        return midTerm;
    }

    public void setMidTerm(double midTerm)
    {
        this.midTerm = midTerm;
    }

    public double getProbs()
    {
        return probs;
    }

    public void setProbs(double probs)
    {
        this.probs = probs;
    }

    public double getFinalExam()
    {
        return finalExam;
    }

    public void setFinalExam(double finalExam)
    {
        this.finalExam = finalExam;
    }

    public double getQuizAvg()
    {
        if (!built) {
            calcStudent();
        }
        return quizAvg;
    }

    public double getCourseAvg()
    {
        if (!built) {
            calcStudent();
        }
        return courseAvg;
    }

    public String getLetterGrade()
    {
        if (!built) {
            calcStudent();
        }
        return letterGrade;
    }

    private void calcStudent()
    {
        try {
            double[] quizScore = {quiz1, quiz2, quiz3, quiz4, quiz5, quizMakeUp};
            Arrays.sort(quizScore);
            quizAvg = (quizScore[2] + quizScore[3] + quizScore[4] + quizScore[5]) / 4.0;

            if (quizAvg >= 89.5 && midTerm >= 89.5 && probs >= 89.5) {
                courseAvg = (quizAvg + midTerm + probs) / 3.0;
                letterGrade = "A";
            }
            else {
                courseAvg = (quizAvg * .5) + (midTerm * .15) + (probs * .1) + (finalExam * .25);
                if (courseAvg >= 89.5) {
                    letterGrade = "A";
                }
                else if (courseAvg >= 79.5) {
                    letterGrade = "B";
                }
                else if (courseAvg >= 69.5) {
                    letterGrade = "C";
                }
                else if (courseAvg >= 59.5) {
                    letterGrade = "D";
                }
                else {
                    letterGrade = "F";
                }
            }
            built = true;
        } catch(Exception e) {
            built = false;
        }
    }
    
    @Override
    public String toString(){
        calcStudent();
        String s = studentID + "," + lastName + "," + firstName + "," +
                    quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4 + "," +
                    quiz5 + "," + quizMakeUp + "," + midTerm + "," + 
                    probs + "," + finalExam + "," + quizAvg + "," + 
                    courseAvg + "," + letterGrade ;
        return s;
     }
}


