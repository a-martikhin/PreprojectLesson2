package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao USERDAO = new UserDaoJDBCImpl();

    public void createUsersTable() {

        USERDAO.createUsersTable();
    }

    public void dropUsersTable() {

        USERDAO.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

        USERDAO.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

        USERDAO.removeUserById(id);
    }

    public List<User> getAllUsers() {

        List<User> userList = USERDAO.getAllUsers();
        System.out.println(userList);
        return userList;
    }

    public void cleanUsersTable() {

        USERDAO.cleanUsersTable();
    }
}