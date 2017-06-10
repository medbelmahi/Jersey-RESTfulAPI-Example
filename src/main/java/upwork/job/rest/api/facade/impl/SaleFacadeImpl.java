package upwork.job.rest.api.facade.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.SaleFacade;
import upwork.job.rest.api.facade.converter.impl.SalePopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSalePopulator;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.service.impl.DefaultModelService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
@Transactional
public class SaleFacadeImpl implements SaleFacade {

    @InjectParam
    private DefaultModelService modelService;
    @InjectParam
    private PureSalePopulator pureSalePopulator;
    @InjectParam
    private SalePopulator salePopulator;

    @Override
    public PureSale add(PureSale saleDto) {
        Sale sale = pureSalePopulator.convert(saleDto);
        modelService.add(sale);
        return saleDto;
    }

    @Override
    public List<SaleDto> getAllBuyerSales(int buyerId) {
        List<Sale> sales = ((Buyer) modelService.getItemById(Buyer.class, buyerId)).sales;
        List<SaleDto> saleDtos = new ArrayList<>();

        for (Sale sale : sales) {
            SaleDto saleDto = new SaleDto();
            salePopulator.populate(sale, saleDto);
            saleDtos.add(saleDto);
        }
        return saleDtos;
    }
}
