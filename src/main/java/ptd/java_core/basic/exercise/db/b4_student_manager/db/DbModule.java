package ptd.java_core.basic.exercise.db.b4_student_manager.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DbModule {

    private ConnectionFactory connectionFactory;

    public DbModule() {
        connectionFactory = new ConnectionFactory();
    }

    public void execute(AbsDbCmd dbCmd) throws Exception {
        Connection conn = connectionFactory.getConnection();
        dbCmd.setQuery();
        PreparedStatement ps = conn.prepareStatement(dbCmd.getQuery());
        dbCmd.setPreparedStatement(ps);
        dbCmd.setParameter();
        ps.execute();
        dbCmd.getOutputResult();
    }
}