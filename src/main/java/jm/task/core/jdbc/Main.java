package jm.task.core.jdbc;

import com.mysql.cj.xdevapi.Result;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE " + "Users"+ " (id LONG, name VARCHAR(255), lastName VARCHAR(255), age TINYINT)";
        Statement statement = Util.connectToBase().createStatement();
        statement.execute(sql);
    }
    static void createTable() throws SQLException, ClassNotFoundException {

    }
}


