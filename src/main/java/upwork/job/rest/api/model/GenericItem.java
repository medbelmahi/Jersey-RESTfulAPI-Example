package upwork.job.rest.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@MappedSuperclass
public abstract class GenericItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    public int id;
}
