package upwork.job.rest.api.facade.converter;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Seller;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerPopulator implements DefaultPopulator<Seller, SellerDto> {
    @Override
    public void populate(Seller seller, SellerDto sellerDto) {

    }

    @Override
    public Seller convert(SellerDto source) {
        return null;
    }
}
