package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureBuyerPopulator;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class BuyerPopulator implements DefaultPopulator<Buyer, BuyerDto> {

    @InjectParam
    SalePopulator salePopulator;
    @InjectParam
    PureBuyerPopulator pureBuyerPopulator;

    @Override
    public void populate(Buyer buyer, BuyerDto buyerDto) {
        pureBuyerPopulator.populate(buyer, buyerDto);
        List<SaleDto> sales = new ArrayList<>();
        for (Sale sale : buyer.sales) {
            SaleDto saleDto = new SaleDto();
            salePopulator.populate(sale, saleDto);
            sales.add(saleDto);
        }
        buyerDto.sales = sales;
    }

    @Override
    public Buyer convert(BuyerDto source) {
        Buyer buyer = new Buyer();
        buyer.age = source.age;
        buyer.isActive = source.isActive;
        buyer.name = source.name;
        List<Sale> sales = new ArrayList<>();
        for (SaleDto saleDto : source.sales) {
            Sale sale = salePopulator.convert(saleDto);
            sales.add(sale);
        }
        buyer.sales = sales;
        return buyer;
    }
}
