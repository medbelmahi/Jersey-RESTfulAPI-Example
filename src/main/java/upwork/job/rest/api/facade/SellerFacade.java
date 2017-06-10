package upwork.job.rest.api.facade;

import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.facade.dto.SellerDto;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface SellerFacade {
    PureSeller add(PureSeller sellerDto);

    List<PureSeller> allPureSeller();

    List<SellerDto> allSeller();

    List<SellerDto> getAllSellersSalesBuyers();

}
