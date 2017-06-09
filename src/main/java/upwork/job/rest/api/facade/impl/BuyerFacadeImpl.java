package upwork.job.rest.api.facade.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.BuyerFacade;
import upwork.job.rest.api.facade.converter.impl.pure.PureBuyerPopulator;
import upwork.job.rest.api.facade.dto.pure.PureBuyer;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.service.impl.DefaultModelService;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class BuyerFacadeImpl implements BuyerFacade {

    @InjectParam
    PureBuyerPopulator pureBuyerPopulator;
    @InjectParam
    private DefaultModelService modelService;

    @Override
    public PureBuyer add(PureBuyer buyerDto) {
        Buyer buyer = pureBuyerPopulator.convert(buyerDto);
        modelService.add(buyer);
        return buyerDto;
    }

}
