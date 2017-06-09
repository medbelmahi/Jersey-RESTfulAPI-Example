package upwork.job.rest.api.repository;

import com.sun.jersey.spi.resource.Singleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import upwork.job.rest.api.config.HibernateUtil;
import upwork.job.rest.api.model.GenericItem;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class DefaultGenericDao implements GenericDao {

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
    public GenericItem getItemById(int id) {
        return null;
    }
}
