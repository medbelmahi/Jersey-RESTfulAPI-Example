package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureBuyerPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Sale;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SalePopulator implements DefaultPopulator<Sale, SaleDto> {

    @InjectParam
    private PureBuyerPopulator pureBuyerPopulator;
    @InjectParam
    private PureSellerPopulator pureSellerPopulator;

    DateFormat df = new SimpleDateFormat("yyyyy-MM-dd");

    @Override
    public void populate(Sale sale, SaleDto saleDto) {

        BuyerDto buyer = new BuyerDto();
        pureBuyerPopulator.populate(sale.buyer, buyer);
        saleDto.buyer = buyer;
        SellerDto seller = new SellerDto();
        pureSellerPopulator.populate(sale.seller, seller);
        saleDto.seller = seller;
    }

    @Override
    public Sale convert(SaleDto source) {
        Sale sale = new Sale();
        sale.amount = source.amount;
        try {
            sale.sellDate = df.parse(source.sellDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sale.buyer = pureBuyerPopulator.convert(source.buyer);
        sale.seller = pureSellerPopulator.convert(source.seller);
        return sale;
    }

}
