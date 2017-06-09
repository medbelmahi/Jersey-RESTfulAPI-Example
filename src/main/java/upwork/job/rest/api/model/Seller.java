package upwork.job.rest.api.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Entity
@Table(name="SALE")
public class Seller extends GenericItem {

    @Column(name="PERMIT_NO")
    public int permitNo;
    @Column(name="NAME")
    public String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    public List<Sale> sales;

}
