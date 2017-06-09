package upwork.job.rest.api.controller;

import com.sun.jersey.api.core.InjectParam;
import upwork.job.rest.api.facade.SellerFacade;
import upwork.job.rest.api.facade.dto.PureSeller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Path("/")
public class GetDataController {

    @InjectParam
    SellerFacade sellerFacade;


    @GET
    @Path("sellers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PureSeller> getAllPureSellers() {
        return sellerFacade.allPureSeller();
    }
}
