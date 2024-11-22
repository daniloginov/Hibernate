package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/database";
    private static final String USER = "root";
    private static final String PASSWORD = "1Qwerty2";
    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";

    public static SessionFactory getSessionHibernate() {
        SessionFactory sessionFactory = new Configuration()
                .setProperties(getProperties())
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(Environment.URL, URL);
        properties.put(Environment.USER, USER);
        properties.put(Environment.PASS, PASSWORD);
        properties.put(Environment.DIALECT, DIALECT);
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "");
        return properties;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problem connecting to the database");
        }
        return connection;
    }
}