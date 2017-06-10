package upwork.job.rest.api.facade.impl;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.spi.resource.Singleton;
import org.hibernate.Session;
import org.hibernate.Transaction;
import upwork.job.rest.api.config.HibernateUtil;
import upwork.job.rest.api.facade.SellerFacade;
import upwork.job.rest.api.facade.converter.impl.SellerPopulator;
import upwork.job.rest.api.facade.converter.impl.SellerSalesBuyerPopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSalePopulator;
import upwork.job.rest.api.facade.converter.impl.pure.PureSellerPopulator;
import upwork.job.rest.api.facade.dto.SellerDto;
import upwork.job.rest.api.facade.dto.pure.PureSeller;
import upwork.job.rest.api.model.Seller;
import upwork.job.rest.api.service.impl.DefaultModelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MedBelmahi on 09/06/2017.
 */
@Singleton
public class SellerFacadeImpl implements SellerFacade {

    @InjectParam
    private PureSellerPopulator pureSellerPopulator;
    @InjectParam
    private SellerPopulator sellerPopulator;
    @InjectParam
    private PureSalePopulator pureSalePopulator;
    @InjectParam
    private DefaultModelService modelService;
    @InjectParam
    private SellerSalesBuyerPopulator sellerSalesBuyerPopulator;

    @Override
    public PureSeller add(PureSeller sellerDto) {
        Seller seller = pureSellerPopulator.convert(sellerDto);
        modelService.add(seller);
        return sellerDto;
    }

    @Override
    public List<PureSeller> allPureSeller() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        List<Seller> sellers = (List<Seller>) modelService.getAll(Seller.class);
        List<PureSeller> pureSellers = new ArrayList<>();
        for (Seller seller : sellers) {
            PureSeller pureSeller = new PureSeller();
            pureSellerPopulator.populate(seller, pureSeller);
            pureSellers.add(pureSeller);
        }

        transaction.commit();
        session.close();
        return pureSellers;
    }

    @Override
    public List<SellerDto> allSeller() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Seller> sellers = (List<Seller>) modelService.getAll(Seller.class);
        List<SellerDto> SellersDto = new ArrayList<>();
        for (Seller seller : sellers) {
            SellerDto sellerDto = new SellerDto();
            sellerPopulator.populate(seller, sellerDto);
            SellersDto.add(sellerDto);
        }
        session.close();
        return SellersDto;
    }

    @Override
    public List<SellerDto> getAllSellersSalesBuyers() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Seller> sellers = (List<Seller>) modelService.getAll(Seller.class);
        List<SellerDto> SellersDto = new ArrayList<>();
        for (Seller seller : sellers) {
            SellerDto sellerDto = new SellerDto();
            sellerSalesBuyerPopulator.populate(seller, sellerDto);
            SellersDto.add(sellerDto);
        }
        session.close();
        return SellersDto;
    }
}
