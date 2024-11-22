package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("name1", "lastName1", (byte) 10);
        userService.saveUser("name2", "lastName2", (byte) 20);
        userService.saveUser("name3", "lastName3", (byte) 30);
        userService.saveUser("name4", "lastName4", (byte) 40);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();

        System.out.println("all");
    }
}
