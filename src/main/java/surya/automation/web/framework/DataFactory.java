package surya.automation.web.framework;

import surya.automation.utils.DBManager;

import java.sql.SQLException;

public class DataFactory {
    DBManager obj = DBManager.getInstance();

    public DataFactory() throws SQLException, ClassNotFoundException {
    }
}
