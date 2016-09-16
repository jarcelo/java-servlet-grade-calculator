
package business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
    
    public static ArrayList<String> getStudentList(String path)
            throws IOException {
        ArrayList<String> slist = new ArrayList<>();
        
        String s;
        BufferedReader in = new BufferedReader(
                            new FileReader(path));
        s = in.readLine();
        while (s != null) {
            slist.add(s);
            s = in.readLine();
        }
        in.close();
        return slist;
    }
}
