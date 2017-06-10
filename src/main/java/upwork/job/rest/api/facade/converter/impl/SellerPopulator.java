package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSalePopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.model.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerPopulator implements DefaultPopulator<Seller, SellerDto<PureSale>> {

    @InjectParam
    private PureSellerPopulator pureSellerPopulator;
    @InjectParam
    private PureSalePopulator pureSalePopulator;

    @Override
    public void populate(Seller seller, SellerDto sellerDto) {
        pureSellerPopulator.populate(seller, sellerDto);
        sellerDto.sales = new ArrayList<>();

        List<Sale> saleList = seller.sales;
        for (Sale sale : saleList) {
            PureSale saleDto = new PureSale();
            pureSalePopulator.populate(sale, saleDto);
            sellerDto.sales.add(saleDto);
        }
    }

    @Override
    public Seller convert(SellerDto<PureSale> source) {
        Seller seller = new Seller();
        seller.id = source.id;
        seller.name = source.name;
        seller.permitNo = source.permitId;

        List<Sale> sales = new ArrayList<>();
        for (PureSale saleDto : source.sales) {
            Sale saleModel = pureSalePopulator.convert(saleDto);
            sales.add(saleModel);
        }
        seller.sales = sales;
        return seller;
    }
}
