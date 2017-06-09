package upwork.job.rest.api.facade.converter;

import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Buyer;
import upwork.job.rest.api.model.Sale;
import upwork.job.rest.api.model.Seller;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SalePopulator implements DefaultPopulator<Sale, SaleDto> {

    DefaultPopulator<Buyer, BuyerDto> buyerPupulator = new BuyerPopulator();
    DefaultPopulator<Seller, SellerDto> sellerPupulator = new SellerPopulator();

    @Override
    public void populate(Sale sale, SaleDto saleDto) {
        saleDto.amount = sale.amount;
        saleDto.buyerId = sale.buyer.id;
        saleDto.sellerId = sale.seller.id;
        BuyerDto buyer = new BuyerDto();
        buyerPupulator.populate(sale.buyer, buyer);
        saleDto.buyer = buyer;
        SellerDto seller = new SellerDto();
        sellerPupulator.populate(sale.seller, seller);
        saleDto.seller = seller;
    }

    @Override
    public Sale convert(SaleDto source) {
        return null;
    }

}
