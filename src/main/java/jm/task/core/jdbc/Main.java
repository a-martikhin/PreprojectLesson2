package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Anton", "Dubovtcev", (byte) 31);
        userService.saveUser("Marat", "Bylallov", (byte) 29);
        userService.saveUser("Sergey", "Kislyakov", (byte) 35);
        userService.saveUser("Volodya", "Triodin", (byte) 40);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}


