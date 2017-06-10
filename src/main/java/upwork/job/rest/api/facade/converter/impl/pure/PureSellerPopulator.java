package upwork.job.rest.api.facade.converter.impl.pure;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.model.Seller;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class PureSellerPopulator implements DefaultPopulator<Seller, PureSeller> {

    @Override
    public void populate(Seller seller, PureSeller pureSeller) {
        pureSeller.id = seller.id;
        pureSeller.name = seller.name;
        pureSeller.permitId = seller.permitNo;
    }

    @Override
    public Seller convert(PureSeller source) {
        Seller seller = new Seller();
        seller.id = source.id;
        seller.name = source.name;
        seller.permitNo = source.permitId;
        return seller;
    }
}
