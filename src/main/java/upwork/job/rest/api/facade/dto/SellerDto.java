package upwork.job.rest.api.facade.dto;

import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.facade.dto.pure.PureSeller;

import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public class SellerDto<T extends PureSale> extends PureSeller {
    public List<T> sales;
}
