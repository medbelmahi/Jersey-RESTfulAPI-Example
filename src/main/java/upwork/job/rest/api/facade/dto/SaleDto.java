package upwork.job.rest.api.facade.dto;

import java.util.Date;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
public class SaleDto {
    public int sellerId;
    public int buyerId;
    public Date sellDate;
    public double amount;
    public SellerDto seller;
    public BuyerDto buyer;

}
