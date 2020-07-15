package ptd.java_core.basic.exercise.db.b4_student_manager.model.cmd;

import com.xtel.training.ptd.java_core.basic.exercise.db.b4_student_manager.db.AbsDbCmd;

import java.sql.ResultSet;

public class DbStudentNameExistCmd extends AbsDbCmd {

    private boolean nameIsExist = false;
    private String full_name;

    public DbStudentNameExistCmd(String full_name) {
        this.full_name = full_name;
    }

    @Override
    protected void setQuery() {
        setQuery("SELECT COUNT(id) as total_count FROM Student WHERE full_name = ?");
    }

    @Override
    protected void setParameter() throws Exception {
        ps.setString(1, full_name);
    }

    @Override
    protected void getOutputResult() throws Exception {
        ResultSet rs = null;
        try {
            rs = ps.getResultSet();
            if (rs != null) {
                while (rs.next()) {
                    int total_count = rs.getInt("total_count");
                    if (total_count > 0) {
                        this.nameIsExist = true;
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null)
                rs.close();
        }
    }

    public boolean isNameIsExist() {
        return nameIsExist;
    }

    @Override
    public String toString() {
        return "DbStudentNameExistCmd{" +
                "nameIsExist=" + nameIsExist +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
