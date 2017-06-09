package upwork.job.rest.api.service;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.model.GenericItem;
import upwork.job.rest.api.repository.GenericDao;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class DefaultModelService implements ModelService {

    @InjectParam
    GenericDao genericDao;

    @Override
    public void save(GenericItem item) {
        genericDao.save(item);
    }

    @Override
    public void add(GenericItem item) {
        genericDao.add(item);
    }

    @Override
    public GenericItem getItemById(int id) {
        return null;
    }
}
