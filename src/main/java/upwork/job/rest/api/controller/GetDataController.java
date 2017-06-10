package upwork.job.rest.api.controller;

import com.sun.jersey.api.core.InjectParam;
import upwork.job.rest.api.facade.dto.SaleDto;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.facade.impl.SaleFacadeImpl;
import upwork.job.rest.api.facade.impl.SellerFacadeImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Path("/")
public class GetDataController {

    @InjectParam
    SellerFacadeImpl sellerFacade;
    @InjectParam
    SaleFacadeImpl saleFacade;


    @GET
    @Path("sellers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PureSeller> getAllPureSellers() {
        return sellerFacade.allPureSeller();
    }

    @GET
    @Path("sellers-sales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SellerDto> getAllSellersSales() {
        return sellerFacade.allSeller();
    }

    @GET
    @Path("sellers-sales-buyers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SellerDto> getAllSellersSalesBuyers() {
        return sellerFacade.getAllSellersSalesBuyers();
    }

    @GET
    @Path("sales")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaleDto> getAllBuyerSales(@QueryParam("buyerId") int buyerId) {
        return saleFacade.getAllBuyerSales(buyerId);
    }
}
