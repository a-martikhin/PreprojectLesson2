package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao UserDao = new UserDaoJDBCImpl();

    public void createUsersTable() {

        UserDao.createUsersTable();
    }

    public void dropUsersTable() {

        UserDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

        UserDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

        UserDao.removeUserById(id);
    }

    public List<User> getAllUsers() {

        List<User> userList = UserDao.getAllUsers();
        System.out.println(userList);
        return userList;
    }

    public void cleanUsersTable() {

        UserDao.cleanUsersTable();
    }
}