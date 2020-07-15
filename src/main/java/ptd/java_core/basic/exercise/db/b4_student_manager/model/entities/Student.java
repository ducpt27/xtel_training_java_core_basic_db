package ptd.java_core.basic.exercise.db.b4_student_manager.model.entities;

public class Student {

    private String full_name;
    private String hometown;
    private int age;
    private boolean gender;

    public Student() {
    }

    public Student(String full_name, String hometown, int age, boolean gender) {
        this.full_name = full_name;
        this.hometown = hometown;
        this.age = age;
        this.gender = gender;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}