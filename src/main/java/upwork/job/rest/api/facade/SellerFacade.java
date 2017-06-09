package upwork.job.rest.api.facade;

import upwork.job.rest.api.facade.dto.PureSeller;
import upwork.job.rest.api.facade.dto.SellerDto;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface SellerFacade {
    SellerDto add(SellerDto sellerDto);

    List<PureSeller> allPureSeller();
}
