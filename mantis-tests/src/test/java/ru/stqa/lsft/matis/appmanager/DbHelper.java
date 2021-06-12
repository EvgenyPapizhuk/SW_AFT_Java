package ru.stqa.lsft.matis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.lsft.matis.model.UserMantisModel;

import java.util.List;

public class DbHelper {

    private SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public List<UserMantisModel> users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserMantisModel> result = session.createQuery( "from UserMantisModel" ).list();
        for ( UserMantisModel users : result ) {
            System.out.println(users);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }

}
