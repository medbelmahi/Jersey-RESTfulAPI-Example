package upwork.job.rest.api.facade.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.SellerFacade;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.converter.impl.SellerPopulator;
import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Seller;
import upwork.job.rest.api.service.impl.DefaultModelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerFacadeImpl implements SellerFacade {

    @InjectParam
    private PureSellerPopulator pureSellerPopulator;
    @InjectParam
    private SellerPopulator sellerPopulator;
    @InjectParam
    private DefaultModelService modelService;

    @Override
    public PureSeller add(PureSeller sellerDto) {
        Seller seller = pureSellerPopulator.convert(sellerDto);
        modelService.add(seller);
        return sellerDto;
    }

    @Override
    public List<PureSeller> allPureSeller() {

        List<Seller> sellers = (List<Seller>) modelService.getAll(Seller.class);
        List<PureSeller> pureSellers = new ArrayList<>();
        for (Seller seller : sellers) {
            PureSeller pureSeller = new PureSeller();
            pureSellerPopulator.populate(seller, pureSeller);
            pureSellers.add(pureSeller);
        }

        return pureSellers;
    }

    @Override
    public List<SellerDto> allSeller() {
        List<Seller> sellers = (List<Seller>) modelService.getAll(Seller.class);
        List<SellerDto> SellersDto = new ArrayList<>();
        for (Seller seller : sellers) {
            SellerDto sellerDto = new SellerDto();
            sellerPopulator.populate(seller, sellerDto);
            SellersDto.add(sellerDto);
        }

        return SellersDto;
    }
}
