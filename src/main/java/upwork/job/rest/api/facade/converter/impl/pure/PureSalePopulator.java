package upwork.job.rest.api.facade.converter.impl.pure;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.model.Seller;
import upwork.job.rest.api.service.impl.DefaultModelService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class PureSalePopulator implements DefaultPopulator<Sale, PureSale> {

    @InjectParam
    DefaultModelService modelService;

    DateFormat df = new SimpleDateFormat("yyyyy-MM-dd");

    @Override
    public void populate(Sale sale, PureSale pureSale) {
        pureSale.amount = sale.amount;
        pureSale.buyerId = sale.buyer.id;
        pureSale.sellerId = sale.seller.id;
        pureSale.sellDate = df.format(sale.sellDate);
    }

    @Override
    public Sale convert(PureSale source) {
        Sale sale = new Sale();
        sale.amount = source.amount;
        sale.buyer = (Buyer) modelService.getItemById(Buyer.class, source.buyerId);
        sale.seller = (Seller) modelService.getItemById(Seller.class, source.sellerId);
        try {
            sale.sellDate = df.parse(source.sellDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sale;
    }
}
