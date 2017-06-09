package upwork.job.rest.api.service;

import upwork.job.rest.api.model.GenericItem;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface  ModelService {

    void save(GenericItem item);
    void add(GenericItem item);

    GenericItem getItemById(int id);
}
