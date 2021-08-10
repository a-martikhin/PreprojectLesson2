package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connectToBase() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

