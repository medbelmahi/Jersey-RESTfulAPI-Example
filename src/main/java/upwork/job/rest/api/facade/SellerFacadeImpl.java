package upwork.job.rest.api.facade;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import upwork.job.rest.api.facade.converter.DefaultPopulator;
import upwork.job.rest.api.facade.converter.SellerPopulator;
import upwork.job.rest.api.facade.dto.PureSeller;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.model.Seller;
import upwork.job.rest.api.service.ModelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerFacadeImpl implements SellerFacade{

    @InjectParam
    private DefaultPopulator<Seller, SellerDto> sellerPopulator;
    @InjectParam
    private DefaultPopulator<Seller, PureSeller> pureSellerPopulator;
    @InjectParam
    private ModelService modelService;

    @Override
    public SellerDto add(SellerDto sellerDto) {
        Seller seller = sellerPopulator.convert(sellerDto);
        modelService.add(seller);
        return sellerDto;
    }

    @Override
    public List<PureSeller> allPureSeller() {

        List<Seller> sellers =  modelService.getAll(Seller.class);
        List<PureSeller> pureSellers = new ArrayList<>();
        for (Seller seller : sellers) {
            PureSeller pureSeller = new PureSeller();
            pureSellerPopulator.populate(seller, pureSeller);
            pureSellers.add(pureSeller);
        }

        return pureSellers;
    }
}
