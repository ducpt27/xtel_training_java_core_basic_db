package ptd.java_core.basic.exercise.db.b4_student_manager.model.cmd;

import com.xtel.training.ptd.java_core.basic.exercise.db.b4_student_manager.db.AbsDbCmd;
import com.xtel.training.ptd.java_core.basic.exercise.db.b4_student_manager.model.entities.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbStudentGetListCmd extends AbsDbCmd {

    private List<Student> students = new ArrayList<>();

    @Override
    protected void setQuery() {
        setQuery("SELECT * FROM Student");
    }

    @Override
    protected void setParameter() throws Exception {

    }

    @Override
    protected void getOutputResult() throws Exception {
        ResultSet rs = null;
        try {
            rs = ps.getResultSet();
            if (rs != null) {
                while (rs.next()) {
                    int age = rs.getInt("age");
                    String full_name = rs.getString("full_name");
                    String hometown = rs.getString("hometown");
                    boolean gender = rs.getBoolean("gender");

                    Student obj = new Student();
                    obj.setAge(age);
                    obj.setGender(gender);
                    obj.setFull_name(full_name);
                    obj.setHometown(hometown);
                    students.add(obj);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentGetListCmd{" +
                "students.size=" + (students == null ? "null" : String.valueOf(students.size())) +
                '}';
    }
}
