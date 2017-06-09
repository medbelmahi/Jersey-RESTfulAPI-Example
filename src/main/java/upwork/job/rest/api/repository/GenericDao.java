package upwork.job.rest.api.repository;

import upwork.job.rest.api.model.GenericItem;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface GenericDao<T extends GenericItem> {
    void save(T item);
    void add(T item);

    T getItemById(int id);
}
