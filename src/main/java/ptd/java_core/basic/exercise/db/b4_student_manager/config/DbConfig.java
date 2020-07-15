package ptd.java_core.basic.exercise.db.b4_student_manager.config;

public class DbConfig extends AbsConfig {

    public static String DB_TYPE;
    public static String DB_URL;
    public static String USER_NAME;
    public static String PASSWORD;

    public DbConfig(String pathFile) {
        super(pathFile);
    }

    public void init() throws Exception {
        execute();
    }

    @Override
    protected void loadConfig() throws Exception {
        DB_TYPE = getString("connection[0].db_type", "");
        DB_URL = getString("connection[0].url", "");
        USER_NAME = getString("connection[0].user_name", "");
        PASSWORD = getString("connection[0].password", "");
    }
}
