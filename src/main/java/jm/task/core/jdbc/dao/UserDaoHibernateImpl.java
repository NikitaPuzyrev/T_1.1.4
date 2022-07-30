
package jm.task.core.jdbc.dao;

//import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

//import static jm.task.core.jdbc.util.HibernateUtil.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    List<User> list = new ArrayList<>();
    private Transaction transaction;

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sqlCommand = "CREATE TABLE IF NOT EXISTS User (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
        try (Session session = HibernateUtil.
                getSessionFactory().
                openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }

    @Override
    public void dropUsersTable() {
        String sqlCommand = "DROP TABLE IF EXISTS user";
        try (Session session = HibernateUtil.
                getSessionFactory().
                openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        String sqlCommand = "CREATE TABLE IF NOT EXISTS User (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), lastName VARCHAR(50), age INT )";
        try (Session session = HibernateUtil.
                getSessionFactory().
                openSession()) {
            transaction = session.beginTransaction();


            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();
            session.save(user);
            System.out.printf("User with name %s added to database." + "\n", name);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

       /* } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }*/


    }


    @Override
    public void removeUserById(long id) {
        try (Session session = HibernateUtil.
                getSessionFactory().
                openSession()) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }

    @Override
    public List getAllUsers() {
        try {
            Session session = HibernateUtil.
                    getSessionFactory().
                    openSession();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery);
            List listUser = query.getResultList();
            session.close();

            System.out.println(listUser);
            return listUser;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        String sqlCommand = "TRUNCATE User";
        try (Session session = HibernateUtil.
                getSessionFactory().
                openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery(sqlCommand).addEntity(User.class);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

    }
}
