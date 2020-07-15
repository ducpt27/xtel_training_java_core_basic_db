package ptd.java_core.basic.exercise.db.b4_student_manager.db;

import java.sql.PreparedStatement;

public abstract class AbsDbCmd {

    protected String query;
    protected PreparedStatement ps;

    protected abstract void setQuery();

    protected abstract void setParameter() throws Exception;

    protected abstract void getOutputResult() throws Exception;

    public String getQuery() {
        return this.query;
    }

    public void setPreparedStatement(PreparedStatement ps) {
        this.ps = ps;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}