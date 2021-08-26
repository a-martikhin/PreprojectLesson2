package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createNewTable = "CREATE TABLE IF not exists users " +
                "(id BIGINT not NULL primary key auto_increment, " +
                "name VARCHAR(255), " +
                "lastName VARCHAR (255), " +
                "age TINYINT not NULL)";

        try(Connection connection = Util.connectToBase()){
            connection.prepareStatement(createNewTable).execute();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {

        String dropTable = "DROP TABLE IF EXISTS users";

        try(Connection connection = Util.connectToBase()){
            connection.prepareStatement(dropTable).execute();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        String insertUser = "INSERT INTO users(name, lastName, age) " +
                "VALUES ('"+ name +"', '" + lastName + "', '" + age + "' ) ";

        try(Connection connection = Util.connectToBase()){
            connection.prepareStatement(insertUser).execute();

            System.out.println("User с именем - " + name + " добавлен в базу данных");

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {

        String deletUser = "DELETE FROM users where ID= " + id;

        try(Connection connection = Util.connectToBase()){
            connection.prepareStatement(deletUser).execute();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        String command = "SELECT * FROM users ";
        try(Connection connection = Util.connectToBase()){
            ResultSet resultSet = connection.prepareStatement(command).executeQuery();
            while(resultSet.next()){
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                User temp = new User(name, lastName, age);
                temp.setId(id);
                user.add(temp);

            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return user;
    }

    public void cleanUsersTable() {
        String cleanTable = "TRUNCATE TABLE users";

        try(Connection connection = Util.connectToBase()){
            connection.prepareStatement(cleanTable).execute();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }
}
