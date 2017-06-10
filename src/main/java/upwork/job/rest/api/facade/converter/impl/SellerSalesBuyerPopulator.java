package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.dto.SaleBuyerDto;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.model.Seller;

import java.util.ArrayList;

/**
 * Created by MedBelmahi on 10/06/2017.
 */
@Singleton
public class SellerSalesBuyerPopulator implements DefaultPopulator<Seller, SellerDto<SaleBuyerDto>> {

    @InjectParam
    SaleBuyerPopulator saleBuyerPopulator;
    @InjectParam
    PureSellerPopulator pureSellerPopulator;

    @Override
    public void populate(Seller seller, SellerDto sellerDto) {
        pureSellerPopulator.populate(seller, sellerDto);
        sellerDto.sales = new ArrayList<SaleBuyerDto>();
        for (Sale sale : seller.sales) {
            SaleBuyerDto saleBuyerDto = new SaleBuyerDto();
            saleBuyerPopulator.populate(sale, saleBuyerDto);
            sellerDto.sales.add(saleBuyerDto);
        }
    }

    @Override
    public Seller convert(SellerDto source) {
        return null;
    }
}
