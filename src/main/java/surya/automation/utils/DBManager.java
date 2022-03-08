package surya.automation.utils;

import surya.automation.web.framework.AppConfig;
import java.sql.*;

/**
 * To access database following steps followed to implement the method.
 * (a) Make a connection to the DataBase
 * (b) Send Queries to the DataBase
 * (c) Process the results
 */
public class DBManager {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    private static DBManager dbMangerInstance = null;

    private DBManager() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to DataBase...");
        connection = DriverManager.getConnection(AppConfig.dbUrl, AppConfig.dbUserName, AppConfig.dbPassword);
        System.out.println("Connected to the DataBase...");
        statement = connection.createStatement();
    }

    public static DBManager getInstance() throws SQLException, ClassNotFoundException {
        if (dbMangerInstance == null) {
            dbMangerInstance = new DBManager();
        }
        return dbMangerInstance;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
