package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("name_1", "last_name_1", (byte) 10);
        userService.saveUser("name_2", "last_name_2", (byte) 20);
        userService.saveUser("name_3", "last_name_3", (byte) 30);
        userService.saveUser("name_4", "last_name_4", (byte) 40);
        userService.saveUser("name_5", "last_name_5", (byte) 50);

        List<User> users = userService.getAllUsers();
        System.out.println(users);

        userService.removeUserById(2);
        userService.removeUserById(5);

        userService.dropUsersTable();
    }
}
