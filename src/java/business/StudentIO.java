
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josepharcelo
 */
public class StudentIO
{
    public static boolean addStudent(Student student, String path) {
        try {
            File file = new File(path);
            PrintWriter out = new PrintWriter(
                              new FileWriter(file, true));
            out.println(student.toString());
            out.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static ArrayList<Student> getStudentList(String path)
            throws IOException {
        ArrayList<Student> slist = new ArrayList<>();
        
        String s;
        BufferedReader in = new BufferedReader(
                            new FileReader( new File(path)));
        Scanner scan = new Scanner(new File(path));

        while((s = in.readLine()) != null) {
            String[] entries = s.split(",");
            Student newStudent = new Student(
                entries[0], entries[1], entries[2], Double.parseDouble(entries[3]), Double.parseDouble(entries[4]),
                Double.parseDouble(entries[5]), Double.parseDouble(entries[6]), Double.parseDouble(entries[7]),
                Double.parseDouble(entries[8]), Double.parseDouble(entries[9]), Double.parseDouble(entries[10]),
                Double.parseDouble(entries[11]), Double.parseDouble(entries[12]), Double.parseDouble(entries[13]),
                entries[14]);
            slist.add(newStudent);
        }
        in.close();
        return slist;
    }
}
