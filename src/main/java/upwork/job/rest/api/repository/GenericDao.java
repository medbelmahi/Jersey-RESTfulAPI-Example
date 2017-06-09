package upwork.job.rest.api.repository;

import upwork.job.rest.api.model.GenericItem;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface GenericDao<T extends GenericItem> {
    void save(T item);
    void add(T item);

    T getItemById(Class genericClass, int id);

    List<T> getAll(Class genericClass);
}
