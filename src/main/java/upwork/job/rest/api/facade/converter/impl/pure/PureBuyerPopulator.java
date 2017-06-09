package upwork.job.rest.api.facade.converter.impl.pure;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.dto.pure.PureBuyer;
import upwork.job.rest.api.model.Buyer;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class PureBuyerPopulator implements DefaultPopulator<Buyer, PureBuyer> {

    @Override
    public void populate(Buyer buyer, PureBuyer pureBuyer) {
        pureBuyer.id = buyer.id;
        pureBuyer.age = buyer.age;
        pureBuyer.isActive = buyer.isActive;
        pureBuyer.name = buyer.name;
    }

    @Override
    public Buyer convert(PureBuyer source) {
        Buyer buyer = new Buyer();
        buyer.id = source.id;
        buyer.age = source.age;
        buyer.isActive = source.isActive;
        buyer.name = source.name;
        return buyer;
    }
}
