package jm.task.core.jdbc.util;

import com.sun.xml.fastinfoset.sax.Properties;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();




        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mybase")
                .setProperty("hibernate.connection.username", "Nikita")
                .setProperty("hibernate.connection.password", "Nikita")
                .setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQLInnoDBDialect")

                .setProperty("hibernate.connection.SHOW_SQL", "true")
                .setProperty("hibernate.connection.format_sql", "true")
                .setProperty("hibernate.connection.CURRENT_SESSION_CONTEXT_CLASS", "thread");

        //  configuration.configure();


        configuration.addAnnotatedClass(User.class);


        return configuration.buildSessionFactory();
    }
}