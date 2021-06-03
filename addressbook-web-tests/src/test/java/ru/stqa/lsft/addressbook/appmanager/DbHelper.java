package ru.stqa.lsft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.lsft.addressbook.model.*;

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

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<DateTestGroup> result = session.createQuery( "from DateTestGroup" ).list();
        for ( DateTestGroup group : result ) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactDate> result = session.createQuery( "from ContactDate" ).list();
        for ( ContactDate contact : result ) {
            System.out.println(contact);
        }
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }

    public ContactDate contact(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactDate> result = session.createQuery( "from ContactDate where id = \"" + id + "\"" ).list();
        for ( ContactDate contact : result ) {
            System.out.println(contact);
        }
        session.getTransaction().commit();
        session.close();
        return  result.iterator().next();
    }

    public int quantityConnects() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        List<Connects> result = session.createQuery( "from Connects" ).list().size();
        List<Connects1> result = session.createQuery( "from Connects1" ).list();
        session.getTransaction().commit();
        session.close();
        return result.size();
    }

}
