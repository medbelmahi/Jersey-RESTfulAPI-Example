package upwork.job.rest.api.service.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.model.GenericItem;
import upwork.job.rest.api.repository.impl.DefaultGenericDao;
import upwork.job.rest.api.service.ModelService;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class DefaultModelService implements ModelService {

    @InjectParam
    DefaultGenericDao genericDao;

    @Override
    public void save(GenericItem item) {
        genericDao.save(item);
    }

    @Override
    public void add(GenericItem item) {
        genericDao.add(item);
    }

    @Override
    public GenericItem getItemById(Class genericClass, int id) {
        return genericDao.getItemById(genericClass, id);
    }

    @Override
    public List<? extends GenericItem> getAll(Class genericClass) {
        return genericDao.getAll(genericClass);
    }
}
