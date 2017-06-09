package upwork.job.rest.api.service;

import upwork.job.rest.api.model.GenericItem;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface  ModelService {

    void save(GenericItem item);
    void add(GenericItem item);

    GenericItem getItemById(Class genericClass, int id);

    List<? extends GenericItem> getAll(Class genericClass);
}
