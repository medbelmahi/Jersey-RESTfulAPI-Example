package upwork.job.rest.api.facade;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.service.ModelService;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class BuyerFacadeImpl implements BuyerFacade {

    @InjectParam
    DefaultPopulator<Buyer, BuyerDto> buyerPopulator;
    @InjectParam
    private ModelService modelService;

    @Override
    public BuyerDto add(BuyerDto buyerDto) {
        Buyer buyer = buyerPopulator.convert(buyerDto);
        modelService.add(buyer);
        return buyerDto;
    }

}
