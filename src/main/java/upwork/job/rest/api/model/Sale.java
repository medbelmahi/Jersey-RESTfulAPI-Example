package upwork.job.rest.api.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Entity
@Table(name="SALE")
public class Sale extends GenericItem {

    @Column(name="SELL_DATE")
    public Date sellDate;
    @Column(name="AMOUNT")
    public double amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID", nullable = false)
    public Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUYER_ID", nullable = false)
    public Buyer buyer;

}
