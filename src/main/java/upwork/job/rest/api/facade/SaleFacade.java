package upwork.job.rest.api.facade;

import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.pure.PureSale;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public interface SaleFacade {
    PureSale add(PureSale saleDto);

    List<SaleDto> getAllBuyerSales(int buyerId);
}
