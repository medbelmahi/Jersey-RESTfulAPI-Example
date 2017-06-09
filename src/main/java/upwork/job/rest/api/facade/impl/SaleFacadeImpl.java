package upwork.job.rest.api.facade.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.SaleFacade;
import upwork.job.rest.api.facade.converter.impl.pure.PureSalePopulator;
import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.service.impl.DefaultModelService;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SaleFacadeImpl implements SaleFacade {

    @InjectParam
    private DefaultModelService modelService;
    @InjectParam
    private PureSalePopulator pureSalePopulator;

    @Override
    public PureSale add(PureSale saleDto) {
        Sale sale = pureSalePopulator.convert(saleDto);
        modelService.add(sale);
        return saleDto;
    }
}
