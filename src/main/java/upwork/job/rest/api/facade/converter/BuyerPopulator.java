package upwork.job.rest.api.facade.converter;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.model.Buyer;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class BuyerPopulator implements DefaultPopulator<Buyer, BuyerDto> {

    @Override
    public void populate(Buyer buyer, BuyerDto buyerDto) {

    }

    @Override
    public Buyer convert(BuyerDto source) {
        return null;
    }
}
