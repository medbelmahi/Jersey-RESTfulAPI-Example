package upwork.job.rest.api.facade.converter.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import org.hibernate.Session;
import upwork.job.rest.api.config.HibernateUtil;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.model.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerPopulator implements DefaultPopulator<Seller, SellerDto> {

    @InjectParam
    private PureSellerPopulator pureSellerPopulator;
    @InjectParam
    private SalePopulator salePopulator;

    @Override
    public void populate(Seller seller, SellerDto sellerDto) {
        pureSellerPopulator.populate(seller, sellerDto);
        sellerDto.sales = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sale> saleList = seller.sales;
        System.out.println(saleList.size());
        for (Sale sale : saleList) {
            SaleDto saleDto = new SaleDto();
            salePopulator.populate(sale, saleDto);
            sellerDto.sales.add(saleDto);
        }
        session.close();
    }

    @Override
    public Seller convert(SellerDto source) {
        Seller seller = new Seller();
        seller.id = source.id;
        seller.name = source.name;
        seller.permitNo = source.permitNo;

        List<Sale> sales = new ArrayList<>();
        for (SaleDto saleDto : source.sales) {
            Sale saleModel = salePopulator.convert(saleDto);
            sales.add(saleModel);
        }
        seller.sales = sales;
        return seller;
    }
}
