package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserDao Dao;

    public UserServiceImpl() {
        //DAO = new UserDaoJDBCImpl();
        Dao = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        Dao.createUsersTable();
    }

    public void dropUsersTable() {
        Dao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        Dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        Dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return Dao.getAllUsers();
    }

    public void cleanUsersTable() {
        Dao.cleanUsersTable();
    }
}