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

        userService.saveUser("name1", "lastName1", (byte) 5);
        userService.saveUser("name2", "lastName2", (byte) 10);
        userService.saveUser("name3", "lastName3", (byte) 15);
        userService.saveUser("name4", "lastName4", (byte) 20);
        userService.saveUser("name5", "lastName5", (byte) 25);

        List<User> users = userService.getAllUsers();
        System.out.println(users);

        userService.removeUserById(2);
        userService.removeUserById(4);

        userService.dropUsersTable();
    }
}
