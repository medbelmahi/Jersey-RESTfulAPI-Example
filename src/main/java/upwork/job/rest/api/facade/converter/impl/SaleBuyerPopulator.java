package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureBuyerPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSalePopulator;
import upwork.job.rest.api.facade.dto.SaleBuyerDto;
import upwork.job.rest.api.facade.dto.pure.PureBuyer;
import upwork.job.rest.api.model.Sale;

/**
 * Created by MedBelmahi on 10/06/2017.
 */
@Singleton
public class SaleBuyerPopulator implements DefaultPopulator<Sale, SaleBuyerDto> {

    @InjectParam
    private PureSalePopulator pureSalePopulator;
    @InjectParam
    private PureBuyerPopulator pureBuyerPopulator;


    @Override
    public void populate(Sale sale, SaleBuyerDto saleBuyerDto) {
        pureSalePopulator.populate(sale, saleBuyerDto);
        saleBuyerDto.buyer = new PureBuyer();
        pureBuyerPopulator.populate(sale.buyer, saleBuyerDto.buyer);
    }

    @Override
    public Sale convert(SaleBuyerDto source) {
        return null;
    }
}
