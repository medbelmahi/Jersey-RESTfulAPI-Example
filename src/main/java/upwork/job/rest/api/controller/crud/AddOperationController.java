package upwork.job.rest.api.controller.crud;

import com.sun.jersey.api.core.InjectParam;
import upwork.job.rest.api.facade.dto.pure.PureBuyer;
import upwork.job.rest.api.facade.dto.pure.PureSale;
import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.facade.impl.BuyerFacadeImpl;
import upwork.job.rest.api.facade.impl.SaleFacadeImpl;
import upwork.job.rest.api.facade.impl.SellerFacadeImpl;

import javax.ws.rs.Consumes;
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
    SaleFacadeImpl saleFacade;
    @InjectParam
    BuyerFacadeImpl buyerFacade;
    @InjectParam
    SellerFacadeImpl sellerFacade;

    @POST
    @Path("/sale")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PureSale addSale(PureSale saleDto)
    {
        return saleFacade.add(saleDto);
    }

    @POST
    @Path("/seller")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PureSeller addSeller(PureSeller sellerDto)
    {
        return sellerFacade.add(sellerDto);
    }

    @POST
    @Path("/buyer")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PureBuyer addBuyer(PureBuyer buyerDto)
    {
        return buyerFacade.add(buyerDto);
    }
}
