package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
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

    private BuyerPopulator buyerPupulator = new BuyerPopulator();
    private SellerPopulator sellerPupulator = new SellerPopulator();

    DateFormat df = new SimpleDateFormat("yyyyy-MM-dd");

    @Override
    public void populate(Sale sale, SaleDto saleDto) {

        BuyerDto buyer = new BuyerDto();
        buyerPupulator.populate(sale.buyer, buyer);
        saleDto.buyer = buyer;
        SellerDto seller = new SellerDto();
        sellerPupulator.populate(sale.seller, seller);
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
        sale.buyer = buyerPupulator.convert(source.buyer);
        sale.seller = sellerPupulator.convert(source.seller);
        return sale;
    }

}
