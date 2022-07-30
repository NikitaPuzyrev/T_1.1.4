package jm.task.core.jdbc.service;

//import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    //  UserDao userDao  = new UserDaoJDBCImpl();
    UserDao userDao  = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        System.out.println(name);
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
        userDao.removeUserById(id);
    }
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    public void cleanUsersTable() throws SQLException {
        userDao.cleanUsersTable();
    }
}
