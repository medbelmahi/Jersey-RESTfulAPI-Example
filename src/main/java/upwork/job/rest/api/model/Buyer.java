package upwork.job.rest.api.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Entity
@Table(name="BUYER")
public class Buyer extends GenericItem {

    @Column(name="AGE")
    public int age;
    @Column(name="IS_ACTIVE")
    public boolean isActive;
    @Column(name="NAME")
    public String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
    public List<Sale> sales;

}
