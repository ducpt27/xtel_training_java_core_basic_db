package ptd.java_core.basic.exercise.db.b4_student_manager.db;


import com.xtel.training.ptd.java_core.basic.exercise.db.b4_student_manager.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String dbType;
    private static String url;
    private static String userName;
    private static String password;

    static {
        dbType = DbConfig.DB_TYPE;
        url = DbConfig.DB_URL;
        userName = DbConfig.USER_NAME;
        password = DbConfig.PASSWORD;
    }

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, userName, password);
    }
}
