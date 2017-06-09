package upwork.job.rest.api.facade;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.service.ModelService;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SaleFacadeImpl implements SaleFacade {

    @InjectParam
    private ModelService modelService;
    @InjectParam
    DefaultPopulator<Sale, SaleDto> salePopulator;

    @Override
    public SaleDto add(SaleDto saleDto) {
        Sale sale = salePopulator.convert(saleDto);
        modelService.add(sale);
        return saleDto;
    }
}
