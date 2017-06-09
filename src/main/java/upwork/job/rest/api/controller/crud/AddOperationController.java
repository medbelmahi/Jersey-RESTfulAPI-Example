package upwork.job.rest.api.controller.crud;

import com.sun.jersey.api.core.InjectParam;
import upwork.job.rest.api.facade.BuyerFacade;
import upwork.job.rest.api.facade.SaleFacade;
import upwork.job.rest.api.facade.SellerFacade;
import upwork.job.rest.api.facade.dto.BuyerDto;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.SellerDto;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Path("/add")
public class AddOperationController {

    @InjectParam
    SaleFacade saleFacade;
    @InjectParam
    BuyerFacade buyerFacade;
    @InjectParam
    SellerFacade sellerFacade;

    @POST
    @Path("/sale")
    @Produces(MediaType.APPLICATION_JSON)
    public SaleDto addSale(SaleDto saleDto)
    {
        return saleFacade.add(saleDto);
    }

    @POST
    @Path("/seller")
    @Produces(MediaType.APPLICATION_JSON)
    public SellerDto addSeller(SellerDto sellerDto)
    {
        return sellerFacade.add(sellerDto);
    }

    @POST
    @Path("/buyer")
    @Produces(MediaType.APPLICATION_JSON)
    public BuyerDto addBuyer(BuyerDto buyerDto)
    {
        return buyerFacade.add(buyerDto);
    }
}
