package upwork.job.rest.api.repository.impl;

import com.sun.jersey.spi.resource.Singleton;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import upwork.job.rest.api.config.HibernateUtil;
import upwork.job.rest.api.model.GenericItem;
import upwork.job.rest.api.repository.GenericDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class DefaultGenericDao implements GenericDao<GenericItem> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(GenericItem item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }

    @Override
    public void add(GenericItem item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    @Override
    public GenericItem getItemById(Class genericClass, int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        GenericItem item = new GenericItem() {
        };
        try {
            tx = session.beginTransaction();
            item =
                    (GenericItem) session.get(genericClass, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public List<GenericItem> getAll(Class genericClass) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        List genericItemList = new ArrayList();
        try {
            tx = session.beginTransaction();
            genericItemList = session.createQuery("FROM " + genericClass.getName()).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return genericItemList;
    }
}
