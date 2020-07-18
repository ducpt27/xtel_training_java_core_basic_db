package ptd.java_core.basic.exercise.db.b4_student_manager.model.cmd;

import ptd.java_core.basic.exercise.db.b4_student_manager.db.AbsDbCmd;

public class DbStudentInsertCmd extends AbsDbCmd {

    private String full_name;
    private String home_town;
    private int age;
    private boolean gender;

    public DbStudentInsertCmd(String full_name, int age, String home_town, boolean gender) {
        this.age = age;
        this.full_name = full_name;
        this.home_town = home_town;
        this.gender = gender;
    }

    @Override
    protected void setQuery() {
        setQuery("INSERT INTO `student`(`full_name`, `gender`, `hometown`, `age`) VALUES (?, ?, ?, ?)");
    }

    @Override
    protected void setParameter() throws Exception {
        ps.setString(1, this.full_name);
        ps.setBoolean(2, this.gender);
        ps.setString(3, this.home_town);
        ps.setInt(4, this.age);
    }

    @Override
    protected void getOutputResult() throws Exception {

    }

    @Override
    public String toString() {
        return "DbStudentInsertCmd{" +
                "age=" + age +
                ", full_name='" + (full_name == null ? "null" : full_name) +
                ", home_town='" + (home_town == null ? "null" : home_town) +
                ", gender=" + gender +
                '}';
    }
}
