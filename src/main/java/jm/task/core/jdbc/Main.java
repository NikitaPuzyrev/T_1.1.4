package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

 /*
        //  UserDao userDao = new UserDaoJDBCImpl();*/
        UserDao userDao = new UserDaoHibernateImpl();


        userDao.createUsersTable();
        userDao.saveUser(" Un1 ", "Ul1 ", (byte) 20);
        userDao.saveUser(" Un ", "Ul ", (byte) 28);
        userDao.saveUser(" Un3 ", "Ul3 ", (byte) 27);
        userDao.saveUser(" Un4 ", "Ul4 ", (byte) 42);
        userDao.removeUserById(2);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
